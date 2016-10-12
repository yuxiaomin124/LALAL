package com.example.administrator.bbb.order.after_sales;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.order.all.AllBean;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016-10-3.
 */
public class AfterSalesAdapter extends RecyclerView.Adapter<AfterSalesAdapter.ViewHolder> {
    private AllBean mAfterBean;
    private Context mContext;

    public AfterSalesAdapter(Context context) {
        mContext = context;
    }

    public void setAllBeen(AllBean allBeen) {
        mAfterBean = allBeen;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.storeName.setText(mAfterBean.getData().get(position).getStoreName());
        viewHolder.goodsName.setText(mAfterBean.getData().get(position).getGoodsTitle());
        viewHolder.price.setText(mAfterBean.getData().get(position).getPrice());
        viewHolder.priceOld.setText(mAfterBean.getData().get(position).getCostPrice());
        viewHolder.num.setText(mAfterBean.getData().get(position).getNum());
        viewHolder.priceExpress.setText(mAfterBean.getData().get(position).getGoods_express_fee()+ " )");
        viewHolder.total.setText(mAfterBean.getData().get(position).getTotal());
        viewHolder.msg.setText(mAfterBean.getData().get(position).getMsg());

        viewHolder.numAll.setText("共" + mAfterBean.getData().get(position).getNum() + "件商品，合计:");
        Picasso.with(mContext).load(mAfterBean.getData().get(position).getGoodsIcon()).into(viewHolder.goodsHead);

    }

    @Override
    public int getItemCount() {
        return mAfterBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView state,orderId,storeName,goodsName,price,priceOld,num,total,msg,priceExpress,numAll;
        private ImageView goodsHead;

        public ViewHolder(View itemView) {
            super(itemView);
            storeName = (TextView) itemView.findViewById(R.id.tv_order_all_item_title);
            goodsName = (TextView) itemView.findViewById(R.id.tv_order_all_item_goodsname);
            price = (TextView) itemView.findViewById(R.id.tv_order_all_item_price_current);
            priceOld = (TextView) itemView.findViewById(R.id.tv_order_all_item_price_old);
            num = (TextView) itemView.findViewById(R.id.tv_order_all_item_count);
            total = (TextView) itemView.findViewById(R.id.tv_order_all_item_price_totle);
            msg = (TextView) itemView.findViewById(R.id.tv_order_all_item_msg);
            priceExpress = (TextView) itemView.findViewById(R.id.tv_order_all_item_price_extra);
            numAll = (TextView) itemView.findViewById(R.id.tv_order_all_item_count_all);
            goodsHead = (ImageView) itemView.findViewById(R.id.iv_order_all_item_goodshead);
        }
    }
}
