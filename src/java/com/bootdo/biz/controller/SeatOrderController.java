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

import com.bootdo.biz.domain.SeatOrderDO;
import com.bootdo.biz.service.SeatOrderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-01-27 16:18:29
 */
 
@Controller
@RequestMapping("/biz/seatOrder")
public class SeatOrderController {
	@Autowired
	private SeatOrderService seatOrderService;
	
	@GetMapping()
	@RequiresPermissions("biz:seatOrder:seatOrder")
	String SeatOrder(){
	    return "biz/seatOrder/seatOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:seatOrder:seatOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SeatOrderDO> seatOrderList = seatOrderService.list(query);
		int total = seatOrderService.count(query);
		PageUtils pageUtils = new PageUtils(seatOrderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:seatOrder:add")
	String add(){
	    return "biz/seatOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:seatOrder:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SeatOrderDO seatOrder = seatOrderService.get(id);
		model.addAttribute("seatOrder", seatOrder);
	    return "biz/seatOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:seatOrder:add")
	public R save( SeatOrderDO seatOrder){
		if(seatOrderService.save(seatOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:seatOrder:edit")
	public R update( SeatOrderDO seatOrder){
		seatOrderService.update(seatOrder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:seatOrder:remove")
	public R remove( Long id){
		if(seatOrderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:seatOrder:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		seatOrderService.batchRemove(ids);
		return R.ok();
	}
	
}
