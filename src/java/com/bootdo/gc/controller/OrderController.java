package com.bootdo.gc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.gc.domain.AddrDO;
import com.bootdo.gc.domain.DriverDO;
import com.bootdo.gc.service.AddrService;
import com.bootdo.gc.service.DriverService;
import com.bootdo.gc.service.SijiItemAminvoiceService;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.UserService;
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

import com.bootdo.gc.domain.OrderDO;
import com.bootdo.gc.service.OrderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-12-14 21:31:17
 */
 
@Controller
@RequestMapping("/gc/order")
public class OrderController extends BaseController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private SijiItemAminvoiceService sijiItemService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private AddrService addrService;


	@GetMapping("/orderBi")
	String OrderBi(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
		UserDO userDo = getUser();
		model.addAttribute("orderuser", userDo.getUserId());


		List<DriverDO>  driverList = driverService.list(params);
		model.addAttribute("driverList",driverList);

		List<UserDO> sysUserList = userService.list(params);
		model.addAttribute("sysUserList", sysUserList);

		return "gc/order/orderBi";
	}



	@ResponseBody
	@PostMapping("/saveRemark")
	public R saveRemark(@RequestParam Map<String, Object> params){
		if(orderService.saveRemark(params)>0){
			return R.ok();
		}
		return R.error();
	}


	@GetMapping()
	String Order(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
        UserDO userDo = getUser();
        model.addAttribute("orderuser", userDo.getUserId());


		List<DriverDO>  driverList = driverService.list(params);
		model.addAttribute("driverList",driverList);

		List<UserDO> sysUserList = userService.list(params);
		model.addAttribute("sysUserList", sysUserList);

		return "gc/order/order";
	}
	
//	@ResponseBody
//	@GetMapping("/list")
//
//	public PageUtils list(@RequestParam Map<String, Object> params){
//
//
//
//		//查询列表数据
//        Query query = new Query(params);
//		List<OrderDO> orderList = orderService.list(query);
//		int total = orderService.count(query);
//		PageUtils pageUtils = new PageUtils(orderList, total);
//
//
//		return pageUtils;
//	}

	@ResponseBody
	@GetMapping("/tlist")

	public PageUtils tlist(@RequestParam Map<String, Object> params){

//		UserDO userDo = getUser();
//		params.put("createuser", userDo.getUserId());
//		params.put("orderuser", userDo.getUserId());

		//查询列表数据
		Query query = new Query(params);
		List<Map> orderList = orderService.tlist(query);
		int total = orderService.count(query);
		PageUtils pageUtils = new PageUtils(orderList, total);


		return pageUtils;
	}




	@GetMapping("/byOrder")
	String byOrder(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
        UserDO userDo = getUser();
        model.addAttribute("orderuser", userDo.getUserId());

		List<UserDO> sysUserList = userService.list(params);
		model.addAttribute("sysUserList", sysUserList);


		return "gc/order/byOrder";
	}

	@ResponseBody
	@GetMapping("/listByOrder")
	public PageUtils listByOrder(@RequestParam Map<String, Object> params){

		//查询列表数据
		Query query = new Query(params);
		List<OrderDO> orderList = orderService.list(query);
		int total = orderService.count(query);
		PageUtils pageUtils = new PageUtils(orderList, total);
		return pageUtils;
	}

	
	@GetMapping("/add")
	String add(@RequestParam Map<String, Object> params, Model model){
		model.addAttribute("deptId", params.get("deptId"));


		List<AddrDO> stationList = addrService.listStation(params);
		model.addAttribute("stationList", stationList);

		UserDO userDo = getUser();
		model.addAttribute("createusername",userDo.getName());
		model.addAttribute("createuser",userDo.getUserId());

		List<UserDO> sysUserList = userService.list(params);
		model.addAttribute("sysUserList", sysUserList);




	    return "gc/order/add";
	}

	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
		OrderDO order = orderService.get(id);
		model.addAttribute("order", order);



		Map params = new HashMap();
		params.put("deptId", order.getDeptId());

		List<AddrDO> stationList = addrService.listStation(params);
		model.addAttribute("stationList", stationList);

		List<UserDO> sysUserList = userService.list(params);
		model.addAttribute("sysUserList", sysUserList);



	    return "gc/order/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( OrderDO order){
		order.setBiztime(new Date());
		if(orderService.save(order)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( OrderDO order){
		orderService.update(order);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(orderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

    @PostMapping( "/wancheng")
    @ResponseBody

    public R wancheng(Long id){
        if(orderService.wancheng(id)>0){
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
		orderService.batchRemove(ids);
		return R.ok();
	}
	
}
