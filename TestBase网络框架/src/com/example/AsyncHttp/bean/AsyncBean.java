/*
 * 文件名：AsynchttpBean.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
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
