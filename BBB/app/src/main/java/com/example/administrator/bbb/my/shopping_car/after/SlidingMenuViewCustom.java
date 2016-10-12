package com.example.administrator.bbb.my.shopping_car.after;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.administrator.bbb.R;

/**
 * Created by dllo on 16/5/14.
 */
public class SlidingMenuViewCustom extends HorizontalScrollView{
    private int mScrollWidth;
    private Boolean isOpen;
    private SlidingListener slidingListener;

    //接口的set方法 设监听事件
    public void setSlidingListener(SlidingListener slidingListener) {
        this.slidingListener = slidingListener;
    }

    public SlidingMenuViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        //让item的每一个菜单滚动跟随线都消失
        setHorizontalScrollBarEnabled(false);
        //默认这个菜单是关闭状态
        isOpen = false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        TextView deletemenu = (TextView) findViewById(R.id.tv_my_shopping_car_after_delete_menu);
        mScrollWidth = deletemenu.getWidth();

    }

    //判断菜单是打开还是关闭的方法
    private void changeScroll(){
        if (getScrollX() > mScrollWidth / 2){
            isOpen = true;
            smoothScrollTo(mScrollWidth + 50, 0);
            slidingListener.onMenuIsOpen(this);
        }else {
            closeMenu();
        }

    }


    public void closeMenu(){
        smoothScrollTo(0,0);
        isOpen = false;
    }

    public void clickOpenMenu(){
        smoothScrollTo(mScrollWidth + 50, 0);
        slidingListener.onMenuIsOpen(this);
        isOpen = false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                slidingListener.onMove(this);
                break;
            case MotionEvent.ACTION_UP:
                changeScroll();
                return true;
        }
        return super.onTouchEvent(ev);
    }

    //把当前滑动的那个传出去 上adapter里面去做判断 看滑开的是不是当前点击的item
    public interface SlidingListener{
        void onMove(SlidingMenuViewCustom slidingMenuViewCustom);
        void onMenuIsOpen(SlidingMenuViewCustom slidingMenuViewCustom);
    }
}
