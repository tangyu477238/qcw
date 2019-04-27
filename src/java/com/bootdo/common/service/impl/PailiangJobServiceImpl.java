package com.bootdo.common.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.biz.dao.ProxyipDao;
import com.bootdo.biz.domain.*;
import com.bootdo.biz.service.BrandModelPailiangService;
import com.bootdo.biz.service.BrandModelService;
import com.bootdo.biz.service.BrandService;
import com.bootdo.common.config.ApplicationContextRegister;
import com.bootdo.common.utils.HttpClientResult;
import com.bootdo.common.utils.HttpClientUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PailiangJobServiceImpl implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		BrandModelService brandService = ApplicationContextRegister.getBean(BrandModelService.class);
		ProxyipDao proxyDao = ApplicationContextRegister.getBean(ProxyipDao.class);


		Map proxyMap = new HashMap();
		proxyMap.put("sort","");


		List<BrandModelDO> bdlist = brandService.list(new HashMap());

		for (BrandModelDO brandModelDO : bdlist) {
			boolean flag = true;
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					new Thread(new Brand(brandModelDO, proxyMap)).start();
					flag = false;
				}catch (Exception e){
					proxyDao.remove(proxylist.get(pr).getId());
					System.out.println("移除ip:"+proxylist.get(pr).getIp());
				}

			}
		}



	}



	class Brand implements Runnable{

		BrandModelDO bmd;

		Map prxmap;
		public Brand( BrandModelDO bmd, Map prxmap){

			this.bmd = bmd;
			this.prxmap = prxmap;
		}


		public void run() {


			try {

				proPailiang(bmd,prxmap);

			}catch (Exception e){
				System.out.println("--------出错啦-----");
				e.printStackTrace();
			}
		}
	}



	public void proPailiang(BrandModelDO bmd , Map prxmap )throws Exception{
		Map map;
		BrandModelPailiangService brandPailiangModelService = ApplicationContextRegister.getBean(BrandModelPailiangService.class);
		Thread.sleep(1500);
		//汽车品牌型号的排量处理
		Map<String, String> params3 = new HashMap();
		params3.put("callback", "__GetCarBrands__");
		params3.put("VehicleID", bmd.getProductid());
		params3.put("_", System.currentTimeMillis()+"");
		HttpClientResult result3 = HttpClientUtils.doGet(prxmap,"https://item.tuhu.cn/Car/SelectVehicle", params3);
		System.out.println();
		System.out.println();
		String pailiang = result3.getContent().replace("__GetCarBrands__(","");
		pailiang = pailiang.substring(0,pailiang.length()-1);
		JSONObject pailiangJson = JSONObject.parseObject(pailiang);
		JSONArray pailiangArr = JSONArray.parseArray(pailiangJson.getString("PaiLiang"));

		BrandModelPailiangDO bmpd;
		for (int l = 0; l < pailiangArr.size(); l++) {
			JSONObject pailiangObj =
					(JSONObject) pailiangArr.get(l);
			map = new HashMap<String, Object>();
			map.put("pkey",pailiangObj.getString("Key"));
			map.put("name",pailiangObj.getString("Value"));
			map.put("pid",bmd.getId());
			bmpd = brandPailiangModelService.getBrandModelPailiang(map);
			if (bmpd == null){
				bmpd = new BrandModelPailiangDO();
				bmpd.setPkey(pailiangObj.getString("Key"));
				bmpd.setName(pailiangObj.getString("Value"));
				bmpd.setPid(bmd.getId());
				brandPailiangModelService.save(bmpd);
			}



		}
	}


}
