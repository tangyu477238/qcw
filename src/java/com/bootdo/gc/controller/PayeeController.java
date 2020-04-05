package com.bootdo.gc.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.domain.DriverDO;
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

import com.bootdo.gc.domain.PayeeDO;
import com.bootdo.gc.service.PayeeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-03-28 10:36:31
 */
 
@Controller
@RequestMapping("/gc/payee")
public class PayeeController {
	@Autowired
	private PayeeService payeeService;
	
	@GetMapping()

	String Payee(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));
	    return "gc/payee/payee";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PayeeDO> payeeList = payeeService.list(query);
		int total = payeeService.count(query);
		PageUtils pageUtils = new PageUtils(payeeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(@RequestParam Map<String, Object> params,Model model){
		model.addAttribute("deptId", params.get("deptId"));

		return "gc/payee/add";
	}

	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
		PayeeDO payee = payeeService.get(id);
		model.addAttribute("payee", payee);
	    return "gc/payee/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( PayeeDO payee){
		if(payeeService.save(payee)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( PayeeDO payee){
		payeeService.update(payee);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(payeeService.remove(id)>0){
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
		payeeService.batchRemove(ids);
		return R.ok();
	}



	@ResponseBody
	@GetMapping("/getPayee")
	public R getPayee(@RequestParam Map<String, Object> params){
		Object name = params.get("name");
		if (name == null || "null".equals(name.toString())){
			params.remove("name");
		}

		List<PayeeDO> payeeDOList = payeeService.list(params);
		if (payeeDOList!=null && payeeDOList.size()>0){
			params.put("payee", payeeDOList.get(0));
		}
		return R.ok(params);
	}
}
