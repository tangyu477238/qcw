package com.bootdo.gc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.SijiDO;
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

import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.service.KehuService;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-05-25 10:38:01
 */
 
@Controller
@RequestMapping("/gc/kehu")
public class KehuController {
	@Autowired
	private KehuService kehuService;
	
	@GetMapping()
	@RequiresPermissions("gc:kehu:kehu")
	String Kehu(){
	    return "gc/kehu/kehu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("gc:kehu:kehu")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<KehuDO> kehuList = kehuService.list(query);
		int total = kehuService.count(query);
		PageUtils pageUtils = new PageUtils(kehuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("gc:kehu:add")
	String add(){
	    return "gc/kehu/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("gc:kehu:edit")
	String edit(@PathVariable("id") Long id,Model model){
		KehuDO kehu = kehuService.get(id);
		model.addAttribute("kehu", kehu);
	    return "gc/kehu/edit";
	}






	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("gc:kehu:add")
	public R save( KehuDO kehu){





		if(kehuService.save(kehu)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("gc:kehu:edit")
	public R update( KehuDO kehu){
		kehuService.update(kehu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("gc:kehu:remove")
	public R remove( Long id){
		if(kehuService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("gc:kehu:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		kehuService.batchRemove(ids);
		return R.ok();
	}


	// 导出全部数据
	@RequestMapping("/export")
	public void exportstudent(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {

		List<KehuDO> kehuList = kehuService.list(params);


		ExcelUtil.exportExcel(kehuList,"付款统计表",
				"付款统计表",KehuDO.class,"付款统计表.xls",res);


	}



	//获取订单
	@ResponseBody
	@GetMapping("/getOrder")
	KehuDO getOrder(String orderNo){
		KehuDO kehu = kehuService.getOrder(orderNo);



		return kehu;
	}
	
}
