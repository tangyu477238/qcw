package com.bootdo.biz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.biz.domain.SeatOrderDO;
import com.bootdo.biz.service.HxzService;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

/**
 * 
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-28 23:30:47
 */
 
@Controller
@Slf4j
@RequestMapping("/hxz/v1")
public class HxzController {
	@Autowired
	private HxzService hxzService;



	//
	@ResponseBody
	@PostMapping("/ServerTime")
	public String ServerTime(Map  map){
		log.info("进入ServerTime.......");
		map.put("Status",1);
		map.put("Msg","");
		map.put("Time", DateUtils.format(new Date(),"yyyyMMddHHmmss"));
		return JSONUtils.toJson(map);

	}

	//
	@ResponseBody
	@PostMapping(value = "/ConsumTransactions", produces = "application/json;charset=GB2312")
	public String consumTransactions(Map map, @RequestBody JSONObject jsonObject){
		log.info("consumTransactions.......");

		SeatOrderDO seatOrderDO = hxzService.consumTransactions(jsonObject.getString("Order"),
				jsonObject.getString("CardNo"));
		if (seatOrderDO == null){
			map.put("Status",0);
			map.put("Msg","无效卡");
			return JSONUtils.toJson(map);
		}
		map.put("Status",1);
		map.put("Msg","");
		map.put("Name","");
		map.put("CardNo","");
		map.put("Money","0");
		map.put("Subsidy","0");
		map.put("Times","0");
		map.put("Integral","0");
		map.put("InTime","");
		map.put("OutTime","");
		map.put("CumulativeTime","");
		map.put("Amount","0");
		map.put("VoiceID",seatOrderDO.getState()+"");
		map.put("Text","类型："+seatOrderDO.getInfo()+"\r\n卡号："+jsonObject.getString("CardNo")
				+"\r\n消费："+seatOrderDO.getAmout()+"元\r\n"+seatOrderDO.getRemark()+"元");
		return JSONUtils.toJson(map);

	}






//	@ResponseBody
//	@PostMapping("/OffLines")
//	public String OffLines(Map<String,Object> map, @RequestBody JSONObject jsonObject){
//		log.info("OffLines.......");
//
//		map.put("Status",1);
//		map.put("Msg","");
//		map.put("Order","111111111111");
//		return JSONUtils.toJson(map);
//
//	}
//
//	@ResponseBody
//	@PostMapping(value = "/QRCodeTransaction", produces = "application/json;charset=GB2312")
//	public String QRCodeTransaction(Map<String,Object> map, HttpServletRequest request) throws Exception {
//
//		JSONObject requestJson = httpRequestParseToJson(request);
//		log.info("QRCodeTransaction......."+ JSON.toJSONString(requestJson));
//		map.put("Status",1);
//		map.put("Msg","");
//		map.put("Qrorder",requestJson.getString("QR"));
//		return JSONUtils.toJson(map);
//
//	}
//
//	private JSONObject httpRequestParseToJson(HttpServletRequest httpRequest) throws Exception {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpRequest.getInputStream(), "GB2312"));
//		StringBuilder appendText = new StringBuilder();
//		try {
//			String inputString;
//			while ((inputString = bufferedReader.readLine()) != null) {
//				appendText.append(inputString);
//			}
//
//			return JSONObject.parseObject(appendText.toString());
//		} finally {
//			if (bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}
//	}
//
//	@ResponseBody
//	@PostMapping(value = "/TransactionInquiry", produces = "application/json;charset=GB2312")
//	public String TransactionInquiry(Map<String,Object> map, @RequestBody JSONObject jsonObject){
//		log.info("TransactionInquiry.......");
//
//		map.put("Status",1);
//		map.put("Msg","");
//		map.put("Name","小张");
//
//		map.put("CardNo",jsonObject.getString("QROrder"));
//		map.put("Money","3217.99");
//		map.put("Subsidy","10000.00");
//		map.put("Times","0");
//		map.put("Integral","0");
//
//		map.put("InTime","");
//		map.put("OutTime","");
//		map.put("CumulativeTime","");
//		map.put("Amount","15.00");
//		map.put("VoiceID","");
//		map.put("Text","显示5678");
//		return JSONUtils.toJson(map);
//
//	}

	
}
