package com.bootdo.gc.controller;

import java.util.HashMap;
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

import com.bootdo.gc.domain.DriverDO;
import com.bootdo.gc.service.DriverService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-15 12:44:32
 */
 
@Controller
@RequestMapping("/gc/driver")
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	@GetMapping()

	String Driver(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
	    return "gc/driver/driver";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DriverDO> driverList = driverService.list(query);
		int total = driverService.count(query);
		PageUtils pageUtils = new PageUtils(driverList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
	    return "gc/driver/add";
	}

	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
		DriverDO driver = driverService.get(id);
		model.addAttribute("driver", driver);
	    return "gc/driver/edit";
	}


	@ResponseBody
	@GetMapping("/getDriver")
	public R save(@RequestParam Map<String, Object> params){
		Long id = Long.parseLong(params.get("id").toString());
		DriverDO driver = driverService.get(id);
		params.put("driver",driver);
		return R.ok(params);
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( DriverDO driver){
		if(driverService.save(driver)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( DriverDO driver){
		driverService.update(driver);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(driverService.remove(id)>0){
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
		driverService.batchRemove(ids);
		return R.ok();
	}
	
}
