/*
 * �ļ�����CreateHttpURLConnectionBean.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��20��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.manager1;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.example.common.Constant;
import com.example.common.Wlfz;
import com.wlfz.bean.HttpConnectionBean;

public class CreateHttpURLConnectionBean {

public static HttpConnectionBean getLoginCB(Map<String, String> params) throws Exception{
	 
		 HttpConnectionBean connectionBean = new HttpConnectionBean(Constant.POST, Wlfz.SERVER_URL
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
