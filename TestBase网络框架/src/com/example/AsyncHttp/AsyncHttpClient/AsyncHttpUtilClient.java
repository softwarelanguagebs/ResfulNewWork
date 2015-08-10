/*
 * �ļ�����AsyncHttpUtilClient.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��19��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
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
 * �ٷ�װandroid-async-http
 * @author wen
 * @version 2015��1��19��
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
