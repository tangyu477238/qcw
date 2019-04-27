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

import com.bootdo.biz.domain.SelldayDO;
import com.bootdo.biz.service.SelldayService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 11264 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2018-12-18 08:09:29
 */
 
@Controller
@RequestMapping("/biz/sellday")
public class SelldayController {
	@Autowired
	private SelldayService selldayService;
	
	@GetMapping()
	@RequiresPermissions("biz:sellday:sellday")
	String Sellday(){
	    return "biz/sellday/sellday";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:sellday:sellday")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SelldayDO> selldayList = selldayService.list(query);
		int total = selldayService.count(query);
		PageUtils pageUtils = new PageUtils(selldayList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:sellday:add")
	String add(){
	    return "biz/sellday/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:sellday:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SelldayDO sellday = selldayService.get(id);
		model.addAttribute("sellday", sellday);
	    return "biz/sellday/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:sellday:add")
	public R save( SelldayDO sellday){
		if(selldayService.save(sellday)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:sellday:edit")
	public R update( SelldayDO sellday){
		selldayService.update(sellday);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:sellday:remove")
	public R remove( Long id){
		if(selldayService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:sellday:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		selldayService.batchRemove(ids);
		return R.ok();
	}
	
}
