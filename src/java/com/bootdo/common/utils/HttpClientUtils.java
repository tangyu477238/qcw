package com.bootdo.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * Description: httpClient工具类
 * 
 * @author JourWon
 * @date Created on 2018年4月19日
 */
public class HttpClientUtils {

	// 编码格式。发送编码格式统一用UTF-8
	private static final String ENCODING = "UTF-8";
	
	// 设置连接超时时间，单位毫秒。
	private static final int CONNECT_TIMEOUT = 6000;
	
	// 请求获取数据的超时时间(即响应时间)，单位毫秒。
	private static final int SOCKET_TIMEOUT = 6000;

	/**
	 * 发送get请求；不带请求头和请求参数
	 * 
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doGet(Map<String, String> proxyMap ,String url) throws Exception {
		return doGet(proxyMap,url, null, null);
	}






	/**
	 * 发送get请求；带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doGet(Map<String, String> proxyMap ,String url, Map<String, String> params) throws Exception {
		return doGet(proxyMap,url, null, params);
	}


	public static void main(String str [] ){
		try {
			doGetByHttps("123.139.56.238",9999);

			//checkValidIP("123.139.56.238",9999);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static boolean checkValidIP(String ip,Integer port){
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL("http://www.ip138.com");
			//代理服务器
			InetSocketAddress proxyAddr = new InetSocketAddress(ip, port);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
			connection = (HttpURLConnection) url.openConnection(proxy);
			connection.setReadTimeout(4000);
			connection.setConnectTimeout(4000);
			connection.setRequestMethod("GET");

			System.out.println(connection.getResponseMessage());
			if(connection.getResponseCode() == 200){
				return true;
			}

		} catch (Exception e) {
			System.out.println(MessageFormat.format("代理IP[{0} {1}]不可用", ip,port));
		}finally {
			if(connection != null){
				connection.disconnect();
			}
		}
		return false;
	}


	/****
	 *
	 * @throws Exception
	 */
	public static void doGetByHttps(String ip,Integer port) throws Exception{

		//设置代理
		HttpHost proxy = new HttpHost(ip , port , "HTTP"); //添加代理，IP为本地IP 8888就是fillder的端口



		//采用绕过验证的方式处理https请求
		SSLContext sslcontext = createIgnoreVerifySSL();
		//设置协议http和https对应的处理socket链接工厂的对象
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext))
				.build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

