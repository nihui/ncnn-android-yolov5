package com.hhu.smartdetection;

import android.app.Application;

import com.xuexiang.xui.XUI;

public class MyAPP extends Application {
    //onCreate--->程序创建的时候执行
    @Override
    public void onCreate() {
        super.onCreate();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志
    }
}
