/*
 * 文件名：CreateAsyncConnectBean.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.AsyncHttp.AsyncHttpClient;

import com.example.AsyncHttp.bean.AsyncBean;
import com.example.common.Constant;
import com.example.common.Wlfz;
import com.loopj.android.http.RequestParams;

public class CreateAsyncConnectBean {
	
	 private final static String TAG = "CreateAsyncConnectBean"; 
	  private static CreateAsyncConnectBean createAsyncB = new CreateAsyncConnectBean(); 
	  
	  
	  private static AsyncBean asyncBean = new AsyncBean(); 
	  
	public static AsyncBean getLoginCB(RequestParams params ){
		
		asyncBean.setMethod(Constant.POST);
		asyncBean.setUrl(Wlfz.SERVER_URL + Wlfz.FUNCTION_LOGIN);
		asyncBean.setHeaderValueString(null);	
		asyncBean.setParams(params);
		return asyncBean;
		
	}
	
	
	
public static AsyncBean getCargosCB(RequestParams params){
		
		asyncBean.setMethod(Constant.GET);
		asyncBean.setUrl(Wlfz.SERVER_URL + Wlfz.FUNCTION_CARGOS);
		asyncBean.setHeaderValueString("qABby8vjJfmT3+/Q/sB3OlDuI8yMSBVUG9/XoqfVUnZEXLiGRx8hz1NapqfEP1Ja/e4rBOA7zNE=");	
		asyncBean.setParams(params);
		return asyncBean;
		
	}

public static AsyncBean getCarStatusCB(RequestParams params){
	
	asyncBean.setMethod(Constant.GET);
	asyncBean.setUrl("http://121.40.198.39/wlfz-server/cars/1672/status");
	asyncBean.setHeaderValueString("qABby8vjJfmT3+/Q/sB3OlDuI8yMSBVUG9/XoqfVUnZEXLiGRx8hz1NapqfEP1Ja/e4rBOA7zNE=");	
	if(params!=null){
	asyncBean.setParams(params);
	}
	return asyncBean;
	
}

public static AsyncBean setCarStatusCB(RequestParams params){
	
	asyncBean.setMethod(Constant.PUT);
	asyncBean.setUrl("http://121.40.198.39/wlfz-server/cars/1672/status");
	asyncBean.setHeaderValueString("qABby8vjJfmT3+/Q/sB3OlDuI8yMSBVUG9/XoqfVUnZEXLiGRx8hz1NapqfEP1Ja/e4rBOA7zNE=");	
	asyncBean.setParams(params);
	return asyncBean;
	
}

}
