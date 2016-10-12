package com.example.administrator.bbb.my.shopping_car.after;

import java.util.List;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarAfterBean {

    /**
     * Status : true
     * returnCode : 1
     * returnInfo :
     * Data : {"goodsList":[{"goodsId":"1","goodsImg":"http://www.jinyuankeji.net/VF/upg/goods/2016-10-06/57f5fe16ce05d.png","Name":"时尚女装","shop":"小鱼儿的服装店","Specification":"黑色","num":"1","price":"￥120.00","oldPrice":"￥120.00"}]}
     */

    private String Status;
    private String returnCode;
    private String returnInfo;
    private DataBean Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * goodsId : 1
         * goodsImg : http://www.jinyuankeji.net/VF/upg/goods/2016-10-06/57f5fe16ce05d.png
         * Name : 时尚女装
         * shop : 小鱼儿的服装店
         * Specification : 黑色
         * num : 1
         * price : ￥120.00
         * oldPrice : ￥120.00
         */

        private List<GoodsListBean> goodsList;

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            private String goodsId;
            private String goodsImg;
            private String Name;
            private String shop;
            private String Specification;
            private String num;
            private String price;
            private String oldPrice;

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsImg() {
                return goodsImg;
            }

            public void setGoodsImg(String goodsImg) {
                this.goodsImg = goodsImg;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getShop() {
                return shop;
            }

            public void setShop(String shop) {
                this.shop = shop;
            }

            public String getSpecification() {
                return Specification;
            }

            public void setSpecification(String Specification) {
                this.Specification = Specification;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(String oldPrice) {
                this.oldPrice = oldPrice;
            }
        }
    }
}
