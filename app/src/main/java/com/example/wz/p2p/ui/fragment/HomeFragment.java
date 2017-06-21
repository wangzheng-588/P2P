package com.example.wz.p2p.ui.fragment;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wz.p2p.R;
import com.example.wz.p2p.bean.IndexBean;
import com.example.wz.p2p.common.config.AppNetConfig;
import com.example.wz.p2p.data.IndexModel;
import com.example.wz.p2p.presenter.IndexPresenter;
import com.example.wz.p2p.presenter.contract.IndexContract;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wz on 17-6-20.
 */

public class HomeFragment extends BaseFragment implements IndexContract.view{


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.iv_title)
    TextView mIvTitle;
    @BindView(R.id.iv_setting)
    ImageView mIvSetting;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.tv_home_product)
    TextView mTvHomeProduct;
    @BindView(R.id.tv_home_yearrate)
    TextView mTvHomeYearrate;
    private List<String> images;

    @Override
    protected int setLayoutResID() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initData() {

        IndexModel indexModel = new IndexModel();
        IndexPresenter indexPresenter = new IndexPresenter(indexModel, this);
        indexPresenter.getIndexData();
    }

    @Override
    public void showResult(IndexBean indexBean) {
        //设置主页banner
        setBanner(indexBean.getImageArr());

    }

    private void setBanner(List<IndexBean.ImageArrEntity> imageArr) {
        images = new ArrayList<>();
        for (int i = 0; i < imageArr.size(); i++) {
            images.add(AppNetConfig.BASE_URL+imageArr.get(i).getIMAURL());
            Log.e("TAG",AppNetConfig.BASE_URL+imageArr.get(i).getIMAURL());
        }
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

    }

    @Override
    public void showError(String error) {

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Picasso.with(context).load((String)path).into(imageView);
        }
    }

    @Override
    public void onDestroy() {
        if (mBanner!=null){
            mBanner.stopAutoPlay();
        }
        super.onDestroy();
    }
}
