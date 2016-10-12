package com.example.administrator.bbb.tools.okh;

/**
 * Created by yuxiaomin on 16/8/30.
 *
 * 4.
 */
public class NetTool implements NetInterface {
    private static NetTool ourInstance;
    private NetInterface mNetInterface;

    public static NetTool getInstance() {
        if (ourInstance == null) {
            synchronized (NetTool.class) {
                if (ourInstance == null) {
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool() {
        mNetInterface = new OkHttpUtil();
    }

    @Override
    public void startRequest(String url, OnHttpCallBack<String> callBacck) {

    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, OnHttpCallBack<T> callBack) {

        mNetInterface.startRequest(url, tClass, callBack);
    }
}
