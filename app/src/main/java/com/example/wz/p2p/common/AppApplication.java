package com.example.wz.p2p.common;

import android.app.Application;

/**
 * Created by wz on 17-6-21.
 */

public class AppApplication extends Application {

    private static  AppApplication mApplication;

    public AppApplication getApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        //CrashHandler.getInstance().init(this);
    }
}
