/*
 * 文件名：AsyncRequestParam.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.AsyncHttp.AsyncHttpClient;

import com.loopj.android.http.RequestParams;

public class AsyncRequestParam {
	
	public  static RequestParams setLoginParam(String name,String pwd,String client){
		RequestParams params = new RequestParams();  
		params.put("login_name", name);
		params.put("password", pwd);
		params.put("client", client);
		return params;
	}
	
	public  static RequestParams setGetCargosParam(String orderby,String page_no,String page_size,String status){
		RequestParams params = new RequestParams();  
		params.put("orderby", orderby);
		params.put("page_no", page_no);
		params.put("page_size", page_size);
		params.put("status", status);
		return params;
	}
	
	public  static RequestParams setGetCarStutusParam(){
		
		return null;
	}
	

	
	public  static RequestParams setSetCarStutusParam(String status){
		RequestParams params = new RequestParams();  
		params.put("status", status);

		return params;
	}
	
}
