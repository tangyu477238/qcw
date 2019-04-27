package com.bootdo.common.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.biz.dao.BrandProductDao;
import com.bootdo.biz.dao.ProxyipDao;
import com.bootdo.biz.domain.*;
import com.bootdo.biz.service.*;
import com.bootdo.common.config.ApplicationContextRegister;
import com.bootdo.common.utils.HttpClientResult;
import com.bootdo.common.utils.HttpClientUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ModelJobServiceImpl implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		BrandService brandService = ApplicationContextRegister.getBean(BrandService.class);
		ProxyipDao proxyDao = ApplicationContextRegister.getBean(ProxyipDao.class);


		Map proxyMap = new HashMap();
		proxyMap.put("sort","");


		List<BrandDO> bdlist = brandService.list(new HashMap());

		for (BrandDO brandDO : bdlist) {
			boolean flag = true;
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					new Thread(new Brand(brandDO, proxyMap)).start();
					flag = false;
				}catch (Exception e){
					proxyDao.remove(proxylist.get(pr).getId());
					System.out.println("移除ip:"+proxylist.get(pr).getIp());
				}

			}
		}



	}



	class Brand implements Runnable{

		BrandDO bd;

		Map prxmap;
		public Brand( BrandDO bd, Map prxmap){

			this.bd = bd;
			this.prxmap = prxmap;
		}


		public void run() {


			try {

				proModel(bd,prxmap );

			}catch (Exception e){
				System.out.println("--------出错啦-----");
				e.printStackTrace();
			}
		}
	}



	public void proModel(BrandDO bd,Map prxmap)throws Exception{

		BrandModelService brandModelService = ApplicationContextRegister.getBean(BrandModelService.class);
		Map map;
		Thread.sleep(1500);
		//汽车品牌型号处理
		Map<String, String> params2 = new HashMap();
		params2.put("callback", "__GetCarBrands__");
		params2.put("Brand", bd.getBrand());
		params2.put("_", System.currentTimeMillis()+"");
		HttpClientResult result2 =
				HttpClientUtils.doGet(prxmap
						,"https://item.tuhu.cn/Car/SelOneBrand", params2);
		System.out.println();
		System.out.println();
		//System.out.println(result2);
		String model = result2.getContent().replace("__GetCarBrands__(", "");
		model = model.substring(0,model.length()-1);
		JSONObject modelJson = JSONObject.parseObject(model);
		JSONArray modelArr = JSONArray.parseArray(modelJson.getString("OneBrand"));
		BrandModelDO bmd;
		for (int k = 0; k < modelArr.size(); k++) {
			JSONObject modelObj = (JSONObject) modelArr.get(k);
			map = new HashMap<String, Object>();
			map.put("productid",modelObj.getString("ProductID"));
			map.put("pid",bd.getId());
			bmd = brandModelService.getBrandModel(map);
			if (bmd == null){
				bmd = new BrandModelDO();
				bmd.setProductid(modelObj.getString("ProductID"));
				bmd.setCarname(modelObj.getString("CarName"));
				bmd.setBrand(modelObj.getString("Brand"));
				bmd.setImageurl(modelObj.getString("ImageUrl"));
				bmd.setUrl(modelObj.getString("Url"));
				bmd.setVehicle(modelObj.getString("Vehicle"));
				bmd.setPid(bd.getId());
				bmd.setBrandtype(modelObj.getString("BrandType"));
				bmd.setVehicleseries(modelObj.getString("VehicleSeries"));
				brandModelService.save(bmd);
			}


		}

	}

}
