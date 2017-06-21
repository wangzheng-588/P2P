package com.example.wz.p2p.common.utils;

import com.example.wz.p2p.bean.IndexBean;
import com.example.wz.p2p.common.ApiService;
import com.example.wz.p2p.common.config.AppNetConfig;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wz on 17-6-21.
 */

public class RetrofitUtil {

    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static RetrofitUtil sRetrofitUtil;
    private final ApiService mApiService;


    private RetrofitUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);

        Retrofit build = new Retrofit.Builder().baseUrl(AppNetConfig.BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mApiService = build.create(ApiService.class);

    }

    public static RetrofitUtil getInstance() {
        if (sRetrofitUtil == null){
            synchronized (RetrofitUtil.class){
                if (sRetrofitUtil==null){
                    sRetrofitUtil = new RetrofitUtil();
                }
            }
        }
        return sRetrofitUtil;
    }


    public Observable<IndexBean> getIndexData(){
        return mApiService.getIndexData();
    }

}
