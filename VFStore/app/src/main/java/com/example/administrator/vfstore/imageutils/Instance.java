package com.example.administrator.vfstore.imageutils;

import com.example.administrator.vfstore.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by lenovo on 2016/10/9.
 */
public class Instance {

    public static ImageLoader imageLoader = ImageLoader.getInstance();
    public static DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true).cacheOnDisc(true).build();
    public static DisplayImageOptions optionsdefault = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true)
            .cacheOnDisc(true).build();
    public static DisplayImageOptions chatoptions = new DisplayImageOptions.Builder()
           .showImageOnLoading(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true)
            .cacheOnDisc(true).build();


}
