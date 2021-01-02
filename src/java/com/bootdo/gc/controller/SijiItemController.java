package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.gc.domain.JiesuanDO;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.domain.SijiItemImp1;
import com.bootdo.gc.domain.SijiItemImp2;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.system.domain.UserDO;
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
@RequestMapping("/gc/sijiItem")
public class SijiItemController extends BaseController {
	@Autowired
	private SijiItemService sijiItemService;



	//发货明细表(待对账)
	@GetMapping("/daiduizhang")
	String daiduizhang(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItemDaiduizhang";
	}


	//发货明细表(待对账)
	@ResponseBody
	@GetMapping("/daiduizhanglist")
	public PageUtils daiduizhanglist(@RequestParam Map<String, Object> params){
		//查询列表数据

		Query query = new Query(params);
		List<Map> sijiItemList = sijiItemService.daiduizhanglist(query);

		int total = sijiItemService.daiduizhanglistCount(query);
		PageUtils pageUtils = new PageUtils(sijiItemList, total);
		return pageUtils;
	}




	//发货明细表
	@GetMapping()
	String sijiItem(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/siji/sijiItem";
	}


	//显示规格明细
	@GetMapping("/sijiMx/{id}")
	String sijiMx(@PathVariable("id") Long id, Model model){

		return "gc/siji/sijiMx";
	}




	//对账明细表
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


	/**
	 * 对账明细表 ---->跳转编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/editItem/{id}")
	String editItem(@PathVariable("id") Long id,Model model){
		SijiItemDO siji = sijiItemService.get(id);
		model.addAttribute("siji", siji);
		return "gc/siji/editItem";
	}



	/**
	 * 对账明细表 ---->跳转批量对账
	 * @param ids
	 * @param model
	 * @return
	 */
	@GetMapping("/editPiliang/{ids}")
	String editPiliang(@PathVariable("ids") String ids,Model model){
		model.addAttribute("ids", ids);

		Map<String, Object> params = sijiItemService.editPiliang(ids);
		model.addAttribute("dunwei", params.get("dunwei"));
		model.addAttribute("amount", params.get("amount"));
		model.addAttribute("minId", params.get("minId"));



		return "gc/siji/editPiliangItem";
	}



    /**
     * 对账保存 --批量-->跳转保存
     */
    @ResponseBody
    @RequestMapping("/updatePiliang")
    public R updatePiliang(@RequestParam Map<String, Object> params){

        String id = params.get("ids").toString();
        String ids [] = id.split(",");
        params.put("array", ids);

        sijiItemService.updatePiliang(params);

        return R.ok();
    }




	/**
	 * 对账明细表 ---->跳转批量修改规格钢号
	 * @param ids
	 * @param model
	 * @return
	 */
	@GetMapping("/piliangSteelPage/{ids}")
	String piliangSteelPage(@PathVariable("ids") String ids,Model model){
		model.addAttribute("ids", ids);

		Map<String, Object> params = sijiItemService.editPiliang(ids);
		model.addAttribute("dunwei", params.get("dunwei"));
		model.addAttribute("amount", params.get("amount"));
		model.addAttribute("minId", params.get("minId"));



		return "gc/siji/editPiliangSteel";
	}




	/**
	 * 批量修改规格,钢号-->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updatePiliangSteel")
	public R updatePiliangSteel(@RequestParam Map<String, Object> params){

		String id = params.get("ids").toString();
		String ids [] = id.split(",");
		params.put("array", ids);

		sijiItemService.updatePiliangSteel(params);

		return R.ok();
	}





	/**
	 * 对账明细表 ---->跳转批量修改备注
	 * @param ids
	 * @param model
	 * @return
	 */
	@GetMapping("/piliangMemoPage/{ids}")
	String piliangMemoPage(@PathVariable("ids") String ids,Model model){
		model.addAttribute("ids", ids);

		Map<String, Object> params = sijiItemService.editPiliang(ids);
		model.addAttribute("dunwei", params.get("dunwei"));
		model.addAttribute("amount", params.get("amount"));
		model.addAttribute("minId", params.get("minId"));



		return "gc/siji/editPiliangMemo";
	}




	/**
	 * 批量修改备注-->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updatePiliangMemo")
	public R updatePiliangMemo(@RequestParam Map<String, Object> params){

		String id = params.get("ids").toString();
		String ids [] = id.split(",");
		params.put("array", ids);

		sijiItemService.updatePiliangMemo(params);

		return R.ok();
	}


	/**
	 * 发货明细表 ---->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updateItem")
	public R updateItem(SijiItemDO siji){

		sijiItemService.updateItem(siji);

		return R.ok();
	}












	//发货新增或者修改的----->规格列表
	@ResponseBody
	@GetMapping("/itemList")
	public List<SijiItemDO> itemList(@RequestParam Map<String, Object> params){

		List<SijiItemDO> sijiItemList = sijiItemService.list(params);

		return sijiItemList;
	}





	/**
	 * //发货新增----->保存、或者修改保持。itemId是否有值决定
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( SijiItemDO sijiItem){



		sijiItem.setTranrate(sijiItem.getBaseprice().multiply(sijiItem.getCoefficient()));
		sijiItem.setTrancost(sijiItem.getTranrate().multiply(sijiItem.getTonnage()));

		int flag;
		if (sijiItem.getId()!=null && !"".equals(sijiItem.getId())){
			flag = sijiItemService.update(sijiItem);
		} else {
			flag = sijiItemService.save(sijiItem);
		}
		if(flag>0){
			return R.ok();
		} else {
			return R.errorMsg("操作失败,付款已回单或已对账！");
		}

	}


//	/**
//	 * //发货新增或者修改的----->修改
//	 */
//	@ResponseBody
//	@RequestMapping("/update")
//	public R update( SijiItemDO sijiItem){
//		sijiItemService.update(sijiItem);
//		return R.ok();
//	}



	@GetMapping("/updateItem/{id}")
	@ResponseBody
	SijiItemDO updateItem(@PathVariable("id") Long id){
		SijiItemDO siji = sijiItemService.getItemDo(id);

		return siji;
	}




	
	/**
	 * //发货新增或者修改的----->删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sijiItemService.remove(id)>0){
			return R.ok();
		}
		return R.errorMsg("操作失败,付款已回单或已对账！");
	}



	@ResponseBody
	@PostMapping( "/heDui")
	public R heDui(Long id){

		sijiItemService.heDui(id);
		return R.ok();
	}


	
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






	@PostMapping("/importExcel")
	@ResponseBody
	public R importExcel(@RequestParam("file") MultipartFile file) {
		List<SijiItemImp1> imp1s = FileUtil.importExcel(file, 0, 1, SijiItemImp1.class);
		sijiItemService.importExcel(imp1s);
		return R.ok();
	}





	@PostMapping("/importExcel2")
	@ResponseBody
	public R importExcel2(@RequestParam("file") MultipartFile file) {
		List<SijiItemImp2> imp2s = FileUtil.importExcel(file, 0, 1, SijiItemImp2.class);
		sijiItemService.importExcel2(imp2s);
		return R.ok();
	}







}
