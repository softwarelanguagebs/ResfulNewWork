/*
 * 文件名：VollyBean.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.volly.bean;

import java.util.Map;

public class VollyBean {
	
	int method;
	String url;
    Map<String, String> headers;
    Map<String, String> params;
	public VollyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VollyBean(int method, String url, Map<String, String> headers,
			Map<String, String> params) {
		super();
		this.method = method;
		this.url = url;
		this.headers = headers;
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
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
    

}
