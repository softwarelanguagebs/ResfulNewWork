package com.example.parse;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.common.L;

import com.wlfz.bean.Cargos;
import com.wlfz.bean.UserBean;


public class JsonParse
{
	
	private static String TAG = "JsonParse";
    /**
     * 解析Login返回值
     * 
     * @return
     * @throws JSONException 
     * @throws Exception
     */
    public static UserBean parseJsonLogin(String json) throws JSONException
            
    {
        
    	
    	
       L.i(TAG,json);
        UserBean userinfo = new UserBean();
       
        String messageString = null;
        JSONObject jsonObject = new JSONObject(json);
       
        boolean flag = jsonObject.getBoolean("success");
        
        if (flag)
        {        
            JSONObject contentObject = jsonObject.getJSONObject("result"); //获取对象中的对象             
               userinfo.setAddress(contentObject.optString("address"));
            
            userinfo.setClient(contentObject.optString("client"));
            userinfo.setCode(contentObject.optString("code"));
            userinfo.setCompany(contentObject.optString("company"));
            userinfo.setContact_name(contentObject.optString("contact_name"));
            userinfo.setContact_number(contentObject.optString("contact_number"));
            userinfo.setIs_admin(contentObject.optInt("is_admin"));
            userinfo.setToken(contentObject.optString("token"));
            userinfo.setUser_id(contentObject.optInt("user_id"));
            userinfo.setUser_name(contentObject.optString("user_name"));
            //settings 设置车辆
            JSONObject settingsJson = contentObject.getJSONObject("settings");
            userinfo.setAbout_us(settingsJson.optString("about_us"));
            userinfo.setHelp_msg(settingsJson.optString("help_msg"));
            
            userinfo.setRequest_interval(settingsJson.optString("request_interval"));
            userinfo.setLocate_interval(settingsJson.optString("locate_interval"));
            userinfo.setMarker_size(settingsJson.optString("marker_size"));
            //获取车辆状态
            JSONArray cars = contentObject.optJSONArray("cars");
            for (int i = 0; i < cars.length(); i++)
            {
                JSONObject careFirst = cars.getJSONObject(0);
                userinfo.setId(careFirst.optInt("id"));
                userinfo.setLocate_number(careFirst.optString("plate_number"));
                userinfo.setPlate_numbe(careFirst.optString("locate_number"));
            }
            
         
            return userinfo;
            
        }
        
        else
        {
            
                        JSONObject resultJSON = jsonObject.getJSONObject("error");
                        messageString = resultJSON.getString("message");
                        L.i("message-----------", messageString);
                         L.i("parseJSONLogin-----------", "解析失败");
            return null;
        }
    }
    
    
  
    
    /**
     * 解析CargoList返回值
     * 
     * @return
     * @throws Exception
     */
    public static List<Cargos> parseJsonCargos(String json) throws Exception
    {
    	 L.i(TAG,json);
        List<Cargos> list = new ArrayList<Cargos>();
       
        String messageString = null;
        JSONObject jsonObject = new JSONObject(json);
        boolean flag = jsonObject.getBoolean("success");
        
        if (flag)
        {
            int total = jsonObject.getInt("total");
            
            // JSONObject contentObject = jsonObject.getJSONObject("result"); //获取对象中的对象 
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject item = jsonArray.getJSONObject(i); // 得到每个对象 
                Cargos cargoinfo = new Cargos();
                
                cargoinfo.setTotal(total);
                
                cargoinfo.setCarriage(item.optString("carriage"));
                cargoinfo.setCompany(item.optString("company"));
                cargoinfo.setContact_name(item.optString("contact_name"));
                cargoinfo.setContact_number(item.optString("contact_number"));
                cargoinfo.setDestination(item.optString("destination"));
                
                cargoinfo.setDestination_code(item.optString("destination_code"));
                cargoinfo.setDistance(item.optString("distance"));
                cargoinfo.setExpired_time(item.optString("expired_time"));
                
                cargoinfo.setId(item.optInt("id"));
                
                cargoinfo.setTrade_status(item.optInt("trade_status"));
                cargoinfo.setLatitude(item.optDouble("latitude"));
                cargoinfo.setLongitude(item.optDouble("longitude"));
                
                cargoinfo.setMemo(item.optString("memo"));
                cargoinfo.setOrigin(item.optString("origin"));
                cargoinfo.setOrigin_code(item.optString("origin_code"));
                cargoinfo.setPublish_time(item.optString("publish_time"));
                cargoinfo.setShort_title(item.optString("short_title"));
                cargoinfo.setType(item.optString("type"));
                cargoinfo.setUser_code(item.optString("user_code"));
                
                cargoinfo.setUser_id(item.optInt("user_id"));
                cargoinfo.setVolume(item.optString("volume"));
                cargoinfo.setWeight(item.optString("weight"));
                
                list.add(cargoinfo);
                
            }
            
            return list;
            
        }
        
        else
        {
            
                  
            JSONObject resultJSON = jsonObject.getJSONObject("error");
            messageString = resultJSON.getString("message");
            L.i("parseJSONCargos-----------", messageString);
            L.i("parseJSONCargos-----------", "解析失败");
            return null;
        }
    }
    
    
   
    /**
     * 解析CarState
     * 
     * @return
     * @throws Exception
     */
    public static String parseJsonCarState( String json) throws Exception
    {   
    	
    	 L.i(TAG,json);
       
        String messageString = null;
        JSONObject jsonObject = new JSONObject(json);
        boolean flag = jsonObject.getBoolean("success");        
        if (flag)
        {
            JSONObject contentObject = jsonObject.getJSONObject("result"); //获取对象中的对象             
          return contentObject.optString("desc");
         }       
        else
        {
            
            JSONObject resultJSON = jsonObject.getJSONObject("error");
            messageString = resultJSON.getString("message");
            L.i(TAG,"parseJSONCarState--------messageString---"+messageString );
           
            return null;
        }
    }
    
    
}
