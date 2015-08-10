/*
 * 文件名：RequestConnection.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.manager;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;


import com.example.common.L;

import com.example.net.HttpRequestUtil;
import com.example.utils.NetUtilJudge;



public class RequestHttpURLConnection {
	
	private static String TAG = "RequestHttpURLConnection";
	
	
	
	public static String  getConnection(int method, String url,
			 Map<String, String> headers, Map<String, String> params) throws Exception{
		

		if(NetUtilJudge.netIsAvailable()){
			
		switch (method) {

		case 2:
			
			 HttpURLConnection connPost =	(HttpURLConnection) HttpRequestUtil.sendPostRequest(url,
	                params,
	                headers);
			 
			 if (null == connPost)
		        {
		        	L.i(TAG, "连接网络失败");
		            return null;
		        }
			 else {
				 InputStream inStream = connPost.getInputStream();
				  byte[] data =read(inStream);
			      String json = new String(data);
			      return json;
			}
			
			
		case 1:
			 HttpURLConnection connGet = (HttpURLConnection) HttpRequestUtil.sendGetRequest(url,
	                params,
	                headers);
			 if (null == connGet)
		        {
		        	L.i(TAG, "连接网络失败");
		            return null;
		        }
			 else {
				 InputStream inStream = connGet.getInputStream();
				  byte[] data =read(inStream);
			      String json = new String(data);
			      return json;
			 }
		default:
			break;
		}
		}
		return null;
	
		
	}
	
	
	
	  /**
     * 读取输入流数据
     * @param inStream
     * @return
     */
    public static byte[] read(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

}
