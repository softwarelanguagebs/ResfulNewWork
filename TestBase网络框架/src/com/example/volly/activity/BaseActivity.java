package com.example.volly.activity;

import java.util.Map;








import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.common.L;
import com.example.testbase.R;
import com.example.volly.manager.CreateVollyConnetBean;
import com.example.volly.manager.VollyRequestManager;
import com.example.volly.manager.VollyRequestParam;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends Activity implements OnClickListener
{
	private String TAG = "CargoEvaluationActivity";
	ImageView imv_back;
	TextView tv_title;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setupView();
        try {
			initValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setLinstener();
        fillData();
        
    }
    
    private void setupView()
    {
//    	imv_back = (ImageView) this.findViewById(R.id.imv_back);
//    	tv_title =(TextView) this.findViewById(R.id.tv_title);
        
    }
    
    private void initValue() throws Exception
    {
      
    	 Map<String, String> loginParaMap = VollyRequestParam.setLoginParam("13967178385", "654321", "car");
    	 VollyRequestManager.getInstance(getApplicationContext()).request(CreateVollyConnetBean.getLoginCB(loginParaMap), new Response.Listener<String>() {
 			@Override
 			public void onResponse(String response) {
 				L.i(TAG, "SU"+response);
 			}
 		}, new Response.ErrorListener() {
 			
 			@Override
 			public void onErrorResponse(VolleyError error) {
 				L.i(TAG, "FAIl"+error.getMessage());
 				Log.e(TAG, "FAIl"+error.getMessage(), error);
 				
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
