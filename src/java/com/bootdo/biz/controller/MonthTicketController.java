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

import com.bootdo.biz.domain.MonthTicketDO;
import com.bootdo.biz.service.MonthTicketService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户月票购买记录; InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:30
 */
 
@Controller
@RequestMapping("/biz/monthTicket")
public class MonthTicketController {
	@Autowired
	private MonthTicketService monthTicketService;
	
	@GetMapping()
	@RequiresPermissions("biz:monthTicket:monthTicket")
	String MonthTicket(){
	    return "biz/monthTicket/monthTicket";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:monthTicket:monthTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MonthTicketDO> monthTicketList = monthTicketService.list(query);
		int total = monthTicketService.count(query);
		PageUtils pageUtils = new PageUtils(monthTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:monthTicket:add")
	String add(){
	    return "biz/monthTicket/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:monthTicket:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MonthTicketDO monthTicket = monthTicketService.get(id);
		model.addAttribute("monthTicket", monthTicket);
	    return "biz/monthTicket/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:monthTicket:add")
	public R save( MonthTicketDO monthTicket){
		if(monthTicketService.save(monthTicket)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:monthTicket:edit")
	public R update( MonthTicketDO monthTicket){
		monthTicketService.update(monthTicket);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:monthTicket:remove")
	public R remove( Long id){
		if(monthTicketService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:monthTicket:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		monthTicketService.batchRemove(ids);
		return R.ok();
	}
	
}
