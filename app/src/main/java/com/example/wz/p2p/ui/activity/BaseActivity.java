package com.example.wz.p2p.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wz on 17-6-20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutResID());
        mBind = ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    protected abstract int setLayoutResID();

    protected  void initView(){}

    protected abstract void initData();

    protected void initListener() {

    }

    @Override
    protected void onDestroy() {
        if (mBind!=mBind.EMPTY){
            mBind.unbind();
        }
        super.onDestroy();

    }
}
