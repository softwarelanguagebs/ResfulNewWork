/*
 * �ļ�����NetUtilJudge.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��15��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.utils;

import com.example.application.MyApplication;
import com.example.common.T;



public class NetUtilJudge {

	public static boolean netIsAvailable() {

		if (!NetUtils.isConnected(MyApplication.getInstance())) {
			T.showLong(MyApplication.getInstance(), "��ǰ�����ѶϿ�");
			return false;

		}
		return true;
	}
	

}
