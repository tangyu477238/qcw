package com.bootdo.common.utils;

//import com.bootdo.biz.domain.BrandDO;
//import com.bootdo.biz.service.BrandService;
//import org.springframework.beans.factory.annotation.Autowired;


import com.bootdo.biz.dao.BrandDao;
import com.bootdo.common.config.ApplicationContextRegister;
import com.bootdo.system.dao.UserDao;

import java.util.HashMap;
import java.util.Map;


/**
 * Description: HttpClientUtils工具类测试
 * 
 * @author JourWon
 * @date Created on 2018年4月19日
 */
public class HttpClientUtilsTest {

////    @Autowired
////    private BrandService brandService;
//
//	/**
//	 * Description: 测试get无参请求
//	 *
//	 * @throws Exception
//	 */
//
//	public void testGet() throws Exception {
//		HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/hello/get");
//		System.out.println(result);
//	}
//
//	/**
//	 * Description: 测试get带参请求
//	 *
//	 * @throws Exception
//	 */
//
//
//
//	/**
//	 * Description: 测试post带请求头不带请求参数
//	 *
//	 * @throws Exception
//	 */
//
//	public void testPost() throws Exception {
//		Map<String, String> headers = new HashMap<String, String>();
//		headers.put("Cookie", "123");
//		headers.put("Connection", "keep-alive");
//		headers.put("Accept", "application/json");
//		headers.put("Accept-Language", "zh-CN,zh;q=0.9");
//		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
//		HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8080/hello/post", headers, null);
//		System.out.println(result);
//	}
//
//	/**
//	 * Description: 测试post带参请求
//	 *
//	 * @throws Exception
//	 */
//
//	public void testPostWithParam() throws Exception {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("code", "0");
//		params.put("message", "helloworld");
//		HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8080/hello/postWithParam", params);
//		System.out.println(result);
//	}
//	public  void testGetWithParam() throws Exception {
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("callback", "__GetCarBrands__");
//		params.put("_", "1553611138904");
//		HttpClientResult result = HttpClientUtils.doGet("https://item.tuhu.cn/Car/GetCarBrands2", params);
//		System.out.println(result.getContent().replace("__GetCarBrands__(","").replace(")",""));
////
////        BrandDO bd = new BrandDO();
////        brandService.save(bd);
//	}






	public static void main (String str []){
		try {



			Map<String, String> params = new HashMap<String, String>();
			params.put("callback", "__GetCarBrands__");
			params.put("_", "1553611138904");
			Map proxyMap = new HashMap();
			proxyMap.put("ip","123.139.56.238");
			proxyMap.put("port","9999");
			proxyMap.put("http","HTTP");
			HttpClientResult result = HttpClientUtils.doGet(proxyMap,
							"https://item.tuhu.cn/Car/GetCarBrands2", params);
            String brand = result.getContent().replace("__GetCarBrands__(","").replace(")","");
			System.out.println(brand);
//



//			JSONObject jsonObject = new JSONObject(brand);
//			Iterator iterator = jsonObject.keys();
//			String key;
//			String value;
//			while(iterator.hasNext()){
//				 key = (String) iterator.next();
//				 value = jsonObject.getString(key);
////				 System.out.println(key + "-------" + value);
//			}
//
//			Map<String, String> params2 = new HashMap<String, String>();
//			params2.put("callback", "__GetCarBrands__");
//			params2.put("Brand", "Q - 奇瑞");
//			params2.put("_", "1553611138904");
//			HttpClientResult result2 = HttpClientUtils.doGet("https://item.tuhu.cn/Car/SelOneBrand", params2);
//			System.out.println(result2);
//
//			Map<String, String> params3 = new HashMap<String, String>();
//			params3.put("callback", "__GetCarBrands__");
//			params3.put("VehicleID", "VE-SAIC07CS");
//			params3.put("_", "1553611138904");
//			HttpClientResult result3 = HttpClientUtils.doGet("https://item.tuhu.cn/Car/SelectVehicle", params3);
//			System.out.println(result3);
//
//			Map<String, String> params4 = new HashMap<String, String>();
//			params4.put("callback", "__GetCarBrands__");
//			params4.put("VehicleID", "VE-SAIC07CS");
//			params4.put("PaiLiang", "1.0L");
//			params4.put("_", "1553611138904");
//			HttpClientResult result4 = HttpClientUtils.doGet("https://item.tuhu.cn/Car/SelectVehicle", params4);
//			System.out.println(result4);

//			Map<String, String> headers = new HashMap();
//			headers.put("Cookie", " shoppingCart_quantity=0; thzzWebsite=1552296384-8512fc3b6b1b00a9; NTKF_T2D_CLIENTID=guest51205B75-B5C5-5D46-42CB-6C131698B1D4; deviceid=c383a1fa-1ee9-4dd4-84cb-450449ef5d24; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22%24device_id%22%3A%221696c13115cbb3-029e4d56c1a4e8-38395c0b-2073600-1696c13115d660%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%7D; clicksession=1554106317-903840952583bbfb; Qs_lvt_73951=1552296384%2C1554106317; nTalk_CACHE_DATA={uid:kf_9739_ISME9754_guest51205B75-B5C5-5D,tid:1554106317582240}; Hm_lvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1552296384,1554106318; _um_deti=502778240f52408f87ffb39a0261a2908; _um_deti=502778240f52408f87ffb39a0261a2908; Qs_pv_73951=3600233263778680300%2C1683676854839722500%2C2613626171223773700%2C380367262096380900%2C4431538857288140300; city=1%7c%e5%8c%97%e4%ba%ac%e5%b8%82%7c1%7c1%7c%7c1; shopcover=; city=1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1%7C1%7C%E4%B8%8A%E6%B5%B7%E5%B8%82%7C1; Hm_lpvt_cec8ce2d875c5cc615e9bfdf73d4e2fd=1554106349; defaultCar=0%7CVE-GREA05AJ%7CC%20-%20%E9%95%BF%E5%9F%8E%7C%E5%A4%A7%E8%84%9A%E5%85%BD-%E9%95%BF%E5%9F%8E%E6%B1%BD%E8%BD%A6%7C2.2L%7C2005%7C205%2F70R14%7C%7C%7C%7C%7C%7Chttps%3A%2F%2Fimg4.tuhu.org%2FImages%2FLogo%2Fchangcheng.png%40100Q.png%3BProperties%3D%5B%5D%3BTid%3D%3BSalesName%3D");
//			headers.put("referer", " https://by.tuhu.cn/baoyang/");
//			Map<String, String> params5 = new HashMap<String, String>();
//			params5.put("vehicle", "{\"Brand\":\"A - 奥迪\",\"VehicleId\":\"VE-AUDF96AE\",\"PaiLiang\":\"1.8L\",\"Nian\":\"1996\",\"Tid\":\"\",\"Properties\":null}");
//			HttpClientResult result5 = HttpClientUtils.doGet("https://by.tuhu.cn/change/GetBaoYangPackages.html",headers, params5);
//			System.out.println(result5);

//			BrandDao userMapper = ApplicationContextRegister.getBean(BrandDao.class);

//			Map<String, String> params5 = new HashMap<String, String>();
//			params5.put("vehicle", "{\"Brand\":\"A - 奥迪\",\"VehicleId\":\"VE-AUDF96AE\",\"PaiLiang\":\"1.8L\",\"Nian\":\"1996\",\"Tid\":\"\",\"Properties\":null}");
//			HttpClientResult result5 = HttpClientUtils.doGet("https://by.tuhu.cn/change/GetBaoYangPackageDescription.html", params5);
//			System.out.println(result5);


		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
