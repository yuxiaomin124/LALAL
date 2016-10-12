package com.example.administrator.bbb.order.evaluation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.order.receipt_goods.ReceiptGoodsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-3.
 */
public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.ViewHolder> {
    private EvaluationBean mEvaluationBean;
    private Context mContext;

    public EvaluationAdapter(Context context) {
        mContext = context;
    }

    public void setEvaluationBean(EvaluationBean evaluationBean) {
        mEvaluationBean = evaluationBean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_evaluation_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;

        viewHolder.storeName.setText(mEvaluationBean.getData().get(position).getStoreName());
        viewHolder.goodsName.setText(mEvaluationBean.getData().get(position).getGoodsTitle());
        viewHolder.price.setText(mEvaluationBean.getData().get(position).getPrice());
        viewHolder.priceOld.setText(mEvaluationBean.getData().get(position).getCostPrice());
        viewHolder.num.setText(mEvaluationBean.getData().get(position).getNum());
        viewHolder.priceExpress.setText( " ¥ "+mEvaluationBean.getData().get(position).getGoods_express_fee()+ " )");
        viewHolder.total.setText(mEvaluationBean.getData().get(position).getTotal());
        viewHolder.msg.setText(mEvaluationBean.getData().get(position).getMsg());

        viewHolder.numAll.setText("共" + mEvaluationBean.getData().get(position).getNum() + "件商品，合计:¥ ");

    }

    @Override
    public int getItemCount() {
        return mEvaluationBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView state,orderId,storeName,goodsName,price,priceOld,num,total,msg,priceExpress,numAll;
        private ImageView goodsHead;
        public ViewHolder(View itemView) {
            super(itemView);
            storeName = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_title);
            goodsName = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_goodsname);
            price = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_price_current);
            priceOld = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_price_old);
            num = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_count);
            total = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_price_totle);
            msg = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_msg);
            priceExpress = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_price_extra);
            numAll = (TextView) itemView.findViewById(R.id.tv_order_evaluation_item_count_all);
            goodsHead = (ImageView) itemView.findViewById(R.id.iv_order_evaluation_item_head);
        }
    }
}
