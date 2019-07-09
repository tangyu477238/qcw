package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.SijiDO;
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

	String add(){
	    return "gc/siji/add";
	}

	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
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


		ExcelUtil.exportExcel(kehuList,"发货统计表",
				"发货统计表",SijiDO.class,"发货统计表.xls",res);


	}





	@RequestMapping("/sijiMx")
	public String SijiMx(String pid, Model model) {
		//构建ModelAndView实例，并设置跳转地址
//		ModelAndView view = new ModelAndView("gc/siji/sijiMx");
//		//将数据放置到ModelAndView对象view中,第二个参数可以是任何java类型
//		view.addObject();

		model.addAttribute("pid", pid);

		//返回ModelAndView对象view
		return "gc/siji/sijiMx";
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
	List<Map> queryTotal(Long deptId,String inforfee){
		Map map = new HashMap();
		map.put("deptId",deptId);
        map.put("inforfee",inforfee);
		return sijiService.queryTotal(map);
	}


}
