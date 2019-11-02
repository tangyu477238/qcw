package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.gc.domain.SijiItemAminvoiceDO;
import com.bootdo.gc.domain.SijiItemImp1;
import com.bootdo.gc.domain.SijiItemImp2;
import com.bootdo.gc.service.SijiItemAminvoiceService;
import com.bootdo.gc.service.SijiItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-02 12:28:23
 */
 
@Controller
@RequestMapping("/gc/sijiItemAminvoice")
public class SijiItemAminvoiceController extends BaseController {
	@Autowired
	private SijiItemAminvoiceService sijiItemService;


	//跳转交单明细表
	@GetMapping("/bill")
	String sijiItemBill(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemBill";
	}


	//跳转待收款明细表
	@GetMapping()
	String sijiItemAminvoice(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemAminvoice";
	}


//	//显示规格明细
//	@GetMapping("/sijiMx/{id}")
//	String sijiMx(@PathVariable("id") Long id, Model model){
//
//		return "gc/siji/sijiMx";
//	}




	//获取待结算（已开票）明细数据
	@ResponseBody
	@GetMapping("/list")
	public PageUtils querySijiList(@RequestParam Map<String, Object> params){
		//查询列表数据

		Query query = new Query(params);
		List<Map> sijiItemList = sijiItemService.querySijiList(query);

		int total = sijiItemService.querySijiListCount(query);
		PageUtils pageUtils = new PageUtils(sijiItemList, total);
		return pageUtils;
	}




	//获取已交单数据清单
	@ResponseBody
	@GetMapping("/getBilldateList")
	public PageUtils getBilldateList(@RequestParam Map<String, Object> params){
		//查询列表数据

		Query query = new Query(params);
		List<SijiItemAminvoiceDO> sijiItemList = sijiItemService.getBilldateList(params);

		int total = 1;
		PageUtils pageUtils = new PageUtils(sijiItemList, total);
		return pageUtils;
	}






	/**
	 *  交单列表---->跳转开始开票界面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/editItem/{id}")
	String editItem(@PathVariable("id") String id,Model model){
		SijiItemAminvoiceDO siji = sijiItemService.getBillInfoByPid(id);
		model.addAttribute("siji", siji);

		Map<String, Object> params = new HashMap();
		List<Map<String, Object>> issueofficeList = sijiItemService.getIssueoffice(params);
		model.addAttribute("issueofficeList", issueofficeList);

		return "gc/siji/editItemBill";
	}




	/**
	 * 开票保存 ---->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updateItem")
	public R updateItem(SijiItemAminvoiceDO siji){

		sijiItemService.updateItem(siji);

		return R.ok();
	}











//
//	//发货新增或者修改的----->规格列表
//	@ResponseBody
//	@GetMapping("/itemList")
//	public List<SijiItemAminvoiceDO> itemList(@RequestParam Map<String, Object> params){
//
//		List<SijiItemAminvoiceDO> sijiItemList = sijiItemService.list(params);
//
//		return sijiItemList;
//	}



//
//
//	/**
//	 * //发货新增----->保存、或者修改保持。itemId是否有值决定
//	 */
//	@ResponseBody
//	@PostMapping("/save")
//	public R save( SijiItemAminvoiceDO sijiItem){
//
//
//
//		sijiItem.setTranrate(sijiItem.getBaseprice().multiply(sijiItem.getCoefficient()));
//		sijiItem.setTrancost(sijiItem.getTranrate().multiply(sijiItem.getTonnage()));
//
//		int flag;
//		if (sijiItem.getId()!=null && !"".equals(sijiItem.getId())){
//			flag = sijiItemService.update(sijiItem);
//		} else {
//			flag = sijiItemService.save(sijiItem);
//		}
//		if(flag>0){
//			return R.ok();
//		} else {
//			return R.errorMsg("操作失败,付款已回单！");
//		}
//
//	}


//	/**
//	 * //发货新增或者修改的----->修改
//	 */
//	@ResponseBody
//	@RequestMapping("/update")
//	public R update( SijiItemAminvoiceDO sijiItem){
//		sijiItemService.update(sijiItem);
//		return R.ok();
//	}

//
//
//	@GetMapping("/updateItem/{id}")
//	@ResponseBody
//	SijiItemAminvoiceDO updateItem(@PathVariable("id") Long id){
//		SijiItemAminvoiceDO siji = sijiItemService.getItemDo(id);
//
//		return siji;
//	}




//
	/**
	 * //结算明细单----->删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sijiItemService.remove(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败！");
	}

//
//
//	@ResponseBody
//	@PostMapping( "/heDui")
//	public R heDui(Long id){
//
//		sijiItemService.heDui(id);
//		return R.ok();
//	}
//

	
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("gc:sijiItem:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] ids){
//		sijiItemService.batchRemove(ids);
//		return R.ok();
//	}






//	@PostMapping("/importExcel")
//	@ResponseBody
//	public R importExcel(@RequestParam("file") MultipartFile file) {
//		List<SijiItemImp1> imp1s = FileUtil.importExcel(file, 0, 1, SijiItemImp1.class);
//		sijiItemService.importExcel(imp1s);
//		return R.ok();
//	}
//
//
//
//
//
//	@PostMapping("/importExcel2")
//	@ResponseBody
//	public R importExcel2(@RequestParam("file") MultipartFile file) {
//		List<SijiItemImp2> imp2s = FileUtil.importExcel(file, 0, 1, SijiItemImp2.class);
//		sijiItemService.importExcel2(imp2s);
//		return R.ok();
//	}







}
