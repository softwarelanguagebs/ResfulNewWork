/*
 * �ļ�����AsynchttpBean.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��19��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.AsyncHttp.bean;

import java.util.Map;

import com.loopj.android.http.RequestParams;

public class AsyncBean {
	
	int method;
	String url;
	String headerValueString;
	RequestParams params;
	
	public AsyncBean() {
		super();
		
	}
	
	
	public AsyncBean(int method, String url, String headerValueString,
			RequestParams params) {
		super();
		this.method = method;
		this.url = url;
		this.headerValueString = headerValueString;
		this.params = params;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHeaderValueString() {
		return headerValueString;
	}
	public void setHeaderValueString(String headerValueString) {
		this.headerValueString = headerValueString;
	}
	public RequestParams getParams(){
		return params;
		
	}
	
	
	public void setParams(RequestParams params) {
		this.params = params;
	}
	
	
	
	
}
