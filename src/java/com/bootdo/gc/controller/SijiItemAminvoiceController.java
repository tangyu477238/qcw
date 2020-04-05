package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.SijiDO;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


	//跳转待收款明细表
	@GetMapping()
	String sijiItemAminvoice(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemAminvoice";
	}


	//跳转----对账明细列表
	@GetMapping("sijiItemDuizhang")
	String sijiItemDuizhang(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemDuizhang";
	}



	//获取对账明细列表
	@ResponseBody
	@GetMapping("/getDuizhangList")
	public PageUtils getDuizhangList(@RequestParam Map<String, Object> params){
		//查询列表数据

		Query query = new Query(params);
		List<SijiItemAminvoiceDO> sijiItemList = sijiItemService.getDuizhangList(query);

		int total = sijiItemService.getDuizhangListCount(query);
		PageUtils pageUtils = new PageUtils(sijiItemList, total);
		return pageUtils;
	}


	// 导出全部数据
	@RequestMapping("/exportDuizhang")
	public void exportDuizhang(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {

		List<SijiItemAminvoiceDO> sijiItemList = sijiItemService.getDuizhangList(params);

		ExcelUtil.exportExcel(sijiItemList,null,
				"对账明细表",SijiItemAminvoiceDO.class,"对账明细表.xls",res);


	}





	//跳转交单明细表
	@GetMapping("/bill")
	String sijiItemBill(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemBill";
	}








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
	 *  editPiliang---->批量开票
	 * @param params
	 * @param model
	 * @return
	 */
	@GetMapping("/editPiliang")
	String editPiliang(@RequestParam Map<String, Object> params, Model model){

		model.addAttribute("ids", params.get("ids"));

		params.put("stype", "kpdw");
		List<Map<String, Object>> issueofficeList = sijiItemService.getIssueoffice(params);
		model.addAttribute("issueofficeList", issueofficeList);

		return "gc/siji/editPiliangBill";
	}



	/**
	 *  交单列表---->跳转开始开票界面
	 * @param params
	 * @param model
	 * @return
	 */
	@GetMapping("/editItem")
	String editItem(@RequestParam Map<String, Object> params, Model model){
		String id = params.get("id").toString();
		SijiItemAminvoiceDO siji = sijiItemService.getBillInfoByPid(id);
		model.addAttribute("siji", siji);

		params.put("stype", "kpdw");
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


	/**
	 * 批量开票保存 ---->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/piliangSave")
	public R piliangSave(@RequestParam Map<String, Object> params){

		String id = params.get("ids").toString();
		String ids [] = id.split(",");
		params.put("array", ids);

		sijiItemService.getBilldateArray(params);

		return R.ok();
	}










//
	/**
	 * //结算明细单----->删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){

		int flag = sijiItemService.remove(id);
		if(flag>0){
			return R.ok();
		} else if (flag == -1){
			return R.errorMsg("操作失败！此单非最后一次录入的订单！");
		} else if (flag == -2){
			return R.errorMsg("操作失败！此单录入日期非当天！");
		}
		return R.errorMsg("操作失败！此单已产生回款！");
	}
	/**
	 * //待开票数据清除----->删除
	 */
	@PostMapping( "/removeBill")
	@ResponseBody
	public R removeBill(String id){
		if(sijiItemService.removeBill(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败！或已产生开票！");
	}




	/**
	 * //结算明细单----->删除
	 */
	@PostMapping( "/removeAdmin")
	@ResponseBody
	public R removeAdmin( Long id){
		if(sijiItemService.remove(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败！录入日期可能非当天或已产生回款！");
	}










}
