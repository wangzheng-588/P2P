package com.example.wz.p2p.data;

import com.example.wz.p2p.bean.IndexBean;
import com.example.wz.p2p.common.utils.RetrofitUtil;

import io.reactivex.Observable;

/**
 * Created by wz on 17-6-21.
 */

public class IndexModel {


    public Observable<IndexBean> getIndexData(){
        return RetrofitUtil.getInstance().getIndexData();
    }

}
