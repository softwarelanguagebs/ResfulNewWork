/*
 * �ļ�����ClientLogic.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
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
	 * �û���¼�߼�����
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
