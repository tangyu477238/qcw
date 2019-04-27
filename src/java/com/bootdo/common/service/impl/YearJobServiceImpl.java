package com.bootdo.common.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.biz.dao.ProxyipDao;
import com.bootdo.biz.domain.*;
import com.bootdo.biz.service.BrandModelPailiangService;
import com.bootdo.biz.service.BrandModelService;
import com.bootdo.biz.service.BrandModelYearService;
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
public class YearJobServiceImpl implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		BrandModelPailiangService brandService = ApplicationContextRegister.getBean(BrandModelPailiangService.class);
		ProxyipDao proxyDao = ApplicationContextRegister.getBean(ProxyipDao.class);
		BrandModelService brandModelService = ApplicationContextRegister.getBean(BrandModelService.class);


		Map proxyMap = new HashMap();
		proxyMap.put("sort","");


		List<BrandModelPailiangDO> bdlist = brandService.list(new HashMap());

		for (BrandModelPailiangDO brandModelPailiangDO : bdlist) {
			boolean flag = true;
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					Map pmap = new HashMap();
					pmap.put("id",brandModelPailiangDO.getPid());
					BrandModelDO bdmDo = brandModelService.getBrandModel(pmap);
					new Thread(new Brand(bdmDo,brandModelPailiangDO, proxyMap)).start();
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
		BrandModelPailiangDO bmpd;
		Map prxmap;
		public Brand( BrandModelDO bmd,BrandModelPailiangDO bmpd, Map prxmap){
			this.bmd = bmd;
			this.bmpd = bmpd;
			this.prxmap = prxmap;
		}


		public void run() {


			try {

				proYear(bmd,bmpd,prxmap);

			}catch (Exception e){
				System.out.println("--------出错啦-----");
				e.printStackTrace();
			}
		}
	}



	public void proYear(BrandModelDO bmd, BrandModelPailiangDO bmpd, Map prxmap)throws Exception{
		Map map;
		BrandModelYearService brandModelYearService = ApplicationContextRegister.getBean(BrandModelYearService.class);
		//汽车品牌型号的年份处理
		Thread.sleep(1500);
		Map<String, String> params4 = new HashMap();
		params4.put("callback", "__GetCarBrands__");
		params4.put("VehicleID", bmd.getProductid());
		params4.put("PaiLiang", bmpd.getName());
		params4.put("_", System.currentTimeMillis()+"");
		HttpClientResult result4 = HttpClientUtils.doGet(prxmap,"https://item.tuhu.cn/Car/SelectVehicle", params4);
		System.out.println();
		System.out.println();
		String nian = result4.getContent().replace("__GetCarBrands__(", "");
		nian = nian.substring(0,nian.length()-1);
		JSONObject nianJson =JSONObject.parseObject(nian);
		JSONArray nianArr = JSONArray.parseArray(nianJson.getString("Nian"));

		BrandModelYearDO bmyd;
		for (int i = 0; i < nianArr.size(); i++) {
			JSONObject nianObj = (JSONObject) nianArr.get(i);
			map = new HashMap<String, Object>();
			map.put("pkey", nianObj.getString("Key"));
			map.put("name", nianObj.getString("Value"));
			map.put("pid", bmpd.getId());
			bmyd = brandModelYearService.getBrandModelYear(map);
			if (bmyd == null) {
				bmyd = new BrandModelYearDO();
				bmyd.setPkey(nianObj.getString("Key"));
				bmyd.setName(nianObj.getString("Value"));
				bmyd.setPid(bmpd.getId());
				brandModelYearService.save(bmyd);
			}


		}
	}


}
