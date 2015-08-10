/*
 * 文件名：CreateVollyConnetBean.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.volly.manager;

import java.util.HashMap;
import java.util.Map;

import com.example.AsyncHttp.AsyncHttpClient.CreateAsyncConnectBean;
import com.example.common.Constant;
import com.example.common.Wlfz;
import com.example.volly.bean.VollyBean;

public class CreateVollyConnetBean {

	 private final static String TAG = "CreateVollyConnetBean"; 
	  private static CreateVollyConnetBean createVollyCB = new CreateVollyConnetBean(); 
	  
	  public static VollyBean getLoginCB(Map<String, String> params){
		  
		  VollyBean vollyBean = new VollyBean();
		  vollyBean.setMethod(Constant.POST);
		  vollyBean.setUrl(Wlfz.SERVER_URL + Wlfz.FUNCTION_LOGIN);
//		  Map<String, String> map = new HashMap<String, String>();  
//          map.put("Content-Type", "application/x-www-form-urldecoded"); 
//          map.put("token", "qABby8vjJfmT3+/Q/sB3OuIjIWMNOzzjQXzGVv33abDSo4iqrUmkiwZFkHMkQkmCjFK0pZV+A7A="); 
//		  vollyBean.setHeaders(header);
		  vollyBean.setParams(params);
		return vollyBean;
		  
	  }
}
