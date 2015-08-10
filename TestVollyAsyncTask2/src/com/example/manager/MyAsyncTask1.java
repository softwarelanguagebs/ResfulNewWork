/*
 * 文件名：myAsyncTask.java
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.manager;



import java.net.HttpURLConnection;

import com.example.iface.IPostExecuteCallBack;
import com.wlfz.bean.HttpConnectionBean;

import android.os.AsyncTask;

public class MyAsyncTask1 extends AsyncTask<Void, Integer, String> {

	
	public MyAsyncTask1(){
		
	}
	
	 HttpConnectionBean connectionBean;
	 IPostExecuteCallBack iPostExecuteCallBack;
 
	 public  void request(HttpConnectionBean myconnectionBean,IPostExecuteCallBack myiPostExecuteCallBack ){
		connectionBean = myconnectionBean;
		iPostExecuteCallBack = myiPostExecuteCallBack;
		
	}

	@Override
	protected String doInBackground(Void... params) {
		
	try {
		return 	RequestHttpURLConnection.getConnection(connectionBean.getMethod(), connectionBean.getUrl(), connectionBean.getHeaders(), connectionBean.getParams());
	} catch (Exception e) {
		e.printStackTrace();
		return null;
		
	}

	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		iPostExecuteCallBack.onPostExecuteReturn(result);
		
	}
	
	
	public  void StartTask(){
		this.execute();
	}

	

	
	



	
	
	
	
}
