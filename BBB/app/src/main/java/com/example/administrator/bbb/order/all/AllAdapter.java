package com.example.administrator.bbb.order.all;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.tools.RVOnItemClickListener;
import com.example.administrator.bbb.tools.RVOnItemLongClickListener;
import com.example.administrator.bbb.tools.okh.NetTool;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-3.
 */
public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ViewHolder> implements View.OnClickListener {
    private AllBean mAllBeen;
    private Context mContext;
    private RVOnItemClickListener myOnClickListener;
    private RVOnItemLongClickListener myOnLongClickListener;

    public void setMyOnClickListener(RVOnItemClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
        notifyDataSetChanged();
    }

    //    public void setMyOnLongClickListener(MyRVOnLongClickListener myOnLongClickListener) {
//        this.myOnLongClickListener = myOnLongClickListener;
//    }

    public AllAdapter(Context context) {
        mContext = context;
    }

    public void setAllBeen(AllBean allBeen) {
        mAllBeen = allBeen;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_all_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.storeName.setText(mAllBeen.getData().get(position).getStoreName());
        holder.goodsName.setText(mAllBeen.getData().get(position).getGoodsTitle());
        holder.price.setText(mAllBeen.getData().get(position).getPrice());
        holder.priceOld.setText(mAllBeen.getData().get(position).getCostPrice());
        holder.num.setText(mAllBeen.getData().get(position).getNum());
        holder.priceExpress.setText(mAllBeen.getData().get(position).getGoods_express_fee() + " )");
        holder.total.setText(mAllBeen.getData().get(position).getTotal());
        holder.msg.setText(mAllBeen.getData().get(position).getMsg());
        holder.numAll.setText("共" + mAllBeen.getData().get(position).getNum() + "件商品，合计:");
        holder.orderDelete.setOnClickListener(this);

        Picasso.with(mContext).load(mAllBeen.getData().get(position).getGoodsIcon()).into(holder.goodsHead);

        if (myOnClickListener !=null){
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position1 = holder.getLayoutPosition();//getLayoutPosition()得到当前的position
                    myOnClickListener.onClick(position1);//position点击的位置
                }
            });

        }
//        //实现长按点击事件
//        if (myOnLongClickListener!=null){
//            holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    int position=holder.getLayoutPosition();
//                    myOnLongClickListener.onLongClick(position);
//
//                    return true;
//                }
//            });
//        }


    }

    @Override
    public int getItemCount() {
        return mAllBeen.getData().size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_order_all_item_delete_order:
//                NetTool.getInstance().startRequest();
                Toast.makeText(mContext, "allals", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView state, orderId, storeName, goodsName, price, priceOld, num, total, msg, priceExpress, numAll;
        private ImageView goodsHead;
        private Button orderDelete, orderEvaluation;
        private RelativeLayout mLayout;

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

            orderDelete = (Button) itemView.findViewById(R.id.btn_order_all_item_delete_order);
            orderEvaluation = (Button) itemView.findViewById(R.id.btn_order_all_item_evaluation);

            mLayout = (RelativeLayout) itemView.findViewById(R.id.reLayout_order_all);
        }
    }


}
