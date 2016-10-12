package com.example.administrator.bbb.tools.okh;

/**
 * Created by yuxiaomin on 16/8/30.
 */
public interface OnHttpCallBack<T> {

    void onSuccess(T response);
    void onError(Throwable e);
}
