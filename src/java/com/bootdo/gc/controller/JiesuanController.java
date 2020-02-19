package com.bootdo.gc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.*;
import com.bootdo.system.domain.UserDO;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
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

import com.bootdo.gc.domain.JiesuanDO;
import com.bootdo.gc.service.JiesuanService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-07-14 08:50:37
 */
 
@Controller
@RequestMapping("/gc/jiesuan")
public class JiesuanController extends BaseController {
	@Autowired
	private JiesuanService jiesuanService;
	
	@GetMapping()
	String Jiesuan(){
	    return "gc/jiesuan/jiesuan";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JiesuanDO> jiesuanList = jiesuanService.list(query);
		int total = jiesuanService.count(query);
		PageUtils pageUtils = new PageUtils(jiesuanList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(){
	    return "gc/jiesuan/add";
	}

	@GetMapping("/edit/{id}")

	String edit(@PathVariable("id") Long id,Model model){
		JiesuanDO jiesuan = jiesuanService.get(id);
		model.addAttribute("jiesuan", jiesuan);
	    return "gc/jiesuan/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")

	public R save( JiesuanDO jiesuan){
		if(jiesuanService.save(jiesuan)>0){
			return R.ok();
		}
		return R.error();
	}



	/**
	 * 添加调整金额
	 */
	@ResponseBody
	@PostMapping("/saveItem")

	public R saveItem(JiesuanDO jiesuan ){


		if (jiesuan.getAmount() == null) {
			return R.error();
		}
		UserDO userDo = getUser();
		jiesuan.setUpdatedName(userDo.getName());
		jiesuan.setDeptId(userDo.getDeptId());
		if(jiesuanService.save(jiesuan)>0){
			return R.ok();
		}

		return R.error();
	}




	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")

	public R update( JiesuanDO jiesuan){
		jiesuanService.update(jiesuan);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody

	public R remove( Long id){
		if(jiesuanService.remove(id)>0){
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
		jiesuanService.batchRemove(ids);
		return R.ok();
	}


	@PostMapping("/importExcel")
	@ResponseBody
	public R importExcel(@RequestParam("file") MultipartFile file) {
		List<JiesuanDO> jiesuanList = FileUtil.importExcel(file, 0, 1, JiesuanDO.class);
		//System.out.println(jiesuanList);
		jiesuanService.importExcel(jiesuanList);
		return R.ok();
	}





//	@GetMapping("/importExcel")
//	public String importExcel2() {
////		ImportParams importParams = new ImportParams();
////		// 数据处理
////		importParams.setHeadRows(1);
////		importParams.setTitleRows(1);
////		// 需要验证
////		importParams.setNeedVerfiy(false);
////
////		try {
////			ExcelImportResult<JiesuanDO> result = ExcelImportUtil.importExcelMore(file.getInputStream(),
////					JiesuanDO.class,importParams);
////			List<JiesuanDO> userList = result.getList();
////			for (JiesuanDO User : userList) {
////				 System.out.println(User);
////				//log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(User));
////				//TODO 将导入的数据做保存数据库操作
////			}
////			//log.info("从Excel导入数据一共 {} 行 ", userList.size());
////		} catch (IOException e) {
////			//log.error("导入失败：{}", e.getMessage());
////		} catch (Exception e1) {
////			//log.error("导入失败：{}", e1.getMessage());
////		}
//
//
//
//
//
//		ImportParams params = new ImportParams();
//		params.setTitleRows(1);
//		params.setHeadRows(1);
//		long start = new Date().getTime();
//		List<JiesuanDO> list = ExcelImportUtil.importExcel(
//				new File("F://a.xlsx"),
//				JiesuanDO.class, params);
//		System.out.println(new Date().getTime() - start);
//		System.out.println(list.size());
//		System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
//
//
//
//		return "导入成功";
//	}




}
