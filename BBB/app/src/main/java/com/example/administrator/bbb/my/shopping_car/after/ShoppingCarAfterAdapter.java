package com.example.administrator.bbb.my.shopping_car.after;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bbb.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarAfterAdapter extends RecyclerView.Adapter<ShoppingCarAfterAdapter.ViewHolder>{
    private ArrayList<ShoppingCarAfterBean> mAfterBeen;
    private Context mContext;


    public ShoppingCarAfterAdapter(Context context) {
        mContext = context;
    }

    public void setAllBeen(ArrayList<ShoppingCarAfterBean> afterBeen) {
        mAfterBeen = afterBeen;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_my_shopping_car_edit_after_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.title.setText(mAfterBeen.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return mAfterBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_color);


        }
    }
}