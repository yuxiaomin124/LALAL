package com.example.administrator.bbb.my_app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016-9-30.
 */
public class MyApp extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
