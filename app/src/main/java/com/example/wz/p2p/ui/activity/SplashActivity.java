package com.example.wz.p2p.ui.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wz.p2p.R;

import butterknife.BindView;

/**
 * Created by wz on 17-6-20.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_version_code)
    TextView mTvVersionCode;
    @BindView(R.id.rl_splash)
    RelativeLayout mRelativeLayout;
    private AlphaAnimation mAlphaAnimation;


    @Override
    protected int setLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        mTvVersionCode.setText(getVersionCOde());

        //设置渐变动画
        mAlphaAnimation = new AlphaAnimation(0, 1);
        mAlphaAnimation.setDuration(1000);
        mAlphaAnimation.setFillAfter(true);
        mRelativeLayout.setAnimation(mAlphaAnimation);
        mRelativeLayout.startAnimation(mAlphaAnimation);
    }

    @Override
    protected void initListener() {
        mAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 获取版本号名称
     * @return
     */
    private String getVersionCOde() {

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";

    }
}
