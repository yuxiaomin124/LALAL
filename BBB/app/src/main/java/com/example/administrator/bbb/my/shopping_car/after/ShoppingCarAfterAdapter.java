package com.example.administrator.bbb.my.shopping_car.after;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.tools.RVOnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarAfterAdapter extends RecyclerView.Adapter<ShoppingCarAfterAdapter.ViewHolder> implements SlidingMenuViewCustom.SlidingListener {
    private ShoppingCarAfterBean mAfterBeen;
    private Context mContext;
    private SlidingMenuViewCustom slidingMenuViewCustom;


    public ShoppingCarAfterAdapter(Context context) {
        mContext = context;
    }

    public void setAfterBeen(ShoppingCarAfterBean afterBeen) {
        mAfterBeen = afterBeen;
        notifyDataSetChanged();
    }

    public void closeMenu() {
        if (slidingMenuViewCustom != null) {
            slidingMenuViewCustom.closeMenu();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.activity_my_shopping_car_edit_after_item, parent, false);
        ViewHolder holder = new ViewHolder(itemView);

        ViewGroup.LayoutParams layoutParams = holder.layout.getLayoutParams();
        layoutParams.width = Utils.getScreenWidth(mContext);
        holder.layout.setLayoutParams(layoutParams);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ViewHolder viewHolder = holder;
        viewHolder.shop.setText(mAfterBeen.getData().getGoodsList().get(position).getShop());
        viewHolder.size.setText(mAfterBeen.getData().getGoodsList().get(position).getSpecification() + "    " + mAfterBeen.getData().getGoodsList().get(position).getName());
        viewHolder.num.setText(mAfterBeen.getData().getGoodsList().get(position).getNum());
        viewHolder.price.setText(mAfterBeen.getData().getGoodsList().get(position).getPrice());
        viewHolder.priceOld.setText(mAfterBeen.getData().getGoodsList().get(position).getOldPrice());

        viewHolder.cbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.cbDelete.isChecked()) {
                    slidingMenuViewCustom.clickOpenMenu();
                    Toast.makeText(mContext, "dianji", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //给删除菜单设置监听事件
        holder.llDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得当前的position 删除
                int position = holder.getLayoutPosition();
                removeItem(position);
            }
        });
    }

    public void removeItem(int position) {
        mAfterBeen.getData().getGoodsList().remove(position);
        slidingMenuViewCustom.closeMenu();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAfterBeen.getData().getGoodsList().size();
    }

    @Override
    public void onMove(SlidingMenuViewCustom slidingMenuViewCustom) {
        if (this.slidingMenuViewCustom != slidingMenuViewCustom) {
            if (this.slidingMenuViewCustom != null) {
                this.slidingMenuViewCustom.closeMenu();
            }
        }
    }

    @Override
    public void onMenuIsOpen(SlidingMenuViewCustom slidingMenuViewCustom) {
        //那个slidingMenuViewCustom传过来 让他等于adapter中的 就传过来了
        this.slidingMenuViewCustom = slidingMenuViewCustom;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, shop, size, num, price, priceOld, deleteMenu;
        private ImageView goodsHead, goodsAdd, goodsDelete;
        private CheckBox cbDelete;
        private LinearLayout layout,llDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            size = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_edit_after_item_color);
//            name = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_default_item_shop);
            shop = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_edit_after_item_size);
            num = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_edit_after_item_num);
            price = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_edit_after_item_price_now);
            priceOld = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_edit_after_item_price_old);
            goodsHead = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_edit_after_item_head);
            goodsAdd = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_edit_after_item_add);
            goodsDelete = (ImageView) itemView.findViewById(R.id.iv_my_shopping_car_edit_after_item_delete);
            cbDelete = (CheckBox) itemView.findViewById(R.id.cb_my_shopping_car_edit_after);

            ((SlidingMenuViewCustom) itemView).setSlidingListener(ShoppingCarAfterAdapter.this);
            layout = (LinearLayout) itemView.findViewById(R.id.llayout_my_shopping_after);
            deleteMenu = (TextView) itemView.findViewById(R.id.tv_my_shopping_car_after_delete_menu);

            llDelete = (LinearLayout) itemView.findViewById(R.id.ll_my_shopping_after_delete);
        }
    }
}
