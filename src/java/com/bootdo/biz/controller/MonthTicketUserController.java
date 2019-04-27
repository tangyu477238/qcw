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

import com.bootdo.biz.domain.MonthTicketUserDO;
import com.bootdo.biz.service.MonthTicketUserService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户月票购买记录
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-27 16:18:18
 */
 
@Controller
@RequestMapping("/biz/monthTicketUser")
public class MonthTicketUserController {
	@Autowired
	private MonthTicketUserService monthTicketUserService;
	
	@GetMapping()
	@RequiresPermissions("biz:monthTicketUser:monthTicketUser")
	String MonthTicketUser(){
	    return "biz/monthTicketUser/monthTicketUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:monthTicketUser:monthTicketUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MonthTicketUserDO> monthTicketUserList = monthTicketUserService.list(query);
		int total = monthTicketUserService.count(query);
		PageUtils pageUtils = new PageUtils(monthTicketUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:monthTicketUser:add")
	String add(){
	    return "biz/monthTicketUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:monthTicketUser:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MonthTicketUserDO monthTicketUser = monthTicketUserService.get(id);
		model.addAttribute("monthTicketUser", monthTicketUser);
	    return "biz/monthTicketUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:monthTicketUser:add")
	public R save( MonthTicketUserDO monthTicketUser){
		if(monthTicketUserService.save(monthTicketUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:monthTicketUser:edit")
	public R update( MonthTicketUserDO monthTicketUser){
		monthTicketUserService.update(monthTicketUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:monthTicketUser:remove")
	public R remove( Long id){
		if(monthTicketUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:monthTicketUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		monthTicketUserService.batchRemove(ids);
		return R.ok();
	}
	
}
