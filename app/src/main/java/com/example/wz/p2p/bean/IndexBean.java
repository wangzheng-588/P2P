package com.example.wz.p2p.bean;

import java.util.List;

/**
 * Created by wz on 17-6-21.
 */

public class IndexBean {


    /**
     * imageArr : [{"ID":"1","IMAPAURL":"http://gwop.xtrich.com/xtApp/lexianghuo1.html","IMAURL":"images/index01.png"},{"ID":"2","IMAPAURL":"http://gwop.xtrich.com/xtApp/new-plan.html","IMAURL":"images/index02.png"},{"ID":"3","IMAPAURL":"http://gwop.xtrich.com/xtApp/new-plan.html","IMAURL":"images/index03.png"},{"ID":"5","IMAPAURL":"http://gwop.xtrich.com/xtApp/twcx.html","IMAURL":"images/index04.png"}]
     * proInfo : {"id":"1","memberNum":"100","minTouMoney":"100","money":"10","name":"硅谷彩虹新手计划","progress":"90","suodingDays":"30","yearRate":"8.00"}
     */

    private ProInfoEntity proInfo;
    private List<ImageArrEntity> imageArr;

    public void setProInfo(ProInfoEntity proInfo) {
        this.proInfo = proInfo;
    }

    public void setImageArr(List<ImageArrEntity> imageArr) {
        this.imageArr = imageArr;
    }

    public ProInfoEntity getProInfo() {
        return proInfo;
    }

    public List<ImageArrEntity> getImageArr() {
        return imageArr;
    }

    public static class ProInfoEntity {
        /**
         * id : 1
         * memberNum : 100
         * minTouMoney : 100
         * money : 10
         * name : 硅谷彩虹新手计划
         * progress : 90
         * suodingDays : 30
         * yearRate : 8.00
         */

        private String id;
        private String memberNum;
        private String minTouMoney;
        private String money;
        private String name;
        private String progress;
        private String suodingDays;
        private String yearRate;

        public void setId(String id) {
            this.id = id;
        }

        public void setMemberNum(String memberNum) {
            this.memberNum = memberNum;
        }

        public void setMinTouMoney(String minTouMoney) {
            this.minTouMoney = minTouMoney;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public void setSuodingDays(String suodingDays) {
            this.suodingDays = suodingDays;
        }

        public void setYearRate(String yearRate) {
            this.yearRate = yearRate;
        }

        public String getId() {
            return id;
        }

        public String getMemberNum() {
            return memberNum;
        }

        public String getMinTouMoney() {
            return minTouMoney;
        }

        public String getMoney() {
            return money;
        }

        public String getName() {
            return name;
        }

        public String getProgress() {
            return progress;
        }

        public String getSuodingDays() {
            return suodingDays;
        }

        public String getYearRate() {
            return yearRate;
        }
    }

    public static class ImageArrEntity {
        /**
         * ID : 1
         * IMAPAURL : http://gwop.xtrich.com/xtApp/lexianghuo1.html
         * IMAURL : images/index01.png
         */

        private String ID;
        private String IMAPAURL;
        private String IMAURL;

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setIMAPAURL(String IMAPAURL) {
            this.IMAPAURL = IMAPAURL;
        }

        public void setIMAURL(String IMAURL) {
            this.IMAURL = IMAURL;
        }

        public String getID() {
            return ID;
        }

        public String getIMAPAURL() {
            return IMAPAURL;
        }

        public String getIMAURL() {
            return IMAURL;
        }
    }
}
