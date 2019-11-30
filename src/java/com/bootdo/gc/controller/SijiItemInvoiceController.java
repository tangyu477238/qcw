package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.gc.domain.SijiItemInvoiceDO;
import com.bootdo.gc.service.CustomService;
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

	@Autowired
	private CustomService customService;



	//跳转结算明细表
	@GetMapping()
	String SijiItemInvoice(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemInvoice";
	}




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
	 * @param params
	 * @param model
	 * @return
	 */
	@GetMapping("/editItem")
	String editItem(@RequestParam Map<String, Object> params, Model model){
		SijiItemInvoiceDO siji = sijiItemService.getAminvoicefoById(params.get("id").toString());
		model.addAttribute("siji", siji);

		params.put("stype", "skfs");
		List<Map<String, Object>> issueofficeList = customService.getCustomList(params);
		model.addAttribute("issueofficeList", issueofficeList);

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
	 * @param params
	 * @param model
	 * @return
	 */
	@GetMapping("/editPiliang")
	String editPiliang(@RequestParam Map<String, Object> params, Model model){
		model.addAttribute("ids", params.get("ids"));

		params.put("stype", "skfs");
		List<Map<String, Object>> issueofficeList = customService.getCustomList(params);
		model.addAttribute("issueofficeList", issueofficeList);

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
	/**
	 * //gc_siji_item_invoice明细单----->删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove(Long id){

		int flag = sijiItemService.remove(id);

		if(flag>0){
			return R.ok();
		} else if (flag == -1){
			return R.errorMsg("操作失败！此单非最后一次录入的订单！");
		} else if (flag == -2){
			return R.errorMsg("操作失败！此单录入日期非当天！");
		}
		return R.errorMsg("操作失败！录入日期可能非当天");
	}


	@PostMapping( "/removeAdmin")
	@ResponseBody
	public R removeAdmin(Long id){
		if(sijiItemService.removeAdmin(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败！录入日期可能非当天");
	}






}
