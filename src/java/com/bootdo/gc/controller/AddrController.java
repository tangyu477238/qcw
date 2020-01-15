package com.bootdo.gc.controller;

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

import com.bootdo.gc.domain.AddrDO;
import com.bootdo.gc.service.AddrService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2020-01-11 18:17:23
 */
 
@Controller
@RequestMapping("/gc/addr")
public class AddrController {
	@Autowired
	private AddrService addrService;
	
	@GetMapping()
	String Addr(@RequestParam Map<String, Object> params,Model model){
        model.addAttribute("deptId", params.get("deptId"));
	    return "gc/addr/addr";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AddrDO> addrList = addrService.list(query);
		int total = addrService.count(query);
		PageUtils pageUtils = new PageUtils(addrList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(@RequestParam Map<String, Object> params,Model model){
        model.addAttribute("deptId", params.get("deptId"));
	    return "gc/addr/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		AddrDO addr = addrService.get(id);
		model.addAttribute("addr", addr);
	    return "gc/addr/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( AddrDO addr){
		if(addrService.save(addr)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( AddrDO addr){
		addrService.update(addr);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(addrService.remove(id)>0){
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
		addrService.batchRemove(ids);
		return R.ok();
	}



	@ResponseBody
	@GetMapping("/listStation")
	public List<AddrDO> listStation(@RequestParam Map<String, Object> params){
		//查询列表数据

		List<AddrDO> addrList = addrService.listStation(params);

		return addrList;
	}

	@ResponseBody
	@GetMapping("/listAddr")
	public List<AddrDO> listAddr(@RequestParam Map<String, Object> params){
		//查询列表数据

		List<AddrDO> addrList = addrService.list(params);

		return addrList;
	}
	
}
