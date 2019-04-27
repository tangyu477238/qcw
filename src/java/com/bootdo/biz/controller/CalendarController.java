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

import com.bootdo.biz.domain.CalendarDO;
import com.bootdo.biz.service.CalendarService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 22:09:03
 */
 
@Controller
@RequestMapping("/biz/calendar")
public class CalendarController {
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping()
	@RequiresPermissions("biz:calendar:calendar")
	String Calendar(){
	    return "biz/calendar/calendar";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:calendar:calendar")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CalendarDO> calendarList = calendarService.list(query);
		int total = calendarService.count(query);
		PageUtils pageUtils = new PageUtils(calendarList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:calendar:add")
	String add(){
	    return "biz/calendar/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:calendar:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CalendarDO calendar = calendarService.get(id);
		model.addAttribute("calendar", calendar);
	    return "biz/calendar/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:calendar:add")
	public R save( CalendarDO calendar){
		if(calendarService.save(calendar)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:calendar:edit")
	public R update( CalendarDO calendar){
		calendarService.update(calendar);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:calendar:remove")
	public R remove( Long id){
		if(calendarService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:calendar:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		calendarService.batchRemove(ids);
		return R.ok();
	}
	
}
