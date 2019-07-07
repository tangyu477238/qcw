package com.bootdo.gc.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.system.domain.UserDO;
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
@RequestMapping("/gc/sijiItem")
public class SijiItemController extends BaseController {
	@Autowired
	private SijiItemService sijiItemService;

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




	//发货明细表
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
	 * 发货明细表 ---->跳转编辑
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
	 * 发货明细表 ---->跳转保存
	 */
	@ResponseBody
	@RequestMapping("/updateItem")
	public R updateItem(SijiItemDO siji){

		sijiItemService.update(siji);

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
			return R.error();
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
		return R.error();
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
	
}
