package com.example.administrator.vfstore.entity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/9.
 */
public class FirstFragmentEntity {

    /**
     * Status : true
     * returnCode : 1
     * returnInfo :
     * Data : {"advertisement":[{"ADid":"2","ADImg":"http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f5fb2c651b1.png","ADURL":"http://www.jinyuankeji.net/VF/portal/index/goods?goods_id=32","ADTitle":""},{"ADid":"3","ADImg":"http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f5fb3776e16.png","ADURL":"http://www.jinyuankeji.net/VF/portal/index/goods?goods_id=32","ADTitle":""}],"goodsSort":[{"SortTitle":"服饰鞋帽","SortId":"7","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee14b09dc5a.png"},{"SortTitle":"美妆个饰","SortId":"8","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee14463b0c0.png"},{"SortTitle":"母婴玩具","SortId":"9","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee145154a9f.png"},{"SortTitle":"家具日用","SortId":"10","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee145edb0c8.png"},{"SortTitle":"电脑办公","SortId":"16","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee147dd957e.png"},{"SortTitle":"电视影音","SortId":"21","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee149969253.png"},{"SortTitle":"钟表首饰","SortId":"25","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee15180185d.png"},{"SortTitle":"通讯产品","SortId":"26","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee153e3ed6b.png"},{"SortTitle":"汽车用品","SortId":"27","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee1553ad53d.png"},{"SortTitle":"食品酒水","SortId":"28","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee1568a44c2.png"},{"SortTitle":"箱包奢品","SortId":"29","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee15d3d2897.png"},{"SortTitle":"健康医疗","SortId":"30","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee15e83d702.png"},{"SortTitle":"文化艺术","SortId":"31","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee15fc397ac.png"},{"SortTitle":"家装建材","SortId":"32","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee16103053c.png"},{"SortTitle":"手机数码","SortId":"33","SortIconImg":"http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee170c701b4.png"}],"expandList":[{"sortID":"4","expandImg":"http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f60b9843803.png"},{"sortID":"24","expandImg":"http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f60ba556b05.png"}]}
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
         * ADid : 2
         * ADImg : http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f5fb2c651b1.png
         * ADURL : http://www.jinyuankeji.net/VF/portal/index/goods?goods_id=32
         * ADTitle :
         */

        private List<AdvertisementBean> advertisement;
        /**
         * SortTitle : 服饰鞋帽
         * SortId : 7
         * SortIconImg : http://www.jinyuankeji.net//VF/upg/config/2016-09-30/57ee14b09dc5a.png
         */

        private List<GoodsSortBean> goodsSort;
        /**
         * sortID : 4
         * expandImg : http://www.jinyuankeji.net//VF/upg/config/2016-10-06/57f60b9843803.png
         */

        private List<ExpandListBean> expandList;

        public List<AdvertisementBean> getAdvertisement() {
            return advertisement;
        }

        public void setAdvertisement(List<AdvertisementBean> advertisement) {
            this.advertisement = advertisement;
        }

        public List<GoodsSortBean> getGoodsSort() {
            return goodsSort;
        }

        public void setGoodsSort(List<GoodsSortBean> goodsSort) {
            this.goodsSort = goodsSort;
        }

        public List<ExpandListBean> getExpandList() {
            return expandList;
        }

        public void setExpandList(List<ExpandListBean> expandList) {
            this.expandList = expandList;
        }

        public static class AdvertisementBean {
            private String ADid;
            private String ADImg;
            private String ADURL;
            private String ADTitle;

            public String getADid() {
                return ADid;
            }

            public void setADid(String ADid) {
                this.ADid = ADid;
            }

            public String getADImg() {
                return ADImg;
            }

            public void setADImg(String ADImg) {
                this.ADImg = ADImg;
            }

            public String getADURL() {
                return ADURL;
            }

            public void setADURL(String ADURL) {
                this.ADURL = ADURL;
            }

            public String getADTitle() {
                return ADTitle;
            }

            public void setADTitle(String ADTitle) {
                this.ADTitle = ADTitle;
            }
        }

        public static class GoodsSortBean {
            private String SortTitle;
            private String SortId;
            private String SortIconImg;

            public String getSortTitle() {
                return SortTitle;
            }

            public void setSortTitle(String SortTitle) {
                this.SortTitle = SortTitle;
            }

            public String getSortId() {
                return SortId;
            }

            public void setSortId(String SortId) {
                this.SortId = SortId;
            }

            public String getSortIconImg() {
                return SortIconImg;
            }

            public void setSortIconImg(String SortIconImg) {
                this.SortIconImg = SortIconImg;
            }
        }

        public static class ExpandListBean {
            private String sortID;
            private String expandImg;

            public String getSortID() {
                return sortID;
            }

            public void setSortID(String sortID) {
                this.sortID = sortID;
            }

            public String getExpandImg() {
                return expandImg;
            }

            public void setExpandImg(String expandImg) {
                this.expandImg = expandImg;
            }
        }
    }
}
