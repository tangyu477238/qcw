package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.gc.domain.SijiItemInvoiceDO;
import com.bootdo.gc.service.SijiItemInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/gc/sijiItemInvoice")
public class SijiItemInvoiceController extends BaseController {
	@Autowired
	private SijiItemInvoiceService sijiItemService;




	//跳转结算明细表
	@GetMapping()
	String SijiItemInvoice(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemInvoice";
	}


//	//显示规格明细
//	@GetMapping("/sijiMx/{id}")
//	String sijiMx(@PathVariable("id") Long id, Model model){
//
//		return "gc/siji/sijiMx";
//	}




	//展示发货明细数据
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




	//已开票数据清单
	@ResponseBody
	@GetMapping("/getBilldateList")
	public PageUtils getBilldateList(@RequestParam Map<String, Object> params){
		//查询列表数据

		Query query = new Query(params);
		List<SijiItemInvoiceDO> sijiItemList = sijiItemService.getBilldateList(query);

		int total = sijiItemService.querySijiListCount(query);
		PageUtils pageUtils = new PageUtils(sijiItemList, total);
		return pageUtils;
	}






	/**
	 *  待结算列表---->跳转开始gc_siji_item_invoice（收款）界面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/editItem/{id}")
	String editItem(@PathVariable("id") String id,Model model){
		SijiItemInvoiceDO siji = sijiItemService.getAminvoicefoById(id);
		model.addAttribute("siji", siji);
		return "gc/siji/editItemAminvoice";
	}




	/**
	 * 收款保存 ---->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updateItem")
	public R updateItem(SijiItemInvoiceDO siji){

		sijiItemService.updateItem(siji);

		return R.ok();
	}





	/**
	 *  待结算列表--批量-->跳转开始gc_siji_item_invoice（收款）界面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/editPiliang/{ids}")
	String editPiliang(@PathVariable("ids") String ids,Model model){
		model.addAttribute("ids", ids);

		return "gc/siji/editPiliangAminvoice";
	}



	/**
	 * 收款保存 --批量-->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updatePiliang")
	public R updatePiliang(@RequestParam Map<String, Object> params){

		String id = params.get("ids").toString();
		String ids [] = id.split(",");
		params.put("array", ids);

		sijiItemService.getInvoicedateArray(params);

		return R.ok();
	}






//
//	//发货新增或者修改的----->规格列表
//	@ResponseBody
//	@GetMapping("/itemList")
//	public List<SijiItemInvoiceDO> itemList(@RequestParam Map<String, Object> params){
//
//		List<SijiItemInvoiceDO> sijiItemList = sijiItemService.list(params);
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
//	public R save( SijiItemInvoiceDO sijiItem){
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
//	public R update( SijiItemInvoiceDO sijiItem){
//		sijiItemService.update(sijiItem);
//		return R.ok();
//	}

//
//
//	@GetMapping("/updateItem/{id}")
//	@ResponseBody
//	SijiItemInvoiceDO updateItem(@PathVariable("id") Long id){
//		SijiItemInvoiceDO siji = sijiItemService.getItemDo(id);
//
//		return siji;
//	}




//
	/**
	 * //gc_siji_item_invoice明细单----->删除
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
