package com.example.wz.p2p.presenter;

import com.example.wz.p2p.bean.IndexBean;
import com.example.wz.p2p.data.IndexModel;
import com.example.wz.p2p.presenter.contract.IndexContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wz on 17-6-21.
 */

public class IndexPresenter extends BasePresenter<IndexModel,IndexContract.view> {
    public IndexPresenter(IndexModel indexModel, IndexContract.view view) {
        super(indexModel, view);
    }

    public void getIndexData(){
        mModel.getIndexData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IndexBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(IndexBean value) {
                        mView.showResult(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
