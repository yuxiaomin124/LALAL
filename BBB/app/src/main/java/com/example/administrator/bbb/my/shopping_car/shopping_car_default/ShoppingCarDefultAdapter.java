package com.example.administrator.bbb.my.shopping_car.shopping_car_default;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.bbb.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarDefultAdapter extends RecyclerView.Adapter<ShoppingCarDefultAdapter.ViewHolder>{
    private ShoppingCarDefultBean mDefultBean;
    private Context mContext;


    public ShoppingCarDefultAdapter(Context context) {
        mContext = context;
    }

    public void setDefultBean(ShoppingCarDefultBean defultBean) {
        mDefultBean = defultBean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_my_shopping_car_edit_default_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ViewHolder viewHolder = holder;
//        viewHolder.name.setText(mDefultBean.getData().getGoodsList().get(position).getName());
        viewHolder.shop.setText(mDefultBean.getData().getGoodsList().get(position).getShop());
        viewHolder.size.setText(mDefultBean.getData().getGoodsList().get(position).getSpecification() + "    " + mDefultBean.getData().getGoodsList().get(position).getName());
        viewHolder.num.setText(mDefultBean.getData().getGoodsList().get(position).getNum());
        viewHolder.price.setText(mDefultBean.getData().getGoodsList().get(position).getPrice());
        viewHolder.priceOld.setText(mDefultBean.getData().getGoodsList().get(position).getOldPrice());

        viewHolder.goodsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.num.setText(mDefultBean.getData().getGoodsList().get(position).getNum() + 1 + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDefultBean.getData().getGoodsList().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, shop, size, num, price, priceOld;
        private ImageView goodsHead, goodsAdd, goodsDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            size = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_color);
//            name = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_shop);
            shop = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_size);
            num = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_num);
            price = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_price_now);
            priceOld = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_price_old);
            goodsHead = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_default_item_head);
            goodsAdd = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_default_item_add);
            goodsDelete = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_default_item_delete);


        }
    }
}
