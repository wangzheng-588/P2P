package com.example.wz.p2p.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wz.p2p.R;
import com.example.wz.p2p.ui.fragment.HomeFragment;
import com.example.wz.p2p.ui.fragment.InvertFragment;
import com.example.wz.p2p.ui.fragment.MoreFragment;
import com.example.wz.p2p.ui.fragment.PropertyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.rg_main)
    RadioGroup mRgMain;


    private List<Fragment> mFragmentList;
    private int mCurrentPosition;
    private Fragment mPreFragment;

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragment();

    }

    @Override
    protected void initListener() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mCurrentPosition = 0;
                        break;
                    case R.id.rb_invest:
                        mCurrentPosition = 1;
                        break;
                    case R.id.rb_property:
                        mCurrentPosition = 2;
                        break;
                    case R.id.rb_more:
                        mCurrentPosition = 3;
                        break;

                }
                Fragment fragment = mFragmentList.get(mCurrentPosition);
                changeFragment(fragment);
            }
        });

        mRgMain.check(R.id.rb_home);
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            if (fragment != mPreFragment) {

                if (fragment.isAdded()) {
                    if (mPreFragment != null) {
                        ft.hide(mPreFragment);
                    }

                    ft.show(fragment);
                } else {
                    if (mPreFragment != null) {
                        ft.hide(mPreFragment);
                    }

                    ft.add(R.id.fl_main, fragment);
                }
            }
        }

        mPreFragment = fragment;
        ft.commit();
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new InvertFragment());
        mFragmentList.add(new PropertyFragment());
        mFragmentList.add(new MoreFragment());
    }


    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
