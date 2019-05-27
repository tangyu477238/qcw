package com.bootdo.biz.controller;


import com.bootdo.biz.domain.*;
import com.bootdo.biz.service.*;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-03-26 23:04:52
 */
 
@Controller
@RequestMapping("/biz/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@Autowired
	private BrandModelService brandModelService;

	@Autowired
	private BrandModelPailiangService brandModelPailiangService;

	@Autowired
	private BrandModelYearService brandModelYearService;

	@Autowired
	private ProductService ProductService;



	@ResponseBody
	@GetMapping("/list")
	public List<BrandDO> list(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<BrandDO> brandList = brandService.list(params);
		return brandList;
	}


	@ResponseBody
	@GetMapping("/getModel")
	public List<BrandModelDO> getModel(@RequestParam String pid){

		Map<String, Object> params = new HashMap();
		params.put("pid",pid);

		//查询列表数据
		List<BrandModelDO> brandList = brandModelService.list(params);
		return brandList;
	}


	@ResponseBody
	@GetMapping("/getPailiang")
	public List<BrandModelPailiangDO> getPailiang(@RequestParam String pid){

		Map<String, Object> params = new HashMap();
		params.put("pid",pid);

		//查询列表数据
		List<BrandModelPailiangDO> brandList = brandModelPailiangService.list(params);
		return brandList;
	}

	@ResponseBody
	@GetMapping("/getYear")
	public List<BrandModelYearDO> getYear(@RequestParam String pid){

		Map<String, Object> params = new HashMap();
		params.put("pid",pid);

		//查询列表数据
		List<BrandModelYearDO> brandList = brandModelYearService.list(params);
		return brandList;
	}


	@ResponseBody
	@GetMapping("/getProduct")
	public List<ProductDO> getProduct(String pid, String prodName){

		Map<String, Object> params = new HashMap();
		params.put("pid",pid);
		params.put("prodName",prodName);

		//查询列表数据
		List<ProductDO> brandList = ProductService.list(params);
		return brandList;
	}



	@RequestMapping("/getqcw")
	public String getqcw(){
	    return "/H5.html";
	}


	@RequestMapping("/getright")
	public String getright(){
		return "/right.html";
	}


	@RequestMapping("/getdetail")
	public String getdetail(){
		return "/detail.html";
	}

	@RequestMapping("/getselect")
	public String getselect(){
		return "/select.html";
	}



//	@GetMapping("/edit/{id}")
//	@RequiresPermissions("biz:brand:edit")
//	String edit(@PathVariable("id") Long id,Model model){
//		BrandDO brand = brandService.get(id);
//		model.addAttribute("brand", brand);
//	    return "biz/brand/edit";
//	}
//
//	/**
//	 * 保存
//	 */
//	@ResponseBody
//	@PostMapping("/save")
//	@RequiresPermissions("biz:brand:add")
//	public R save( BrandDO brand){
//		if(brandService.save(brand)>0){
//			return R.ok();
//		}
//		return R.error();
//	}
//	/**
//	 * 修改
//	 */
//	@ResponseBody
//	@RequestMapping("/update")
//	@RequiresPermissions("biz:brand:edit")
//	public R update( BrandDO brand){
//		brandService.update(brand);
//		return R.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("biz:brand:remove")
//	public R remove( Long id){
//		if(brandService.remove(id)>0){
//		return R.ok();
//		}
//		return R.error();
//	}
//
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("biz:brand:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] ids){
//		brandService.batchRemove(ids);
//		return R.ok();
//	}
//




}
