package com.bootdo.gc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.LirunDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.domain.SijiItemInvoiceDO;
import com.bootdo.gc.domain.YingshoukuanDO;
import com.bootdo.gc.service.CustomService;
import com.bootdo.gc.service.SequenceService;
import com.bootdo.gc.service.SijiService;
import com.bootdo.system.domain.UserDO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

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



	@RequestMapping("/shuilv")
	public String shuilv(@RequestParam Map<String, Object> params, Model model) {

		model.addAttribute("ids", params.get("ids").toString());



		model.addAttribute("arrivstation", params.get("arrivstation"));
		model.addAttribute("inforfee", params.get("inforfee"));

		return "gc/siji/editPiliangShuilv";
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

	// 导出应收款统计
	@RequestMapping("/excelTotal")
	public void excelTotal(HttpServletRequest request,
						   HttpServletResponse response,
						   @RequestParam Map<String, Object> params) throws IOException {

		List<Map> maps = sijiService.excelTotal(params);



//		ExcelUtil.exportExcel(totallist,null,
//				"应收款统计表",YingshoukuanDO.class,"应收款统计.xls",res);

		if(maps!=null && maps.size()>0){
			String Title = "应收款统计";


//			String [] arry1 = {"A","B","C","D","E"};
//			String [] arry2 = {"F","G","H","I","J"};
//			int arryLen1=arry1.length;//获取第一个数组长度
//			int arryLen2=arry2.length;//获取第二个数组长度
//
//			arry1= Arrays.copyOf(arry1,arryLen1+ arryLen2);//把第一个数组扩大
//			System.arraycopy(arry2, 0, arry1, arryLen1,arryLen2 );//将两个数组进行合并
//			System.out.println(Arrays.toString(arry1));//输出合并后的数组

			String[]str1=new String[]{"付款单位"};
			String[]str2=new String[12];
			for (int i = 0; i<12; i++){
				str2[11-i] = DateUtils.getNowMonth(-i);
			}
			String [] str3 = new String[]{"当日开票","当日回款","调整金额","余额"};  //设置表格表头字段

			String[] totalArr = mergeArray2(str1, str2);
			String[] title = mergeArray2(totalArr, str3);


			String [] properties = new String[]{"inforfee","bizMonth11","bizMonth10","bizMonth9"
					,"bizMonth8","bizMonth7","bizMonth6","bizMonth5","bizMonth4","bizMonth3"
					,"bizMonth2","bizMonth1","bizMonth0","dayTakeamount","dayInvoamount"
					,"tiaozheng","totalAmount"};  // 查询对应的字段
			com.bootdo.common.utils.ExcelExportUtil excelExport2 = new com.bootdo.common.utils.ExcelExportUtil();
			excelExport2.setTitle(Title);
			excelExport2.setHeardList(title);
			excelExport2.setHeardKey(properties);
			excelExport2.setData(maps);
			excelExport2.exportExport(request, response);
		}

	}



	/***
	 * merge two array
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static String[] mergeArray2(String[]arr1,String[]arr2){
		int length1=arr1.length;
		int length2=arr2.length;
		int totalLength=length1+length2;
		String[]totalArr=new String[totalLength];
		for(int i=0;i<length1;i++){
			totalArr[i]=arr1[i];
		}
		for(int i=0;i<length2;i++){
			totalArr[i+length1]=arr2[i];
		}
		return totalArr;
	}


	@GetMapping("/queryLirunPage")
	String queryLirunPage(Long deptId,Model model){
		model.addAttribute("deptId", deptId);

		return "gc/siji/queryLirun";
	}

	@ResponseBody
	@GetMapping("/queryLirun")
	public PageUtils queryLirun(@RequestParam Map<String, Object> params){
		if (params.get("arrivstation")!=null){
			if (!"".equals(params.get("arrivstation").toString())
					&& !"null".equals(params.get("arrivstation").toString())){
				String s ="";
				params.put("arrivstation",params.get("arrivstation").toString().split(","));
			} else {
				params.remove("arrivstation");
			}

		}
		Query query = new Query(params);
		List<LirunDO> list = sijiService.queryLirun(query);
		int total = 1;
		PageUtils pageUtils = new PageUtils(list, total);

		return pageUtils;
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



	/**
	 * 批量税率修改
	 */
	@ResponseBody
	@PostMapping("/updatePiliangShuilv")

	public R updatePiliangShuilv(@RequestParam Map<String, Object> params){

		int count = 0;
		String ids [] = params.get("ids").toString().split(",");
		for (String str : ids){
			params.put("orderNo", str);
			count = sijiService.updatePiliangShuilv(params);
		}

		if (count>0) {
			return R.ok();
		}
		return R.errorMsg("操作失败！");
	}


}
