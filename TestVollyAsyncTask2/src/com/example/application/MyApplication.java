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
        
        
     // /////第一个 进入的页面 ，默认呢 启动 服务 ……/////////////
     // 通过隐式意图启动Service //////////////////////////////////////////
     		Intent it = new Intent("com.example.activity.manager2.MainService");
     		this.startService(it);
        
    }
}
