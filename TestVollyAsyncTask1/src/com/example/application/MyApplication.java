/*
 * 文件名：MyApplication.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：admin
 * 修改时间：2015年1月15日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.example.application;

import android.app.Application;

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
    }
}
