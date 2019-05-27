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
import java.util.List;
import java.util.Map;

@Service
public class ProdJobServiceImpl implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		BrandModelPailiangService brandModelPailiangService = ApplicationContextRegister.getBean(BrandModelPailiangService.class);
		ProxyipDao proxyDao = ApplicationContextRegister.getBean(ProxyipDao.class);
		BrandModelService brandModelService = ApplicationContextRegister.getBean(BrandModelService.class);
		BrandModelYearService brandModelYearService = ApplicationContextRegister.getBean(BrandModelYearService.class);
		BrandService brandService = ApplicationContextRegister.getBean(BrandService.class);


		Map proxyMap = new HashMap();
		proxyMap.put("sort","");


		List<BrandModelYearDO> bdlist = brandModelYearService.list(new HashMap());

		for (BrandModelYearDO brandModelYearDO : bdlist) {
			boolean flag = true;
			List<ProxyipDO> proxylist = proxyDao.list(proxyMap);
			for (int pr = 0 ; proxylist!=null && proxylist.size()>0 && pr<proxylist.size() && flag;pr++) {
				proxyMap.put("ip", proxylist.get(pr).getIp());
				proxyMap.put("port", proxylist.get(pr).getPort().toString());
				proxyMap.put("http", "HTTP");
				try {
					Map pmap = new HashMap();
					pmap.put("id",brandModelYearDO.getPid());
					BrandModelPailiangDO bmpd = brandModelPailiangService.getBrandModelPailiang(pmap);

					pmap.put("id",bmpd.getPid());
					BrandModelDO bmd = brandModelService.getBrandModel(pmap);

					pmap.put("id",bmd.getPid());
					BrandDO bd = brandService.getBrand(pmap);

					new Thread(new Brand(bd,bmd, bmpd,brandModelYearDO,proxyMap)).start();
					flag = false;
				}catch (Exception e){
					proxyDao.remove(proxylist.get(pr).getId());
					System.out.println("移除ip:"+proxylist.get(pr).getIp());
				}

			}
		}



	}



	class Brand implements Runnable{

		BrandDO bd ;
		BrandModelDO bmd;
		BrandModelPailiangDO bmpd;
		BrandModelYearDO bmyd;
		Map prxmap;
		public Brand(BrandDO bd,BrandModelDO bmd,BrandModelPailiangDO bmpd
				,BrandModelYearDO bmyd, Map prxmap){
			this.bd = bd;
			this.bmd = bmd;
			this.bmpd = bmpd;
			this.bmyd = bmyd;
			this.prxmap = prxmap;
		}


		public void run() {


			try {

				proProduct(bd,bmd,bmpd,bmyd,prxmap);

			}catch (Exception e){
				System.out.println("--------出错啦-----");
				e.printStackTrace();
			}
		}
	}


	public void proProduct(BrandDO bd, BrandModelDO bmd
			, BrandModelPailiangDO bmpd, BrandModelYearDO bmyd, Map prxmap)throws Exception{


		Map map;
		BrandProductDO bpd;
		ProductDO pd;

		ProductService productService = ApplicationContextRegister.getBean(ProductService.class);
		BrandProductDao brandProductDao = ApplicationContextRegister.getBean(BrandProductDao.class);
		Thread.sleep(1000);
		//获取产品存储
		Map<String, String> headers = new HashMap();
		headers.put("Cookie", " shoppingCart_quantity=0; thzzWebsite=1552296384-8512fc3b6b1b00a9; NTKF_T2D_CLIENTID=guest51205B75-B5C5-5D46-42CB-6C131698B1D4; deviceid=c383a1fa-1ee9-4dd4-84cb-450449ef5d24; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22%24device_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%7D; clicksession=1554106317-903840952583bbfb; Qs_lvt_73951=1552296384%2C1554106317; nTalk_CACHE_DATA={uid:kf_9739_ISME9754_guest51205B75-B5C5-5D,tid:1554106317582240}; Hm_lvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1552296384,1554106318; _um_deti=502778240f52408f87ffb39a0261a2908; _um_deti=502778240f52408f87ffb39a0261a2908; Qs_pv_73951=3600233263778680300%2C1683676854839722500%2C2613626171223773700%2C380367262096380900%2C4431538857288140300; city=1%7c%e5%8c%97%e4%ba%ac%e5%b8%82%7c1%7c1%7c%7c1; shopcover=; city=1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1%7C1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1; Hm_lpvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1554106349; defaultCar=0%7CVE-GREA05AJ%7CC%20-%20%E9%95%BF%E5%9F%8E%7C%E5%A4%A7%E8%84%9A%E5%85%BD-%E9%95%BF%E5%9F%8E%E6%B1%BD%E8%BD%A6%7C2.2L%7C2005%7C205%2F70R14%7C%7C%7C%7C%7C%7Chttps%3A%2F%2Fimg4.tuhu.org%2FImages%2FLogo%2Fchangcheng.png%40100Q.png%3BProperties%3D%5B%5D%3BTid%3D%3BSalesName%3D");
		headers.put("referer", " https://by.tuhu.cn/baoyang/");

		Map<String, String> params5 = new HashMap<String, String>();
		params5.put("vehicle", "{\"Brand\":\""+bd.getBrand()+"\",\"VehicleId\":\""+bmd.getProductid()+"\",\"PaiLiang\":\""+bmpd.getName()+"\",\"Nian\":\""+bmyd.getName()+"\",\"Tid\":\"\",\"Properties\":null}");
		HttpClientResult result5 = HttpClientUtils.doGet(prxmap,"https://by.tuhu.cn/change/GetBaoYangPackages.html",headers, params5);

		JSONArray prodArr1 = JSONArray.parseArray(result5.getContent());
		JSONObject prodObj1 = prodArr1.getJSONObject(0);
		JSONArray prodArr2 = JSONArray.parseArray(prodObj1.getString("Items"));
		//取得小保养
		JSONObject prodObj2 = prodArr2.getJSONObject(0);
		//小保养对应的油分类
		JSONArray prodArr3 = JSONArray.parseArray(prodObj2.getString("Items"));
		//机油
		JSONObject prodObj3 = prodArr3.getJSONObject(0);
		//机油下的产品
		JSONArray prodArr4 = JSONArray.parseArray(prodObj3.getString("Products"));

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
