package com.example.AsyncHttp.avtivity;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;

import com.example.AsyncHttp.AsyncHttpClient.AsyncHttpUtilClient;
import com.example.AsyncHttp.AsyncHttpClient.AsyncRequestParam;
import com.example.AsyncHttp.AsyncHttpClient.CreateAsyncConnectBean;
import com.example.common.L;
import com.example.testbase.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener
{
	private String TAG = "HomeActivity";
	ImageView imv_back;
	TextView tv_title;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
   setupView();
// initValue();
        setLinstener();
        fillData();
        
    }
    
    private void setupView()
    {
    	
    	
    	//==============Login==========================
    	
    	RequestParams loginParams = AsyncRequestParam.setLoginParam("139671783b5", "654321", "car");
    	AsyncHttpUtilClient.request(CreateAsyncConnectBean.getLoginCB(loginParams), new AsyncHttpResponseHandler(){

    		@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
					Throwable arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

             String s = new String(responseBody);
             L.i(TAG, s);
				
			}
    		
    	});
    	
    	//==============getCargos==========================
    
    	
    	RequestParams getCargosParams = AsyncRequestParam.setGetCargosParam("time", "1", "2", "2");
    	AsyncHttpUtilClient.request(CreateAsyncConnectBean.getCargosCB(getCargosParams), new AsyncHttpResponseHandler(){

    		@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
					Throwable arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

             String s = new String(responseBody);
             L.i(TAG, s);
				
			}
    		
    	});
    	
    	
//==============setCarStuStus==========================
    
    	
    	RequestParams setCargosParams = AsyncRequestParam.setSetCarStutusParam("2");
    	AsyncHttpUtilClient.request(CreateAsyncConnectBean.setCarStatusCB(setCargosParams), new AsyncHttpResponseHandler(){

    		@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
					Throwable arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

             String s = new String(responseBody);
             L.i(TAG+TAG, s);
				
			}
    		
    	});
    	
    	
//==============getCarStuStus==========================
    
    	
    	
    	AsyncHttpUtilClient.request(CreateAsyncConnectBean.getCarStatusCB(null), new AsyncHttpResponseHandler(){

    		@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
					Throwable arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

             String s = new String(responseBody);
             L.i(TAG, s);
				
			}
    		
    	});
    	
    	
    	
    }
    
    private void initValue()
    {
        //=======================Login============================
    	   AsyncHttpClient client = new AsyncHttpClient(); // 创建异步请求的客户端对象  
    		String url = "http://121.40.198.39/wlfz-server/users/login";// 定义请求的地址  
    		// 创建请求参数的封装的对象  
    		RequestParams params = new RequestParams();  
    		params.put("login_name", "13967178385");
    		params.put("password", "654321");
    		params.put("client", "car");
    		
    		client.post(url, params, new AsyncHttpResponseHandler(){

				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] arg2,
						Throwable arg3) {
					// TODO Auto-generated method stub
					
				}

				 /** 
	             * 成功处理的方法 
	             * statusCode:响应的状态码; headers:相应的头信息 比如 响应的时间，响应的服务器 ; 
	             * responseBody:响应内容的字节 
	             */  
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                 String s = new String(responseBody);
                 L.i(TAG, s);
					
				}
    			
    		});
    	
        
    		
    		// ===========get cargos ===========================//
    		
//    		Map<String, String> headers1 = new HashMap<String, String>();
//    		headers1.put("Content-Type", "application/x-www-form-urldecoded");
//    		headers1.put("token",
//    				"qABby8vjJfmT3+/Q/sB3OulhhTshpbZS8eMlpd9XVMAZsOxpuRVXDW4CwKPRVcmnRIuzUOhZEGA=");

    		 String url1 = "http://121.40.198.39/wlfz-server/cargos";
    		 RequestParams params1 = new RequestParams();  
    		 params1.put("page_size", "1");
    		
    		  AsyncHttpClient client1 = new AsyncHttpClient();  
    	
    		  client1.addHeader("token",
    					"qABby8vjJfmT3+/Q/sB3OlDuI8yMSBVUG9/XoqfVUnZEXLiGRx8hz1NapqfEP1Ja/e4rBOA7zNE=");
    		   
    		  client1.get(url1, params1,new AsyncHttpResponseHandler() {  
    	            @Override  
    	            public void onSuccess(int statusCode, Header[] headers,  
    	                    byte[] responseBody) {  
    	            	String s = new String(responseBody);
    	                 L.i(TAG, s);
    	              
    	            }  
    	  
    	            @Override  
    	            public void onFailure(int statusCode, Header[] headers,  
    	                    byte[] responseBody, Throwable error) {  
    	              
    	                error.printStackTrace();  
    	            }  
    	        });  
    		  
    		  
    		  
    		  
    		  String url2 ="http://121.40.198.39/wlfz-server/cars/1672/status"; 
    		  RequestParams params2 = new RequestParams();  
      		  params2.put("status","2");
      		 AsyncHttpClient client2 = new AsyncHttpClient(); 
      		client2.addHeader("token",
					"qABby8vjJfmT3+/Q/sB3OlDuI8yMSBVUG9/XoqfVUnZEXLiGRx8hz1NapqfEP1Ja/e4rBOA7zNE=");
      		client2.put(url2, params2, new AsyncHttpResponseHandler(){

      			 @Override  
 	            public void onSuccess(int statusCode, Header[] headers,  
 	                    byte[] responseBody) {  
 	            	String s = new String(responseBody);
 	                 L.i(TAG, s);
 	              
 	            }  
 	  
 	            @Override  
 	            public void onFailure(int statusCode, Header[] headers,  
 	                    byte[] responseBody, Throwable error) {  
 	              
 	                error.printStackTrace();  
 	            }  
      			
      		});
    }
    
    

	private void setLinstener()
    {
		
        
    }
    
    private void fillData()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void onClick(View v)
    {
        
        switch (v.getId())
        {
        
//        case R.id.imv_back:
//
//			 this.finish();
//             break;
                
        default:
        	break;
        }
        
    }
    
}
