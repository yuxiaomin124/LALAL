package com.example.administrator.vfstore.first;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.vfstore.Constant;
import com.example.administrator.vfstore.R;
import com.example.administrator.vfstore.base.BaseFragment;
import com.example.administrator.vfstore.entity.FirstFragmentEntity;
import com.example.administrator.vfstore.imageutils.ImageLoaderUtil;
import com.example.administrator.vfstore.search.Search;
import com.example.administrator.vfstore.utils.JsonUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-9-30.
 */
public class FirstFragment extends BaseFragment {

    private ViewPager vp;
    private FirstFragmentEntity bean;
    private ImageView imageView;
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
            imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView_list,imageView_list2;
    private TextView text1,text2,text3,text4,text5,text6,text7,text8
            ,text9,text10,text11,text12,text13,text14,text15;

    public static String IMAGE_CACHE_PATH = "imageloader/Cache"; // 图片缓存路径

    private ViewPager adViewPager;
    private List<ImageView> imageViews;// 滑动的图片集合

    private List<View> dots; // 图片标题正文的那些点
    private List<View> dotList;

    private int currentItem = 0; // 当前图片的索引号
    // 定义的五个指示点
    private View dot0;
    private View dot1;
    private View dot2;
    private View dot3;
    private View dot4;

    private ScheduledExecutorService scheduledExecutorService;

    // 异步加载图片
    private ImageLoader mImageLoader;
    private DisplayImageOptions options;

