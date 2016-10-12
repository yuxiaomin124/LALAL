package com.example.administrator.vfstore.imageutils;

import android.widget.ImageView;

/**
 * Created by lenovo on 2016/10/9.
 */
public class ImageLoaderUtil {

    public static void getInternetImage(String url, ImageView imageView) {
        Instance.imageLoader.displayImage(url, imageView,
                Instance.optionsdefault);
    }


}