//		HttpClients.custom()
//				.setProxy(proxy)
//				.setConnectionManager(connManager);


		//创建自定义的httpclient对象
		CloseableHttpClient client = HttpClients.custom()
				.setProxy(proxy)
				.setConnectionManager(connManager).build();
		//CloseableHttpClient client = HttpClients.createDefault();

		try{
			//创建post方式请求对象
			HttpPost httpPost = new HttpPost("https://www.baidu.com");


			//指定报文头Content-type、User-Agent
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

			httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");


			//执行请求操作，并拿到结果（同步阻塞）
			CloseableHttpResponse response = client.execute(httpPost);

			String body = null;
			//获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				//按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity, "UTF-8");
			}

			EntityUtils.consume(entity);
			//释放链接
			response.close();
			System.out.println("body:" + body);
		}finally{
			client.close();
		}


	}





	/**
	 * 绕过验证
	 *
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[]{trustManager}, null);
		return sc;
	}


	/**
	 * 发送get请求；带请求头和请求参数
	 * 
	 * @param url 请求地址
	 * @param headers 请求头集合
	 * @param params 请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doGet(Map<String, String> proxyMap ,String url, Map<String, String> headers, Map<String, String> params) throws Exception {
		System.out.println(proxyMap.get("ip")+"------"+proxyMap.get("port")+"---"+proxyMap.get("http"));
		//设置代理
		HttpHost proxy = new HttpHost(proxyMap.get("ip")
				, Integer.parseInt(proxyMap.get("port"))
				, proxyMap.get("http")); //添加代理，IP为本地IP 8888就是fillder的端口

		// 创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建访问的地址
		URIBuilder uriBuilder = new URIBuilder(url);
		if (params != null) {
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				uriBuilder.setParameter(entry.getKey(), entry.getValue());
			}
		}


		// 创建http对象
		HttpGet httpGet = new HttpGet(uriBuilder.build());


		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
		 * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
		 * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		 * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT)
				.setProxy(proxy)
				.build();
		httpGet.setConfig(requestConfig);
		
		// 设置请求头
		packageHeader(headers, httpGet);

		// 创建httpResponse对象
		CloseableHttpResponse httpResponse = null;

		try {
			// 执行请求并获得响应结果
			return getHttpClientResult(httpResponse, httpClient, httpGet);
		} finally {
			// 释放资源
			release(httpResponse, httpClient);
		}
	}

	/**
	 * 发送post请求；不带请求头和请求参数
	 * 
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doPost(Map<String, String> proxyMap,String url) throws Exception {
		return doPost(proxyMap,url, null, null);
	}
	
	/**
	 * 发送post请求；带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doPost(Map<String, String> proxyMap,String url, Map<String, String> params) throws Exception {
		return doPost(proxyMap,url, null, params);
	}

	/**
	 * 发送post请求；带请求头和请求参数
	 * 
	 * @param url 请求地址
	 * @param headers 请求头集合
	 * @param params 请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doPost(Map<String, String> proxyMap, String url, Map<String, String> headers, Map<String, String> params) throws Exception {
		//设置代理
		HttpHost proxy = new HttpHost(proxyMap.get("ip"),
				Integer.valueOf(proxyMap.get("port")), proxyMap.get("http")); //添加代理，IP为本地IP 8888就是fillder的端口


		// 创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建http对象
		HttpPost httpPost = new HttpPost(url);


		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
		 * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
		 * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		 * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT)
				.setProxy(proxy)
				.build();
		httpPost.setConfig(requestConfig);
		// 设置请求头
		/*httpPost.setHeader("Cookie", "");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
		httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
		httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");*/
		packageHeader(headers, httpPost);
		
		// 封装请求参数
		packageParam(params, httpPost);

		// 创建httpResponse对象
		CloseableHttpResponse httpResponse = null;

		try {
			// 执行请求并获得响应结果
			return getHttpClientResult(httpResponse, httpClient, httpPost);
		} finally {
			// 释放资源
			release(httpResponse, httpClient);
		}
	}

	/**
	 * 发送put请求；不带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doPut(String url) throws Exception {
		return doPut(url);
	}

	/**
	 * 发送put请求；带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doPut(String url, Map<String, String> params) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(url);
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT)
				.build();
		httpPut.setConfig(requestConfig);
		
		packageParam(params, httpPut);

		CloseableHttpResponse httpResponse = null;

		try {
			return getHttpClientResult(httpResponse, httpClient, httpPut);
		} finally {
			release(httpResponse, httpClient);
		}
	}

	/**
	 * 发送delete请求；不带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doDelete(String url) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		httpDelete.setConfig(requestConfig);

		CloseableHttpResponse httpResponse = null;
		try {
			return getHttpClientResult(httpResponse, httpClient, httpDelete);
		} finally {
			release(httpResponse, httpClient);
		}
	}

	/**
	 * 发送delete请求；带请求参数
	 * 
	 * @param url 请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult doDelete(Map<String, String> proxyMap,String url, Map<String, String> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, String>();
		}

		params.put("_method", "delete");
		return doPost(proxyMap,url, params);
	}
	
	/**
	 * Description: 封装请求头
	 * @param params
	 * @param httpMethod
	 */
	public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
		// 封装请求头
		if (params != null) {
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				// 设置到请求头到HttpRequestBase对象中
				httpMethod.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Description: 封装请求参数
	 * 
	 * @param params
	 * @param httpMethod
	 * @throws UnsupportedEncodingException
	 */
	public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod)
			throws UnsupportedEncodingException {
		// 封装请求参数
		if (params != null) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			// 设置到请求的http对象中
			httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
		}
	}

	/**
	 * Description: 获得响应结果
	 * 
	 * @param httpResponse
	 * @param httpClient
	 * @param httpMethod
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult getHttpClientResult(CloseableHttpResponse httpResponse,
			CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws Exception {
		// 执行请求
		httpResponse = httpClient.execute(httpMethod);

		// 获取返回结果
		if (httpResponse != null && httpResponse.getStatusLine() != null) {
			String content = "";
			if (httpResponse.getEntity() != null) {
				content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
			}
			return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * Description: 释放资源
	 * 
	 * @param httpResponse
	 * @param httpClient
	 * @throws IOException
	 */
	public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
		// 释放资源
		if (httpResponse != null) {
			httpResponse.close();
		}
		if (httpClient != null) {
			httpClient.close();
		}
	}

}