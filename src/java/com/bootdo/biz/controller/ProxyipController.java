package com.bootdo.biz.controller;

import com.bootdo.biz.domain.ProxyipDO;
import com.bootdo.biz.service.ProxyipService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-09 22:50:45
 */
 
@Controller
@RequestMapping("/biz/proxyip")
public class ProxyipController {
	@Autowired
	private ProxyipService proxyipService;
	
	@GetMapping()
	@RequiresPermissions("biz:proxyip:proxyip")
	String Proxyip(){
	    return "biz/proxyip/proxyip";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:proxyip:proxyip")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProxyipDO> proxyipList = proxyipService.list(query);
		int total = proxyipService.count(query);
		PageUtils pageUtils = new PageUtils(proxyipList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:proxyip:add")
	String add(){
	    return "biz/proxyip/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:proxyip:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ProxyipDO proxyip = proxyipService.get(id);
		model.addAttribute("proxyip", proxyip);
	    return "biz/proxyip/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:proxyip:add")
	public R save( ProxyipDO proxyip){
		if(proxyipService.save(proxyip)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:proxyip:edit")
	public R update( ProxyipDO proxyip){
		proxyipService.update(proxyip);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:proxyip:remove")
	public R remove( Long id){
		if(proxyipService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:proxyip:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		proxyipService.batchRemove(ids);
		return R.ok();
	}
	
}
