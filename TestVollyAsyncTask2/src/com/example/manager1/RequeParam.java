/*
 * �ļ�����RequeParam.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��20��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.manager1;

import java.util.HashMap;
import java.util.Map;

public class RequeParam {

	public static Map<String, String> setLoginParam(String name, String pwd,
			String client) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("login_name", name);
		params.put("password", pwd);
		params.put("client", client);
		return params;
	}
	
	public static Map<String, String> setGetCargosParam(String orderby,String page_no,String page_size,String status){
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderby", orderby);
		params.put("page_no", page_no);
		params.put("page_size", page_size);
		params.put("status", status);
		return params;
	}
	
	
	public static Map<String, String> setGetCarStutusParam(){
		
		return null;
	}
	
	public static Map<String, String> setSetCarStutusParam(String status){
		Map<String, String> params = new HashMap<String, String>();
		params.put("status", status);
		return params;
	}
}
