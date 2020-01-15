package com.bootdo.gc.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.gc.domain.DriverDO;
import com.bootdo.gc.domain.OrderDO;
import com.bootdo.gc.service.DriverService;
import com.bootdo.gc.service.OrderService;
import com.bootdo.system.domain.UserDO;
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

import com.bootdo.gc.domain.OrderItemDO;
import com.bootdo.gc.service.OrderItemService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:20
 */
 
@Controller
@RequestMapping("/gc/orderItem")
public class OrderItemController  extends BaseController {
	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private OrderService orderService;

    @Autowired
    private DriverService driverService;

	@GetMapping()
	String OrderItem(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));

		List<DriverDO>  driverList = driverService.list(params);
		model.addAttribute("driverList",driverList);

	    return "gc/orderItem/orderItem";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderItemDO> orderItemList = orderItemService.list(query);
		int total = orderItemService.count(query);
		PageUtils pageUtils = new PageUtils(orderItemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("pid", params.get("id"));
		model.addAttribute("deptId", params.get("deptId"));


		OrderDO orderDO =  orderService.get(Long.parseLong(params.get("id").toString()));
		model.addAttribute("sytonnage",orderDO.getSytonnage());


		UserDO userDo = getUser();
		model.addAttribute("createusername",userDo.getName());
		model.addAttribute("createuser",userDo.getUserId());

		params.remove("id");
        List<DriverDO>  driverList = driverService.list(params);
		model.addAttribute("driverList",driverList);



//		sytonnage


	    return "gc/orderItem/add";
	}

	@GetMapping("/edit")

	String edit(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));


		OrderItemDO orderItem = orderItemService.get(new Long(params.get("id").toString()));
		model.addAttribute("orderItem", orderItem);

		params.remove("id");
		List<DriverDO>  driverList = driverService.list(params);
		model.addAttribute("driverList",driverList);

	    return "gc/orderItem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( OrderItemDO orderItem){
		if(orderItemService.save(orderItem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( OrderItemDO orderItem){
		orderItemService.update(orderItem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(orderItemService.remove(id)>0){
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
		orderItemService.batchRemove(ids);
		return R.ok();
	}
	
}
