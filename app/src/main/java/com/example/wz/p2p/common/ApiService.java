package com.example.wz.p2p.common;

import com.example.wz.p2p.bean.IndexBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by wz on 17-6-21.
 */

public interface ApiService {

    @GET("index")
    Observable<IndexBean> getIndexData();

}
