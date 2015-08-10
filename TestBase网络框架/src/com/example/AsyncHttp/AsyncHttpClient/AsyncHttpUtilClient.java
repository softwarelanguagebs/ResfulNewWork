/*
 * 文件名：AsyncHttpUtilClient.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.AsyncHttp.AsyncHttpClient;

import com.example.AsyncHttp.bean.AsyncBean;
import com.example.common.Constant;
import com.example.utils.NetUtilJudge;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.integer;


/**
 * 再封装android-async-http
 * @author wen
 * @version 2015年1月19日
 * @see AsyncHttpUtilClient
 * @since
 */
public class AsyncHttpUtilClient {
	private final static String TAG = "AsyncHttpUtilClient"; 
	 private static AsyncHttpClient client = new AsyncHttpClient();  
	 
	 public static void doGet(int method,String url, String headerValue,RequestParams params, AsyncHttpResponseHandler responseHandler) {
		 if(null!=headerValue){
		 client.addHeader("token",
				 headerValue);
		 }
		 
		 client.get(url, params, responseHandler);
	  }

	  public static void doPost(int method,String url, String headerValue,RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  if(null!=headerValue){
				 client.addHeader("token",
						 headerValue);
				 }
				 
				 client.post(url, params, responseHandler);
	  }

	  public static void doPut(int method,String url, String headerValue,RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  if(null!=headerValue){
				 client.addHeader("token",
						 headerValue);
				 }
				 
				 client.put(url, params, responseHandler);
	  }
	
	  public static void request(AsyncBean asyncBean, AsyncHttpResponseHandler responseHandler){
		  if(NetUtilJudge.netIsAvailable()){		  
				switch (asyncBean.getMethod()) {
				case Constant.GET:
					doGet(asyncBean.getMethod(),asyncBean.getUrl(),asyncBean.getHeaderValueString(),asyncBean.getParams(), responseHandler);
					break;
				case Constant.POST:
					doPost(asyncBean.getMethod(),asyncBean.getUrl(),asyncBean.getHeaderValueString(),asyncBean.getParams(), responseHandler);
					break;
				case Constant.PUT:
					doPut(asyncBean.getMethod(),asyncBean.getUrl(),asyncBean.getHeaderValueString(),asyncBean.getParams(), responseHandler);
					break;
				case Constant.DELETE:
					
					break;
				}
				}
	  }
}