    // 轮播banner的数据
    private List<FirstFragmentEntity.DataBean.AdvertisementBean> adList;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    protected int initLayout() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initView() {
        imageView = (ImageView) getView().findViewById(R.id.glass);
        vp = (ViewPager)getView().findViewById(R.id.vp);
        imageView1 = (ImageView) getView().findViewById(R.id.imageView1);
        imageView2 = (ImageView) getView().findViewById(R.id.imageView2);
        imageView3 = (ImageView) getView().findViewById(R.id.imageView3);
        imageView4 = (ImageView) getView().findViewById(R.id.imageView4);
        imageView5 = (ImageView) getView().findViewById(R.id.imageView5);
        imageView6 = (ImageView) getView().findViewById(R.id.imageView6);
        imageView7 = (ImageView) getView().findViewById(R.id.imageView7);
        imageView8 = (ImageView) getView().findViewById(R.id.imageView8);
        imageView9 = (ImageView) getView().findViewById(R.id.imageView9);
        imageView10 = (ImageView) getView().findViewById(R.id.imageView10);
        imageView11 = (ImageView) getView().findViewById(R.id.imageView11);
        imageView12 = (ImageView) getView().findViewById(R.id.imageView12);
        imageView13 = (ImageView) getView().findViewById(R.id.imageView13);
        imageView14 = (ImageView) getView().findViewById(R.id.imageView14);
        imageView15 = (ImageView) getView().findViewById(R.id.imageView15);

        imageView_list = (ImageView)getView().findViewById(R.id.imageView_list);
        imageView_list2 = (ImageView)getView().findViewById(R.id.imageView_list2);

        text1 = (TextView)getView().findViewById(R.id.text1);
        text2 = (TextView)getView().findViewById(R.id.text2);
        text3 = (TextView)getView().findViewById(R.id.text3);
        text4 = (TextView)getView().findViewById(R.id.text4);
        text5 = (TextView)getView().findViewById(R.id.text5);
        text6 = (TextView)getView().findViewById(R.id.text6);
        text7 = (TextView)getView().findViewById(R.id.text7);
        text8 = (TextView)getView().findViewById(R.id.text8);
        text9 = (TextView)getView().findViewById(R.id.text9);
        text10 = (TextView)getView().findViewById(R.id.text10);
        text11 = (TextView)getView().findViewById(R.id.text11);
        text12 = (TextView)getView().findViewById(R.id.text12);
        text13 = (TextView)getView().findViewById(R.id.text13);
        text14 = (TextView)getView().findViewById(R.id.text14);
        text15 = (TextView)getView().findViewById(R.id.text15);


    }

    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), Search.class);
                startActivity(it);
            }
        });

        initImageLoader();

        // 获取图片加载实例
        mImageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.top_banner_android)
                .showImageForEmptyUri(R.mipmap.top_banner_android)
                .showImageOnFail(R.mipmap.top_banner_android)
                .cacheInMemory(true).cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY).build();

        initAdData();

        startAd();

        request();
        

    }



    private void request() {

        HttpUtils httpUtils = new HttpUtils();
        // 请求参数
        RequestParams params = new RequestParams();
        //  params.addBodyParameter("PAGENUM", String.valueOf(pageNum));

        // 发送请求数据
        httpUtils.send(HttpRequest.HttpMethod.POST, Constant.FirstID, params,
                new RequestCallBack<String>() {
                    // 请求接口失败 arg1 为后台返回的错误信息
                    @Override
                    public void onFailure(HttpException arg0, String arg1) {
                        Log.i("请求失败",
                                "111111111111111111111 error: "
                                        + arg1.toString());
                    }

                    // 请求接口成功 arg0.tostring 为后台返回的信息
                    @Override
                    public void onSuccess(ResponseInfo<String> arg0) {

                        if (arg0.result.toString().equals("0")) {

                        } else {

                            Log.e("首页请求成功","999999999999999999999999999 onSuccess"+ arg0.result.toString());

                          //  getList(arg0.result.toString());// 请求返回的数据，json解析


                            String json = arg0.result.toString();
                            bean = JsonUtils.getJtoC(json, FirstFragmentEntity.class);

                            String text1_bean = bean.getData().getGoodsSort().get(0).getSortTitle();
                            text1.setText(text1_bean);
                            String imageView_bean = bean.getData().getGoodsSort().get(0).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView_bean,imageView1);

                            String text2_bean = bean .getData().getGoodsSort().get(1).getSortTitle();
                            text2.setText(text2_bean);
                            String imageView2_bean = bean.getData().getGoodsSort().get(1).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView2_bean,imageView2);

                            String text3_bean = bean .getData().getGoodsSort().get(2).getSortTitle();
                            text3.setText(text3_bean);
                            String imageView3_bean = bean.getData().getGoodsSort().get(2).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView3_bean,imageView3);

                            String text4_bean = bean .getData().getGoodsSort().get(3).getSortTitle();
                            text4.setText(text4_bean);
                            String imageView4_bean = bean.getData().getGoodsSort().get(3).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView4_bean,imageView4);

                            String text5_bean = bean .getData().getGoodsSort().get(4).getSortTitle();
                            text5.setText(text5_bean);
                            String imageView5_bean = bean.getData().getGoodsSort().get(4).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView5_bean,imageView5);

                            String text6_bean = bean .getData().getGoodsSort().get(5).getSortTitle();
                            text6.setText(text6_bean);
                            String imageView6_bean = bean.getData().getGoodsSort().get(5).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView6_bean,imageView6);

                            String text7_bean = bean .getData().getGoodsSort().get(6).getSortTitle();
                            text7.setText(text7_bean);
                            String imageView7_bean = bean.getData().getGoodsSort().get(6).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView7_bean,imageView7);

                            String text8_bean = bean .getData().getGoodsSort().get(7).getSortTitle();
                            text8.setText(text8_bean);
                            String imageView8_bean = bean.getData().getGoodsSort().get(7).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView8_bean,imageView8);

                            String text9_bean = bean .getData().getGoodsSort().get(8).getSortTitle();
                            text9.setText(text9_bean);
                            String imageView9_bean = bean.getData().getGoodsSort().get(8).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView9_bean,imageView9);

                            String text10_bean = bean .getData().getGoodsSort().get(9).getSortTitle();
                            text10.setText(text10_bean);
                            String imageView10_bean = bean.getData().getGoodsSort().get(9).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView10_bean,imageView10);

                            String text11_bean = bean .getData().getGoodsSort().get(10).getSortTitle();
                            text11.setText(text11_bean);
                            String imageView11_bean = bean.getData().getGoodsSort().get(10).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView11_bean,imageView11);

                            String text12_bean = bean .getData().getGoodsSort().get(11).getSortTitle();
                            text12.setText(text12_bean);
                            String imageView12_bean = bean.getData().getGoodsSort().get(11).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView12_bean,imageView12);

                            String text13_bean = bean .getData().getGoodsSort().get(12).getSortTitle();
                            text13.setText(text13_bean);
                            String imageView13_bean = bean.getData().getGoodsSort().get(12).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView13_bean,imageView13);

                            String text14_bean = bean .getData().getGoodsSort().get(13).getSortTitle();
                            text14.setText(text14_bean);
                            String imageView14_bean = bean.getData().getGoodsSort().get(13).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView14_bean,imageView14);

                            String text15_bean = bean .getData().getGoodsSort().get(14).getSortTitle();
                            text15.setText(text15_bean);
                            String imageView15_bean = bean.getData().getGoodsSort().get(14).getSortIconImg();
                            ImageLoaderUtil.getInternetImage(imageView15_bean,imageView15);

                            String imageView_first = bean.getData().getExpandList().get(0).getExpandImg();
                            ImageLoaderUtil.getInternetImage(imageView_first,imageView_list);

                            String imageView_first2 = bean.getData().getExpandList().get(1).getExpandImg();
                            ImageLoaderUtil.getInternetImage(imageView_first2,imageView_list2);

                        }

                    }

                });

    }




    private void initImageLoader() {
        File cacheDir = com.nostra13.universalimageloader.utils.StorageUtils
                .getOwnCacheDirectory(getContext(),
                        IMAGE_CACHE_PATH);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new LruMemoryCache(12 * 1024 * 1024))
                .memoryCacheSize(12 * 1024 * 1024)
                .discCacheSize(32 * 1024 * 1024).discCacheFileCount(100)
                .discCache(new UnlimitedDiscCache(cacheDir))
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();

        ImageLoader.getInstance().init(config);
    }

    private void initAdData() {
        // 广告数据
        adList = getBannerAd();

        imageViews = new ArrayList<ImageView>();

        // 点
        dots = new ArrayList<View>();
        dotList = new ArrayList<View>();
        dot0 = getView().findViewById(R.id.v_dot0);
        dot1 = getView().findViewById(R.id.v_dot1);
        dot2 = getView().findViewById(R.id.v_dot2);
        dot3 = getView().findViewById(R.id.v_dot3);
        dot4 = getView().findViewById(R.id.v_dot4);
        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.add(dot4);


        adViewPager = (ViewPager) getView().findViewById(R.id.vp);
        adViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.setOnPageChangeListener(new MyPageChangeListener());
        addDynamicView();
    }

    private void addDynamicView() {
        // 动态添加图片和下面指示的圆点
        // 初始化图片资源
        for (int i = 0; i < adList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            // 异步加载图片
            mImageLoader.displayImage(adList.get(i).getADImg(), imageView,
                    options);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
            dots.get(i).setVisibility(View.VISIBLE);
            dotList.add(dots.get(i));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void startAd() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
    }

    private class ScrollTask implements Runnable {

        @Override
        public void run() {
            synchronized (adViewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        private int oldPosition = 0;

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            currentItem = position;
            FirstFragmentEntity.DataBean.AdvertisementBean adDomain = adList.get(position);
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return adList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViews.get(position);
            ((ViewPager) container).addView(iv);
            final FirstFragmentEntity.DataBean.AdvertisementBean adDomain = adList.get(position);
            // 在这个方法里面设置图片的点击事件
            iv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 处理跳转逻辑
                }
            });
            return iv;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }

    }

    /**
     * 轮播广播模拟数据
     *
     * @return
     */
    public static List<FirstFragmentEntity.DataBean.AdvertisementBean> getBannerAd() {
        List<FirstFragmentEntity.DataBean.AdvertisementBean> adList = new ArrayList<FirstFragmentEntity.DataBean.AdvertisementBean>();

        FirstFragmentEntity.DataBean.AdvertisementBean adDomain = new FirstFragmentEntity.DataBean.AdvertisementBean();
        adDomain.setADImg("http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f5fb2c651b1.png");
        adList.add(adDomain);

        FirstFragmentEntity.DataBean.AdvertisementBean adDomain2 = new FirstFragmentEntity.DataBean.AdvertisementBean();
        adDomain2.setADImg("http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f5fb3776e16.png");
        adList.add(adDomain2);

        return adList;
    }
}
