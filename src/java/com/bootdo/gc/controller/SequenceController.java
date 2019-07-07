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

import com.bootdo.gc.domain.SequenceDO;
import com.bootdo.gc.service.SequenceService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 序列号
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-14 11:00:32
 */
 
@Controller
@RequestMapping("/gc/sequence")
public class SequenceController {
	@Autowired
	private SequenceService sequenceService;
	
	@GetMapping()
	@RequiresPermissions("gc:sequence:sequence")
	String Sequence(){
	    return "gc/sequence/sequence";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("gc:sequence:sequence")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SequenceDO> sequenceList = sequenceService.list(query);
		int total = sequenceService.count(query);
		PageUtils pageUtils = new PageUtils(sequenceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("gc:sequence:add")
	String add(){
	    return "gc/sequence/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("gc:sequence:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SequenceDO sequence = sequenceService.get(id);
		model.addAttribute("sequence", sequence);
	    return "gc/sequence/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("gc:sequence:add")
	public R save( SequenceDO sequence){
		if(sequenceService.save(sequence)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("gc:sequence:edit")
	public R update( SequenceDO sequence){
		sequenceService.update(sequence);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("gc:sequence:remove")
	public R remove( Long id){
		if(sequenceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("gc:sequence:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		sequenceService.batchRemove(ids);
		return R.ok();
	}


	/**
	 * getSequence
	 */
	@GetMapping( "/getSequence")
	@ResponseBody
	public R getSequence(){

		return R.ok(sequenceService.getSequence(""));
	}
	
}
