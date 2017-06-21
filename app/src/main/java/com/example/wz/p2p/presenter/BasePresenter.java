package com.example.wz.p2p.presenter;

/**
 * Created by wz on 17-6-21.
 */

public class BasePresenter<M,V> {

    protected final M mModel;
    protected final V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
