/*
 * 文件名：ClientLogic.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.manager;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.example.common.L;
import com.example.common.Wlfz;
import com.example.iface.IPostExecuteCallBack;
import com.example.net.HttpRequestUtil;
import com.wlfz.bean.HttpConnectionBean;

import android.content.Context;

public class ClientLogic {

	private static String TAG = "ClientLogic";

	 
	/**
	 * 用户登录逻辑处理
	 * @throws Exception 
	 */
	
	public static HttpConnectionBean LoginConnection(Context context,String name, String pwd) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("login_name", name);
		params.put("password", "654321");
		params.put("client", pwd);
		String url = Wlfz.SERVER_URL + Wlfz.FUNCTION_LOGIN;
		
	 
		 HttpConnectionBean connectionBean = new HttpConnectionBean(2, Wlfz.SERVER_URL
	                + Wlfz.FUNCTION_LOGIN,
	                null,
	                params);
		 
		 return connectionBean;
		 
	/*	 
		MyAsyncTask1 myAsyncTask1 = new MyAsyncTask1();
		myAsyncTask1.getConnectiontParam(connectionBean,new IPostExecuteCallBack() {
			
			@Override
			public void onPostExecuteReturn(String content) {
				L.i(TAG, content);
				
			}
		});
		
		myAsyncTask1.StartTask();
		
		*/
		
	}
}
