package com.example.administrator.vfstore.imageutils;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * Created by lenovo on 2016/10/9.
 */
public class ImageApplication extends Application {
    private static ImageApplication instance = null;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        try {
            instance = this;
            /**
             * 初始化ImageLoader
             */
            initImageLoader(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("static-access")
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                // 设置当前线程的优先级
                .threadPoolSize(3)
                // 设置线程池大小
                .denyCacheImageMultipleSizesInMemory()
                // 硬盘缓存50MB
                .discCacheSize(50 * 1024 * 1024)
                // 50 MiB
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .imageDownloader(
                        new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout(5s),readTimeout(30s)超时时间
                .build();
        // Initialize ImageLoader with configuration.
        Instance.imageLoader.getInstance().init(config);
    }

    public synchronized static ImageApplication getInstance() {
        if (instance == null) {
            instance = new ImageApplication();
        }
        return instance;
    }

}
