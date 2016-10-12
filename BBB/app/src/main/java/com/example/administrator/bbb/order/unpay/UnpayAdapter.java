package com.example.administrator.bbb.order.unpay;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.bbb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-3.
 */
public class UnpayAdapter extends RecyclerView.Adapter<UnpayAdapter.ViewHolder> {
    private UnpayBean mUnpayBean;
    private Context mContext;


    public UnpayAdapter(Context context) {
        mContext = context;
    }

    public void setUnpayBean(UnpayBean unpayBean) {
        mUnpayBean = unpayBean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_unpay_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.storeName.setText(mUnpayBean.getData().get(position).getStoreName());
        viewHolder.goodsName.setText(mUnpayBean.getData().get(position).getGoodsTitle());
        viewHolder.price.setText(mUnpayBean.getData().get(position).getPrice());
        viewHolder.priceOld.setText(mUnpayBean.getData().get(position).getCostPrice());
        viewHolder.num.setText(mUnpayBean.getData().get(position).getNum());
        viewHolder.priceExpress.setText(mUnpayBean.getData().get(position).getGoods_express_fee()+ " )");
        viewHolder.total.setText(mUnpayBean.getData().get(position).getTotal());
        viewHolder.msg.setText(mUnpayBean.getData().get(position).getMsg());

        viewHolder.numAll.setText("共" + mUnpayBean.getData().get(position).getNum() + "件商品，合计:");

        Picasso.with(mContext).load(mUnpayBean.getData().get(position).getGoodsIcon()).into(viewHolder.goodsHead);
    }

    @Override
    public int getItemCount() {
        return mUnpayBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView state,orderId,storeName,goodsName,price,priceOld,num,total,msg,priceExpress,numAll;
        private ImageView goodsHead;

        public ViewHolder(View itemView) {
            super(itemView);
            storeName = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_title);
            goodsName = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_goodsname);
            price = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_price_current);
            priceOld = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_price_old);
            num = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_count);
            total = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_price_totle);
            msg = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_msg);
            priceExpress = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_price_extra);
            numAll = (TextView) itemView.findViewById(R.id.tv_order_unpay_item_count_all);
            goodsHead = (ImageView) itemView.findViewById(R.id.iv_order_unpay_item_head);
        }
    }
}
