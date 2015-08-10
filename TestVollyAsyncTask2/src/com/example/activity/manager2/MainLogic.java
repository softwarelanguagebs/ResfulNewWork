/*
 * 文件名：MainLogic.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月20日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.activity.manager2;

import com.example.iface.IPostExecuteCallBack;
import com.example.manager.RequestHttpURLConnection;
import com.example.parse.JsonParse;
import com.wlfz.bean.HttpConnectionBean;
import com.wlfz.bean.UserBean;

//业务封装
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
