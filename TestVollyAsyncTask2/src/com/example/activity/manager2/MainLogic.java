/*
 * �ļ�����MainLogic.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��20��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.activity.manager2;

import com.example.iface.IPostExecuteCallBack;
import com.example.manager.RequestHttpURLConnection;
import com.example.parse.JsonParse;
import com.wlfz.bean.HttpConnectionBean;
import com.wlfz.bean.UserBean;

//ҵ���װ
public class MainLogic {

	protected static UserBean doInBackground(HttpConnectionBean myconnectionBean) {

		try {
			String resultString = RequestHttpURLConnection
					.getConnection(myconnectionBean.getMethod(),
							myconnectionBean.getUrl(),
							myconnectionBean.getHeaders(),
							myconnectionBean.getParams());

			return JsonParse.parseJsonLogin(resultString);

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}
