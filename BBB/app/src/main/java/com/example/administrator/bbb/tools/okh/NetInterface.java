package com.example.administrator.bbb.tools.okh;

/**
 * Created by yuxiaomin on 16/8/30.
 * <p/>
 *
 *  2
 */
public interface NetInterface {
    void startRequest(String url, OnHttpCallBack<String> callBacck);

    <T> void startRequest(String url, Class<T> tClass, OnHttpCallBack<T> callBacck);
}
