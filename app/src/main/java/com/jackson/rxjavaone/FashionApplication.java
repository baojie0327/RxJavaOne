package com.jackson.rxjavaone;

import android.app.Application;
import android.content.Context;


/*
* FashionApplication  2016-11-10
* Copyright (c) 2016 HYB Co.Ltd. All right reserved.
*/
/*
* 整个项目的application控制
* @author Borje
* @version 1.0.0
* since 2016-11-10
*/
public class FashionApplication extends Application {
    public static String cache_root_path = "";
    private static FashionApplication instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static FashionApplication getInstance() {
        return instance;
    }
}