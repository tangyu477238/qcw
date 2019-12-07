package com.bootdo.gc.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.service.CustomService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.gc.domain.CustomShuilvDO;
import com.bootdo.gc.service.CustomShuilvService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-11-27 17:12:30
 */
 
@Controller
@RequestMapping("/gc/customShuilv")
public class CustomShuilvController {
	@Autowired
	private CustomShuilvService customShuilvService;



	@Autowired
	private CustomService customService;
	
	@GetMapping()

	String CustomShuilv(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
		return "gc/customShuilv/customShuilv";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CustomShuilvDO> customShuilvList = customShuilvService.list(query);
		int total = customShuilvService.count(query);
		PageUtils pageUtils = new PageUtils(customShuilvList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(@RequestParam Map<String, Object> params,Model model){


		model.addAttribute("deptId", params.get("deptId"));


		params.put("stype", "fkdw");
		List<Map<String, Object>> fkdwList = customService.getCustomList(params); //付款单位
		model.addAttribute("fkdwList", fkdwList);

		params.put("stype", "kpdw");
		List<Map<String, Object>> kpdwList = customService.getCustomList(params); //发货单位
		model.addAttribute("kpdwList", kpdwList);



		return "gc/customShuilv/add";
	}


	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
		CustomShuilvDO customShuilv = customShuilvService.get(id);
		model.addAttribute("customShuilv", customShuilv);
	    return "gc/customShuilv/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( CustomShuilvDO customShuilv){

		if(customShuilvService.save(customShuilv)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( CustomShuilvDO customShuilv){
		customShuilvService.update(customShuilv);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(customShuilvService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody

	public R remove(@RequestParam("ids[]") Long[] ids){
		customShuilvService.batchRemove(ids);
		return R.ok();
	}
	
}
