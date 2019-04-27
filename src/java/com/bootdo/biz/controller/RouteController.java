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

import com.bootdo.biz.domain.RouteDO;
import com.bootdo.biz.service.RouteService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:47
 */
 
@Controller
@RequestMapping("/biz/route")
public class RouteController {
	@Autowired
	private RouteService routeService;
	
	@GetMapping()
	@RequiresPermissions("biz:route:route")
	String Route(){
	    return "biz/route/route";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:route:route")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RouteDO> routeList = routeService.list(query);
		int total = routeService.count(query);
		PageUtils pageUtils = new PageUtils(routeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:route:add")
	String add(){
	    return "biz/route/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:route:edit")
	String edit(@PathVariable("id") Long id,Model model){
		RouteDO route = routeService.get(id);
		model.addAttribute("route", route);
	    return "biz/route/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:route:add")
	public R save( RouteDO route){
		if(routeService.save(route)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:route:edit")
	public R update( RouteDO route){
		routeService.update(route);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:route:remove")
	public R remove( Long id){
		if(routeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:route:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		routeService.batchRemove(ids);
		return R.ok();
	}
	
}
