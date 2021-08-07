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

import com.bootdo.biz.domain.SellerInfoDO;
import com.bootdo.biz.service.SellerInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 人员信息表
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-27 06:32:46
 */
 
@Controller
@RequestMapping("/biz/sellerInfo")
public class SellerInfoController {
	@Autowired
	private SellerInfoService sellerInfoService;
	
	@GetMapping()
	@RequiresPermissions("biz:sellerInfo:sellerInfo")
	String SellerInfo(){
	    return "biz/sellerInfo/sellerInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:sellerInfo:sellerInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SellerInfoDO> sellerInfoList = sellerInfoService.list(query);
		int total = sellerInfoService.count(query);
		PageUtils pageUtils = new PageUtils(sellerInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:sellerInfo:add")
	String add(){
	    return "biz/sellerInfo/add";
	}

	@GetMapping("/addOld")
	@RequiresPermissions("biz:sellerInfo:add")
	String addOld(){
		return "biz/sellerInfo/addOld";
	}

	@GetMapping("/edit/{sellerId}")
	@RequiresPermissions("biz:sellerInfo:edit")
	String edit(@PathVariable("sellerId") String sellerId,Model model){
		SellerInfoDO sellerInfo = sellerInfoService.get(sellerId);
		model.addAttribute("sellerInfo", sellerInfo);
	    return "biz/sellerInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:sellerInfo:add")
	public R save( SellerInfoDO sellerInfo){
		if(sellerInfoService.save(sellerInfo)>0){
			return R.ok();
		}
		return R.error("卡号已存在！");
	}
	/**
	 * 充值
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:sellerInfo:edit")
	public R update( SellerInfoDO sellerInfo){
		sellerInfoService.chongzhi(sellerInfo);
		return R.ok();
	}


	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:sellerInfo:remove")
	public R remove( String sellerId){
		if(sellerInfoService.remove(sellerId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:sellerInfo:batchRemove")
	public R remove(@RequestParam("ids[]") String[] sellerIds){
		sellerInfoService.batchRemove(sellerIds);
		return R.ok();
	}
	
}
