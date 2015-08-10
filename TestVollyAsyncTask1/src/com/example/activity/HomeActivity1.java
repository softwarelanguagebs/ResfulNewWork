package com.example.activity;

import com.example.common.L;
import com.example.iface.IPostExecuteCallBack;
import com.example.manager.ClientLogic;
import com.example.manager.MyAsyncTask1;
import com.example.testbase.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity1 extends Activity implements OnClickListener
{
	private String TAG = "HomeActivity1";
	ImageView imv_back;
	TextView tv_title;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setupView();
        initValue();
        setLinstener();
        fillData();
        
    }
    
    private void setupView()
    {
//    	imv_back = (ImageView) this.findViewById(R.id.imv_back);
//    	tv_title =(TextView) this.findViewById(R.id.tv_title);
        
    }
    
    private void initValue()
    {
//    	/**
//		 * µÇÂ¼²Ù×÷
//		 */
//    	try {
//			ClientLogic.Login(getApplicationContext(), "13967178385", "654321");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
    	
    	MyAsyncTask1 myAsyncTask1 = new MyAsyncTask1();
		try {
			myAsyncTask1.getConnectiontParam(ClientLogic.LoginConnection(getApplicationContext(), "13967178385", "654321"),new IPostExecuteCallBack() {
				
				@Override
				public void onPostExecuteReturn(String content) {
					L.i(TAG, content);
					
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myAsyncTask1.StartTask();
        
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
