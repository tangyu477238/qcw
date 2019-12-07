package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.LirunDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.service.CustomService;
import com.bootdo.gc.service.SequenceService;
import com.bootdo.gc.service.SijiService;
import com.bootdo.system.domain.UserDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:02
 */
 
@Controller
@RequestMapping("/gc/siji")
public class SijiController extends BaseController {
	@Autowired
	private SijiService sijiService;

	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private CustomService customService;

	
	@GetMapping()
	String Siji(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/siji";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){

		//查询列表数据
        Query query = new Query(params);
		List<SijiDO> sijiList = sijiService.list(query);
		int total = sijiService.count(query);
		PageUtils pageUtils = new PageUtils(sijiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(@RequestParam Map<String, Object> params,Model model){

		model.addAttribute("deptId", params.get("deptId"));

		params.put("stype", "station");
		List<Map<String, Object>> issueofficeList = customService.getCustomList(params); //到站
		model.addAttribute("issueofficeList", issueofficeList);

		params.put("stype", "fhdw");
		List<Map<String, Object>> fhdwList = customService.getCustomList(params); //发货单位
		model.addAttribute("fhdwList", fhdwList);

		params.put("stype", "fkdw");
		List<Map<String, Object>> fkdwList = customService.getCustomList(params); //付款单位
		model.addAttribute("fkdwList", fkdwList);

		return "gc/siji/add";
	}

	@GetMapping("/edit")

	String edit(@RequestParam Map<String, Object> params,Model model){

		model.addAttribute("deptId", params.get("deptId"));

		params.put("stype", "station");
		List<Map<String, Object>> issueofficeList = customService.getCustomList(params); //到站
		model.addAttribute("issueofficeList", issueofficeList);

		params.put("stype", "fhdw");
		List<Map<String, Object>> fhdwList = customService.getCustomList(params); //发货单位
		model.addAttribute("fhdwList", fhdwList);

		params.put("stype", "fkdw");
		List<Map<String, Object>> fkdwList = customService.getCustomList(params); //付款单位
		model.addAttribute("fkdwList", fkdwList);

		Long id = Long.parseLong(params.get("id").toString());

		SijiDO siji = sijiService.get(id);
		model.addAttribute("siji", siji);
	    return "gc/siji/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( SijiDO siji){

		UserDO userDo = getUser();

		siji.setOrderNo(sequenceService.getSequence(userDo.getImei()));
		siji.setDeptId(userDo.getDeptId());
		siji.setUpdatedName(userDo.getName());
		if(sijiService.save(siji)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( SijiDO siji){
		UserDO userDo = getUser();
		siji.setDeptId(userDo.getDeptId());
		siji.setUpdatedName(userDo.getName());
		if(sijiService.update(siji)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败,付款已回单！");
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(sijiService.remove(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败,有关联单据！");
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody

	public R remove(@RequestParam("ids[]") Long[] ids){
//		sijiService.batchRemove(ids);
//		return R.ok();

		if(sijiService.batchRemove(ids)>0){
			return R.ok();
		}
		return R.error2();
	}



	// 导出全部数据
	@RequestMapping("/export")
	public void exportstudent(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {

		List<SijiDO> kehuList = sijiService.getExcelList(params);

		ExcelUtil.exportExcel(kehuList,null,
				"发货统计表",SijiDO.class,"发货统计表.xls",res);


	}





	@RequestMapping("/sijiMx")
	public String SijiMx(String pid, Model model) {

		model.addAttribute("pid", pid);

		//返回ModelAndView对象view
		return "gc/siji/sijiMx";
	}



	@RequestMapping("/updatePrice")
	public String updatePrice(@RequestParam Map<String, Object> params, Model model) {

		model.addAttribute("ids", params.get("ids").toString());

		String[] ids = params.get("ids").toString().split(",");
		Map map = sijiService.getDunSum(ids);

		model.addAttribute("dunwei", map.get("tonnage"));
		model.addAttribute("arrivstation", params.get("arrivstation"));
        model.addAttribute("inforfee", params.get("inforfee"));
		return "gc/siji/editPiliangPrice";
	}



	@GetMapping("/queryTotalPage")
	String queryTotalPage(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		for (int i = 0;i<12;i++){
			model.addAttribute("bizMonth"+i, DateUtils.getNowMonth(-i));
		}
		return "gc/siji/queryTotal";
	}

	@ResponseBody
	@GetMapping("/queryTotal")
	List<Map> queryTotal(Long deptId,String inforfee,String inputdate){
		Map map = new HashMap();
		map.put("deptId",deptId);
        map.put("inforfee",inforfee);
		map.put("inputdate",inputdate);
		return sijiService.queryTotal(map);
	}


	@GetMapping("/queryLirunPage")
	String queryLirunPage(Long deptId,Model model){
		model.addAttribute("deptId", deptId);

		return "gc/siji/queryLirun";
	}

	@ResponseBody
	@GetMapping("/queryLirun")
	List<LirunDO> queryLirun(@RequestParam Map<String, Object> params){
		if (params.get("arrivstation")!=null){
			if (!"".equals(params.get("arrivstation").toString())
					&& !"null".equals(params.get("arrivstation").toString())){
				String s ="";
				params.put("arrivstation",params.get("arrivstation").toString().split(","));
			} else {
				params.remove("arrivstation");
			}

		}

		return sijiService.queryLirun(params);
	}



	// 导出全部数据
	@RequestMapping("/exportLirun")
	public void exportLirun(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {
		if (params.get("arrivstation")!=null){
			if (!"".equals(params.get("arrivstation").toString())
					&& !"null".equals(params.get("arrivstation").toString())){
				params.put("arrivstation",params.get("arrivstation").toString().split(","));
			} else {
				params.remove("arrivstation");
			}

		}
		List<LirunDO> kehuList = sijiService.queryLirun(params);

		ExcelUtil.exportExcel(kehuList,null,
				"利润表",LirunDO.class,"利润表.xls",res);


	}




	@ResponseBody
	@GetMapping("/arrivstation")
	List<Map> arrivstation(@RequestParam Map<String, Object> params){

		return sijiService.arrivstation(params);
	}



	/**
	 * 批量价格修改
	 */
	@ResponseBody
	@PostMapping("/updatePiliangPrice")

	public R updatePiliangPrice(@RequestParam Map<String, Object> params){

		int count = 0;
		String ids [] = params.get("ids").toString().split(",");
		for (String str : ids){
			params.put("pid", str);
			count = sijiService.updatePiliangPrice(params);
		}

		if (count>0) {
			return R.ok();
		}
		return R.errorMsg("操作失败！");
	}



}
