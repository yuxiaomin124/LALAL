package com.example.administrator.bbb.order.receipt_goods;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bbb.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-3.
 */
public class ReceiptGoodsAdapter extends RecyclerView.Adapter<ReceiptGoodsAdapter.ViewHolder> {
    private ArrayList<ReceiptGoodsBean> mBeanArrayList;
    private Context mContext;


    public ReceiptGoodsAdapter(Context context) {
        mContext = context;
    }

    public void setBeanArrayList(ArrayList<ReceiptGoodsBean> beanArrayList) {
        mBeanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_receipt_goods_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.title.setText(mBeanArrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mBeanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_order_receipt_goods_item_title);


        }
    }
}
