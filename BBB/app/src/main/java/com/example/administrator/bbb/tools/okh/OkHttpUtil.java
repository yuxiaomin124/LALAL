package com.example.administrator.bbb.tools.okh;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yuxiaomin on 16/8/30.
 * <p/>
 * 实现NetInterface接口
 *
 * 3.
 */
public class OkHttpUtil implements NetInterface {
    private OkHttpClient mOkHttpClient;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private Gson mGson;

    public OkHttpUtil() {

        File path = Environment.getExternalStorageDirectory();
        mOkHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(path, 10 * 1024 * 1024)).connectTimeout(5, TimeUnit.SECONDS).build();
        mGson = new Gson();

    }

    @Override
    public void startRequest(String url, final OnHttpCallBack<String> callBacck) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacck.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacck.onSuccess(result);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final OnHttpCallBack<T> callBacck) {

        final Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacck.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str, tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacck.onSuccess(result);
                    }
                });
            }
        });
    }
}
