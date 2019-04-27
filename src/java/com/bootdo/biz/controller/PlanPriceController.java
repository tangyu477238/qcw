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

import com.bootdo.biz.domain.PlanPriceDO;
import com.bootdo.biz.service.PlanPriceService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB; (`car_id`) REFER `bootdo/biz_car`(`id`); (`route_id`) REF
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-01 16:03:51
 */
 
@Controller
@RequestMapping("/biz/planPrice")
public class PlanPriceController {
	@Autowired
	private PlanPriceService planPriceService;
	
	@GetMapping()
	@RequiresPermissions("biz:planPrice:planPrice")
	String PlanPrice(){
	    return "biz/planPrice/planPrice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:planPrice:planPrice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PlanPriceDO> planPriceList = planPriceService.list(query);
		int total = planPriceService.count(query);
		PageUtils pageUtils = new PageUtils(planPriceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:planPrice:add")
	String add(){
	    return "biz/planPrice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:planPrice:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PlanPriceDO planPrice = planPriceService.get(id);
		model.addAttribute("planPrice", planPrice);
	    return "biz/planPrice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:planPrice:add")
	public R save( PlanPriceDO planPrice){
		if(planPriceService.save(planPrice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:planPrice:edit")
	public R update( PlanPriceDO planPrice){
		planPriceService.update(planPrice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:planPrice:remove")
	public R remove( Long id){
		if(planPriceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:planPrice:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		planPriceService.batchRemove(ids);
		return R.ok();
	}
	
}
