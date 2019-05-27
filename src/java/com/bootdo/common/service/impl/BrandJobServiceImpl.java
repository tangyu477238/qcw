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
public class BrandJobServiceImpl implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		BrandService brandService = ApplicationContextRegister.getBean(BrandService.class);
		BrandInitialService brandInitialService = ApplicationContextRegister.getBean(BrandInitialService.class);

		ProxyipDao proxyDao = ApplicationContextRegister.getBean(ProxyipDao.class);


		try{
			Map proxyMap = new HashMap();
			proxyMap.put("sort","");
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			org.activiti.engine.impl.util.json.JSONObject jsonObject = null;
			boolean flag = true;
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++){

				try {
					proxyMap.put("ip",proxylist.get(pr).getIp());
					proxyMap.put("port",proxylist.get(pr).getPort().toString());
					proxyMap.put("http","HTTP");

					Thread.sleep(500);
					//取得所有的品牌首字母和品牌
					Map<String, String> params = new HashMap();
					params.put("callback", "__GetCarBrands__");
					params.put("_", System.currentTimeMillis()+"");
					HttpClientResult result
							= HttpClientUtils.doGet(proxyMap
							,"https://item.tuhu.cn/Car/GetCarBrands2"
							,params);
					String brand = result.getContent().replace("__GetCarBrands__(", "");
					brand = brand.substring(0,brand.length()-1);
					jsonObject =
							new org.activiti.engine.impl.util.json.JSONObject(brand);
					flag = false;
				}catch (Exception e){
					proxyDao.remove(proxylist.get(pr).getId());
					System.out.println("移除ip:"+proxylist.get(pr).getIp());
				}

			}



			Iterator iterator = jsonObject.keys();
			String key;
			String value;
			BrandDO bd = null;
			BrandInitialDO bid = null;
			BrandModelDO bmd = null;
			BrandModelPailiangDO bmpd = null;
			BrandModelYearDO bmyd = null;
			ProductDO pd = null;
			BrandProductDO bpd = null;
			Map map ;
			//品牌首字母处理
			while(iterator.hasNext()){
				 key = (String) iterator.next();
				 map = new HashMap<String, Object>();
				 map.put("name",key);
				 List<BrandInitialDO> list = brandInitialService.list(map);
				 if (list.size()<1){
					 bid = new BrandInitialDO();
					 bid.setName(key);
					 brandInitialService.save(bid);
				 }





				 value = jsonObject.getString(key);
				 JSONArray arr = JSONArray.parseArray(value);
	//			 System.out.println(key + "-------" + value);
				//汽车品牌处理
				for (int j = 0; j < arr.size(); j++) {
					Thread.sleep(1000);
					JSONObject json = (JSONObject)arr.get(j) ;
					if (j<proxylist.size() && key.equals("A")){
						try {
							Map prxmap = new HashMap();
							prxmap.put("ip",proxylist.get(j).getIp());
							prxmap.put("port",proxylist.get(j).getPort()+"");
							prxmap.put("http","HTTP");

							new Thread(new Brand(map,bd,bid,bmd,bmpd,bmyd,pd,bpd
									,json,key,brandService,prxmap,proxyDao)).start();
						}catch (Exception e){
							System.out.println("error: "+proxylist.get(j).getIp()+"----"+proxylist.get(j).getPort());
							e.printStackTrace();
						}


					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	class Brand implements Runnable{
		Map map;
		BrandDO bd;
		BrandInitialDO bid;
		BrandModelDO bmd;
		BrandModelPailiangDO bmpd;
		BrandModelYearDO bmyd;
		ProductDO pd;
		BrandProductDO bpd;

		BrandService brandService;
		JSONObject json;
		String key;
		Map prxmap;
		ProxyipDao proxyDao;
		public Brand(Map map,BrandDO bd,BrandInitialDO bid,BrandModelDO bmd
				,BrandModelPailiangDO bmpd,BrandModelYearDO bmyd,ProductDO pd,BrandProductDO bpd
				,JSONObject json,String key,BrandService brandService,Map prxmap,ProxyipDao proxyDao){
			this.map = map;
			this.bd = bd;
			this.bid = bid;
			this.bmd = bmd;
			this.bmpd = bmpd;
			this.bmyd = bmyd;
			this.pd = pd;
			this.bpd = bpd;

			this.key = key;
			this.json = json;
			this.brandService = brandService;
			this.prxmap = prxmap;
			this.proxyDao = proxyDao;
		}


		public void run() {

			map = new HashMap<String, Object>();
			map.put("brand",json.getString("Brand"));
			bd = brandService.getBrand(map);
			if (bd == null){
				bd = new BrandDO();
				bd.setBrand(json.getString("Brand"));
				bd.setImageurl(json.getString("ImageUrl"));
				bd.setUrl(json.getString("Url"));
				bd.setPid(key);
				brandService.save(bd);
			}
			if (bd.getId()==null){
				bd = brandService.getBrand(map);
			}

			try {

				proModel(map, bd, bid, bmd, bmpd, bmyd, pd, bpd, prxmap,proxyDao);

			}catch (Exception e){
				System.out.println("--------出错啦-----");
				e.printStackTrace();
			}
		}
	}



	public void proModel(Map map,BrandDO bd,BrandInitialDO bid,BrandModelDO bmd
			,BrandModelPailiangDO bmpd,BrandModelYearDO bmyd,ProductDO pd
			,BrandProductDO bpd,Map prxmap,ProxyipDao proxyDao)throws Exception{

		BrandModelService brandModelService = ApplicationContextRegister.getBean(BrandModelService.class);

		Thread.sleep(500);
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
			if (bmd.getId()==null){
				bmd = brandModelService.getBrandModel(map);
			}



			Map proxyMap = new HashMap();
			proxyMap.put("sort","");
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			boolean flag = true;
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					proPailiang(map, bd, bid, bmd, bmpd, bmyd, pd, bpd, proxyMap,proxyDao);
					flag = false;
				}catch (Exception e){
					System.out.println("获取型号出错："+bd.getBrand()+"----");
				}

			}
		}

	}

	public void proPailiang(Map map,BrandDO bd,BrandInitialDO bid,BrandModelDO bmd
			,BrandModelPailiangDO bmpd,BrandModelYearDO bmyd,ProductDO pd
			,BrandProductDO bpd,Map prxmap,ProxyipDao proxyDao)throws Exception{

		BrandModelPailiangService brandPailiangModelService = ApplicationContextRegister.getBean(BrandModelPailiangService.class);
		Thread.sleep(500);
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

//					System.out.println(pailiangArr.toString());
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
			if (bmpd.getId()==null){
				bmpd = brandPailiangModelService.getBrandModelPailiang(map);
			}


			Map proxyMap = new HashMap();
			proxyMap.put("sort","");
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			boolean flag = true;
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					proYear(map,bd,bid,bmd,bmpd,bmyd,pd,bpd,proxyMap,proxyDao);
					flag = false;
				}catch (Exception e){
					System.out.println("获取年份出错："+bd.getBrand()+"----"+bmd.getCarname());
					//e.printStackTrace();
				}

			}


		}
	}

	public void proYear(Map map,BrandDO bd,BrandInitialDO bid,BrandModelDO bmd
			,BrandModelPailiangDO bmpd,BrandModelYearDO bmyd,ProductDO pd
			,BrandProductDO bpd,Map prxmap,ProxyipDao proxyDao)throws Exception{

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

//						System.out.println(pailiangArr.toString());
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
			if (bmyd.getId() == null) {
				bmyd = brandModelYearService.getBrandModelYear(map);
			}
			Thread.sleep(500);



			Map proxyMap = new HashMap();
			proxyMap.put("sort","");
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			boolean flag = true;
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					proProduct(map,bd,bid,bmd,bmpd,bmyd,pd,bpd,proxyMap);
					flag = false;
				}catch (Exception e){
					System.out.println("获取产品出错："+bd.getBrand()+"----"+bmd.getCarname()+"----"+bmpd.getName());
				}

			}

		}
	}





	/***
	 *
	 * @param map
	 * @param bd
	 * @param bid
	 * @param bmd
	 * @param bmpd
	 * @param bmyd
	 * @param pd
	 * @param bpd
	 */
	public void proProduct(Map map,BrandDO bd,BrandInitialDO bid,BrandModelDO bmd
			,BrandModelPailiangDO bmpd,BrandModelYearDO bmyd,ProductDO pd
			,BrandProductDO bpd,Map prxmap)throws Exception{
		ProductService productService = ApplicationContextRegister.getBean(ProductService.class);
		BrandProductDao brandProductDao = ApplicationContextRegister.getBean(BrandProductDao.class);

//		//获取产品存储
//		Map<String, String> headers = new HashMap();
//		headers.put("Cookie", " shoppingCart_quantity=0; thzzWebsite=1552296384-8512fc3b6b1b00a9; NTKF_T2D_CLIENTID=guest51205B75-B5C5-5D46-42CB-6C131698B1D4; deviceid=c383a1fa-1ee9-4dd4-84cb-450449ef5d24; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22%24device_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%7D; clicksession=1554106317-903840952583bbfb; Qs_lvt_73951=1552296384%2C1554106317; nTalk_CACHE_DATA={uid:kf_9739_ISME9754_guest51205B75-B5C5-5D,tid:1554106317582240}; Hm_lvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1552296384,1554106318; _um_deti=502778240f52408f87ffb39a0261a2908; _um_deti=502778240f52408f87ffb39a0261a2908; Qs_pv_73951=3600233263778680300%2C1683676854839722500%2C2613626171223773700%2C380367262096380900%2C4431538857288140300; city=1%7c%e5%8c%97%e4%ba%ac%e5%b8%82%7c1%7c1%7c%7c1; shopcover=; city=1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1%7C1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1; Hm_lpvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1554106349; defaultCar=0%7CVE-GREA05AJ%7CC%20-%20%E9%95%BF%E5%9F%8E%7C%E5%A4%A7%E8%84%9A%E5%85%BD-%E9%95%BF%E5%9F%8E%E6%B1%BD%E8%BD%A6%7C2.2L%7C2005%7C205%2F70R14%7C%7C%7C%7C%7C%7Chttps%3A%2F%2Fimg4.tuhu.org%2FImages%2FLogo%2Fchangcheng.png%40100Q.png%3BProperties%3D%5B%5D%3BTid%3D%3BSalesName%3D");
//		headers.put("referer", " https://by.tuhu.cn/baoyang/");
//
//		Map<String, String> params5 = new HashMap<String, String>();
//		params5.put("vehicle", "{\"Brand\":\""+bd.getBrand()+"\",\"VehicleId\":\""+bmd.getProductid()+"\",\"PaiLiang\":\""+bmpd.getName()+"\",\"Nian\":\""+bmyd.getName()+"\",\"Tid\":\"\",\"Properties\":null}");
//		HttpClientResult result5 = HttpClientUtils.doGet(prxmap,"https://by.tuhu.cn/change/GetBaoYangPackages.html",headers, params5);
//
//		JSONArray prodArr1 = JSONArray.parseArray(result5.getContent());
//		JSONObject prodObj1 = prodArr1.getJSONObject(0);
//		JSONArray prodArr2 = JSONArray.parseArray(prodObj1.getString("Items"));
//		//取得小保养
//		JSONObject prodObj2 = prodArr2.getJSONObject(0);
//		//小保养对应的油分类
//		JSONArray prodArr3 = JSONArray.parseArray(prodObj2.getString("Items"));
//		//机油
//		JSONObject prodObj3 = prodArr3.getJSONObject(0);
//		//机油下的产品
//		JSONArray prodArr4 = JSONArray.parseArray(prodObj3.getString("Products"));
//
//		//清除历史品牌与产品记录
//		map = new HashMap<String, Object>();
//		map.put("pid", bmyd.getId());
//		brandProductDao.delBrandProduct(map);
//
//		for (int m = 0; prodArr4 != null && m < prodArr4.size(); m++) {
//			JSONObject prodObj4 = prodArr4.getJSONObject(m);
//			JSONObject prodObj = prodObj4.getJSONObject("Product");
//
//			map = new HashMap<String, Object>();
//			map.put("productId", prodObj.getString("Pid"));
//			pd = productService.getProduct(map);
//			if (pd == null){
//				pd = new ProductDO();
//				pd.setDisplayName(prodObj.getString("DisplayName"));
//				pd.setImage(prodObj.getString("Image"));
//				pd.setPrice(prodObj.getBigDecimal("Price"));
//				pd.setMarketingPrice(prodObj.getBigDecimal("MarketingPrice"));
//				pd.setPrimaryParentCategory(prodObj.getString("PrimaryParentCategory"));
//				pd.setProductId(prodObj.getString("Pid"));
//				pd.setUnit(prodObj.getString("Unit"));
//				pd.setVariantId(prodObj.getString("VariantId"));
//				productService.save(pd);
//			}
//			if(pd.getId()==null){
//				pd = productService.getProduct(map);
//			}
//
//			bpd = new BrandProductDO();
//			bpd.setPid(bmyd.getId());
//			bpd.setProdId(pd.getId());
//			brandProductDao.save(bpd);
//
//		}
	}

}
