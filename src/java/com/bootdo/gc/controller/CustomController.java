package com.bootdo.gc.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.gc.domain.CustomDO;
import com.bootdo.gc.service.CustomService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 客户
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-10-10 16:17:23
 */
 
@Controller
@RequestMapping("/gc/custom")
public class CustomController {
	@Autowired
	private CustomService customService;
	
	@GetMapping()
	@RequiresPermissions("gc:custom:custom")
	String Custom(){
	    return "gc/custom/custom";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("gc:custom:custom")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CustomDO> customList = customService.list(query);
		int total = customService.count(query);
		PageUtils pageUtils = new PageUtils(customList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("gc:custom:add")
	String add(){
	    return "gc/custom/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("gc:custom:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CustomDO custom = customService.get(id);
		model.addAttribute("custom", custom);
	    return "gc/custom/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("gc:custom:add")
	public R save( CustomDO custom){
		if(customService.save(custom)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("gc:custom:edit")
	public R update( CustomDO custom){
		customService.update(custom);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("gc:custom:remove")
	public R remove( Long id){
		if(customService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("gc:custom:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		customService.batchRemove(ids);
		return R.ok();
	}
	
}
