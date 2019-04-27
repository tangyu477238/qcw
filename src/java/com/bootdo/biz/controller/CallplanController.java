package com.bootdo.biz.controller;

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

import com.bootdo.biz.domain.CallplanDO;
import com.bootdo.biz.service.CallplanService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-17 21:41:29
 */
 
@Controller
@RequestMapping("/biz/callplan")
public class CallplanController {
	@Autowired
	private CallplanService callplanService;
	
	@GetMapping()
	@RequiresPermissions("biz:callplan:callplan")
	String Callplan(){
	    return "biz/callplan/callplan";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:callplan:callplan")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CallplanDO> callplanList = callplanService.list(query);
		int total = callplanService.count(query);
		PageUtils pageUtils = new PageUtils(callplanList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:callplan:add")
	String add(){
	    return "biz/callplan/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:callplan:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CallplanDO callplan = callplanService.get(id);
		model.addAttribute("callplan", callplan);
	    return "biz/callplan/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:callplan:add")
	public R save( CallplanDO callplan){
		if(callplanService.save(callplan)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:callplan:edit")
	public R update( CallplanDO callplan){
		callplanService.update(callplan);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:callplan:remove")
	public R remove( Long id){
		if(callplanService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:callplan:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		callplanService.batchRemove(ids);
		return R.ok();
	}
	
}
