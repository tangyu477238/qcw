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

import com.bootdo.biz.domain.CarDatetimeSeatDO;
import com.bootdo.biz.service.CarDatetimeSeatService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB; (`plan_id`) REFER `bootdo/biz_plan_price`(`id`)
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 22:46:29
 */
 
@Controller
@RequestMapping("/biz/carDatetimeSeat")
public class CarDatetimeSeatController {
	@Autowired
	private CarDatetimeSeatService carDatetimeSeatService;
	
	@GetMapping()
	@RequiresPermissions("biz:carDatetimeSeat:carDatetimeSeat")
	String CarDatetimeSeat(){
	    return "biz/carDatetimeSeat/carDatetimeSeat";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:carDatetimeSeat:carDatetimeSeat")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CarDatetimeSeatDO> carDatetimeSeatList = carDatetimeSeatService.list(query);
		int total = carDatetimeSeatService.count(query);
		PageUtils pageUtils = new PageUtils(carDatetimeSeatList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:carDatetimeSeat:add")
	String add(){
	    return "biz/carDatetimeSeat/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:carDatetimeSeat:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CarDatetimeSeatDO carDatetimeSeat = carDatetimeSeatService.get(id);
		model.addAttribute("carDatetimeSeat", carDatetimeSeat);
	    return "biz/carDatetimeSeat/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:carDatetimeSeat:add")
	public R save( CarDatetimeSeatDO carDatetimeSeat){
		if(carDatetimeSeatService.save(carDatetimeSeat)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:carDatetimeSeat:edit")
	public R update( CarDatetimeSeatDO carDatetimeSeat){
		carDatetimeSeatService.update(carDatetimeSeat);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:carDatetimeSeat:remove")
	public R remove( Long id){
		if(carDatetimeSeatService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:carDatetimeSeat:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		carDatetimeSeatService.batchRemove(ids);
		return R.ok();
	}
	
}
