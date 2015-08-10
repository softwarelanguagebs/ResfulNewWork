/*
 * �ļ�����MyApplication.java
 * ��Ȩ��Copyright by www.huawei.com
 * ������
 * �޸��ˣ�admin
 * �޸�ʱ�䣺2015��1��15��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.example.application;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        
        
     // /////��һ�� �����ҳ�� ��Ĭ���� ���� ���� ����/////////////
     // ͨ����ʽ��ͼ����Service //////////////////////////////////////////
     		Intent it = new Intent("com.example.activity.manager2.MainService");
     		this.startService(it);
        
    }
}
