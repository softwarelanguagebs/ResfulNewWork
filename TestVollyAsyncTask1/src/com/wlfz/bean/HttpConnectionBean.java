/*
 * �ļ�����ConnectionBean.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.wlfz.bean;

import java.util.Map;

public class HttpConnectionBean {

	int method;
	String url;
	Map<String, String> headers;
	Map<String, String> params;
	
	
	
	
	public HttpConnectionBean(int method, String url, Map<String, String> headers,
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
