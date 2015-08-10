package com.example.volly.manager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.common.Constant;
import com.example.common.L;
import com.example.utils.NetUtilJudge;
import com.example.volly.bean.VollyBean;

import android.R.integer;
import android.content.Context;
import android.util.Log;



/**
 * VollyRequestManager管理类
 * 
 * @author wen
 * @version 2015年1月14日
 * @see VollyRequestManager
 * @since
 */
public class VollyRequestManager {


	
	private String TAG = "VollyRequestManager";
	private volatile static VollyRequestManager instance = null;
	private RequestQueue mRequestQueue = null;

	private VollyRequestManager(Context context) {
		initRequestQueue(context);
	}

	/**
	 * 初始化mRequestQueue
	 */
	public void initRequestQueue(Context context) {

		this.mRequestQueue = Volley.newRequestQueue(context);

	}

	public static VollyRequestManager getInstance(Context context) {
		if (null == instance) {
			synchronized (VollyRequestManager.class) {
				if (null == instance) {
					instance = new VollyRequestManager(context);
				}
			}
		}
		return instance;
	}

	public RequestQueue getRequestQueue() {
		return this.mRequestQueue;
	}

	/**
	 * doGet()
	 */
	private void doGet( String url,
			 final Map<String, String> headers, final Map<String, String> params,
			Response.Listener<String> successListener,Response.ErrorListener errorListener ) throws Exception {

		String requestUrl = null;
		// 如果是GET请求，则请求参数在URL中
		if (params != null && !params.isEmpty()) {
			String param = urlEncode(params);
			requestUrl = url + "?" + param;
		} else {
			requestUrl = url;
		}
		L.i(TAG, requestUrl);
		
		StringRequest stringRequest = new StringRequest(Method.GET, url, successListener, errorListener){
			// 设置头信息
						@Override
						public Map<String, String> getHeaders() throws AuthFailureError {

							if (headers != null && !headers.isEmpty()) {
								return headers;
							} else {
								return Collections.emptyMap();
							}
						}
						@Override
			    		protected Map<String, String> getParams() throws AuthFailureError {
			    			return params;
			    		}		
			
		};

		mRequestQueue.add(stringRequest);

	}

	private void doPost(String url,
			final Map<String, String> headers, final Map<String, String> params,
			Response.Listener<String> successListener,Response.ErrorListener errorListener ) {

		L.i(TAG+"doPost", url);
		
//		for (Map.Entry<String, String> entry :headers.entrySet()) {
//			   System.out.println("hkey= " + entry.getKey() + " and hvalue= " + entry.getValue());
//			  }
//		
		
//		
//		for (Map.Entry<String, String> entry :params.entrySet()) {
//			   System.out.println("pkey= " + entry.getKey() + " and pvalue= " + entry.getValue());
//			  }
		
		StringRequest stringRequest = new StringRequest(Method.POST, url,successListener,errorListener){
			
			@Override
    		protected Map<String, String> getParams() throws AuthFailureError {
    			return params;
    		}
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {

				if (headers != null && !headers.isEmpty()) {
					return headers;
				} else {
					return Collections.emptyMap();
				}

			}

			
		};
	
		mRequestQueue.add(stringRequest);

	}

	private void doPut(String url,
			final Map<String, String> headers, final Map<String, String> params,
			Response.Listener<String> successListener,Response.ErrorListener errorListener) throws Exception {

		String requestUrl = null;
		// 如果是GET请求，则请求参数在URL中
		if (params != null && !params.isEmpty()) {
			String param = urlEncode(params);
			requestUrl = url + "?" + param;
		} else {
			requestUrl = url;
		}
		L.i(TAG, requestUrl);
		StringRequest stringRequest = new StringRequest(Method.PUT, url, successListener, errorListener){
			// 设置头信息
						@Override
						public Map<String, String> getHeaders() throws AuthFailureError {

							if (headers != null && !headers.isEmpty()) {
								return headers;
							} else {
								return Collections.emptyMap();
							}
						}
						
						@Override
			    		protected Map<String, String> getParams() throws AuthFailureError {
			    			return params;
			    		}
			
		};
	
		mRequestQueue.add(stringRequest);

	}

	private void doDelete() {

	}

	public void request(VollyBean vollyBean,Response.Listener<String> successListener,Response.ErrorListener errorListener)
			throws Exception {

		if(NetUtilJudge.netIsAvailable()){
			
		
		switch (vollyBean.getMethod()) {

		case Constant.GET:
			doGet(vollyBean.getUrl(),vollyBean.getHeaders(),vollyBean.getParams(),successListener,errorListener);
			break;

		case Constant.POST:
			
			
			
			doPost(vollyBean.getUrl(),vollyBean.getHeaders(),vollyBean.getParams(),successListener,errorListener);

			break;

		case Constant.PUT:
			doPut(vollyBean.getUrl(),vollyBean.getHeaders(),vollyBean.getParams(),successListener,errorListener);

			break;

		case Constant.DELETE:

			doDelete();
			break;

		default:
			break;
		}
		}

	}

	private String urlEncode(Map<String, String> params)
			throws UnsupportedEncodingException {
		Iterator<String> iter = params.keySet().iterator();
		int i = 0;
		StringBuffer sb = new StringBuffer();

		while (iter.hasNext()) {
			String key = iter.next();
			String value = params.get(key);

			if (i != 0) {
				sb.append("&");
			}
			sb.append(key);
			sb.append("=");
			sb.append(URLEncoder.encode(value, "utf-8").toString());

			i++;
		}
		return sb.toString();
	}
}
