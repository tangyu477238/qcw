package com.bootdo.gc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.gc.domain.FukuanDo;
import com.bootdo.gc.domain.PayeeDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.service.PayeeService;
import com.bootdo.system.domain.UserDO;
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
public class KehuController extends BaseController {
	@Autowired
	private KehuService kehuService;



	@Autowired
	private PayeeService payeeService;




	@GetMapping()

	String Kehu(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		UserDO userDo = getUser();
		model.addAttribute("createuser", userDo.getUserId());
		return "gc/kehu/kehu";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){


		//查询列表数据
        Query query = new Query(params);
		List<KehuDO> kehuList = kehuService.list(query);
		int total = kehuService.count(query);
		PageUtils pageUtils = new PageUtils(kehuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(@RequestParam Map<String, Object> params, Model model){
		model.addAttribute("deptId", params.get("deptId"));
		List<PayeeDO> payeelist = payeeService.list(params);
		model.addAttribute("payeelist", payeelist);
		return "gc/kehu/add";
	}

	@GetMapping("/edit")

	String edit(@RequestParam Map<String, Object> params, Model model){

		Long id = Long.parseLong(params.get("id").toString());
		KehuDO kehu = kehuService.get(id);
		model.addAttribute("kehu", kehu);
		params.remove("id");
		model.addAttribute("deptId", params.get("deptId"));
		List<PayeeDO> payeelist = payeeService.list(params);
		model.addAttribute("payeelist", payeelist);
	    return "gc/kehu/edit";
	}






	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( KehuDO kehu){
		UserDO userDo = getUser();
		kehu.setDeptId(userDo.getDeptId());
		kehu.setUpdatedName(userDo.getName());

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

	public R update( KehuDO kehu){
		UserDO userDo = getUser();
		kehu.setDeptId(userDo.getDeptId());
		kehu.setUpdatedName(userDo.getName());
		kehuService.update(kehu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(kehuService.remove(id)>0){
			return R.ok();
		}
		return R.errorMsg("单据已回单，不可删除！");
	}


	/**
	 * adminRemove
	 */
	@PostMapping( "/adminRemove")
	@ResponseBody
	public R adminRemove(Long id){
		if(kehuService.adminRemove(id)>0){
			return R.ok();
		}
		return R.errorMsg("删除失败！");
	}


	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody

	public R remove(@RequestParam("ids[]") Long[] ids){


		if(kehuService.batchRemove(ids)>0){
			return R.ok();
		}
		return R.errorMsg("单据已回单，不可删除！");
	}


	// 导出全部数据
	@RequestMapping("/export")
	public void exportstudent(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {


		params.put("order","asc");
		params.put("sort","id");
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




	@GetMapping("/queryKehuPage")
	String queryKehuPage(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/kehu/queryKehu";
	}

	//获取列表--结算
	@ResponseBody
	@GetMapping("/queryKehu")
	List<Map> queryKehu(String startDate,String endDate,Long deptId){
		Map map = new HashMap();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("deptId",deptId);
		return kehuService.queryKehu(map);
	}



	@GetMapping("/totalKehuPage")
	String totalKehuPage(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/kehu/totalKehu";
	}

	@ResponseBody
	@GetMapping("/queryKehu1")
	List<Map> queryKehu1(String startDate,String endDate,Long deptId){
		Map map = new HashMap();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("deptId",deptId);
		return kehuService.queryKehu1(map);
	}


	@GetMapping("/fukuan")
	String fukuan(Long deptId,Model model){
		model.addAttribute("deptId", deptId);
		return "gc/kehu/fukuan";
	}



	@ResponseBody
	@GetMapping("/getFukuan")
	public PageUtils getFukuan(@RequestParam Map<String, Object> params){

		//查询列表数据
		Query query = new Query(params);
		List<FukuanDo> fukuanlist = kehuService.getFukuan(query);
		int total = kehuService.fukuanCount(query);
		PageUtils pageUtils = new PageUtils(fukuanlist, total);
		return pageUtils;
	}


	// 导出全部数据
	@RequestMapping("/exportFukuan")
	public void exportFukuan(HttpServletResponse res,
							  @RequestParam Map<String, Object> params) throws IOException {

//		params.put("order","asc");
//		params.put("sort","id");
		List<FukuanDo> fukuanlist = kehuService.getFukuan(params);
//
		ExcelUtil.exportExcel(fukuanlist,"当天付款明细",
				"当天付款明细",FukuanDo.class,"当天付款明细.xls",res);


	}

	
}
