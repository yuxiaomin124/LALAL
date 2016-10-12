package com.example.administrator.bbb.my.shopping_car.after;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dllo on 16/5/15.
 */
public class Utils {

    public static int getScreenWidth(Context context){
        //获取屏幕宽度
        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        //DisplayMetrics屏幕的一些参数都放在这里面,屏幕的一些参数通过该类获取
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);

        //返回屏幕宽度
        return metrics.widthPixels;


    }
}
