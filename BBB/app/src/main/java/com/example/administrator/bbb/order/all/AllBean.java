package com.example.administrator.bbb.order.all;

import java.util.List;

/**
 * Created by Administrator on 2016-10-3.
 */
public class AllBean {


    /**
     * Status : true
     * returnCode : 1
     * returnInfo :
     * Data : [{"state":"1","orderId":"8","storeName":"333三只松鼠","goodsTitle":"测试","goodsIcon":"http://www.jinyuankeji.net//VF/upg/goods/2016-09-27/57e9dffebe7f1.jpg","price":"1.30","costPrice":"20.00","num":"1","goods_express_fee":"1.00","total":"2.30","msg":"待收货"},{"state":"1","orderId":"10","storeName":"333三只松鼠","goodsTitle":"测试","goodsIcon":"http://www.jinyuankeji.net//VF/upg/goods/2016-09-27/57e9dffebe7f1.jpg","price":"5.10","costPrice":"20.00","num":"1","goods_express_fee":"1.00","total":"6.10","msg":"待收货"},{"state":"1","orderId":"11","storeName":"333三只松鼠","goodsTitle":"测试","goodsIcon":"http://www.jinyuankeji.net//VF/upg/goods/2016-09-27/57e9dffebe7f1.jpg","price":"5.10","costPrice":"20.00","num":"1","goods_express_fee":"1.00","total":"6.10","msg":"待收货"}]
     */

    private String Status;
    private String returnCode;
    private String returnInfo;
    /**
     * state : 1
     * orderId : 8
     * storeName : 333三只松鼠
     * goodsTitle : 测试
     * goodsIcon : http://www.jinyuankeji.net//VF/upg/goods/2016-09-27/57e9dffebe7f1.jpg
     * price : 1.30
     * costPrice : 20.00
     * num : 1
     * goods_express_fee : 1.00
     * total : 2.30
     * msg : 待收货
     */

    private List<DataBean> Data;

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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private String state;
        private String orderId;
        private String storeName;
        private String goodsTitle;
        private String goodsIcon;
        private String price;
        private String costPrice;
        private String num;
        private String goods_express_fee;
        private String total;
        private String msg;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }

        public String getGoodsIcon() {
            return goodsIcon;
        }

        public void setGoodsIcon(String goodsIcon) {
            this.goodsIcon = goodsIcon;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(String costPrice) {
            this.costPrice = costPrice;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getGoods_express_fee() {
            return goods_express_fee;
        }

        public void setGoods_express_fee(String goods_express_fee) {
            this.goods_express_fee = goods_express_fee;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
