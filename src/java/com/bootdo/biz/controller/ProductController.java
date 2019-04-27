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

import com.bootdo.biz.domain.ProductDO;
import com.bootdo.biz.service.ProductService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车排量; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-05 14:14:42
 */
 
@Controller
@RequestMapping("/biz/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	@RequiresPermissions("biz:product:product")
	String Product(){
	    return "biz/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("biz:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("biz:product:add")
	String add(){
	    return "biz/product/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("biz:product:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ProductDO product = productService.get(id);
		model.addAttribute("product", product);
	    return "biz/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("biz:product:add")
	public R save( ProductDO product){
		if(productService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("biz:product:edit")
	public R update( ProductDO product){
		productService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("biz:product:remove")
	public R remove( Long id){
		if(productService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("biz:product:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		productService.batchRemove(ids);
		return R.ok();
	}
	
}
