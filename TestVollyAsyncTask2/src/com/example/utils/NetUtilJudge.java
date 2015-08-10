/*
 * 文件名：NetUtilJudge.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月15日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.utils;

import com.example.application.MyApplication;
import com.example.common.T;



public class NetUtilJudge {

	public static boolean netIsAvailable() {

		if (!NetUtils.isConnected(MyApplication.getInstance())) {
			T.showLong(MyApplication.getInstance(), "当前网络已断开");
			return false;

		}
		return true;
	}
	

}
