package com.example.wz.p2p.presenter.contract;

import com.example.wz.p2p.bean.IndexBean;
import com.example.wz.p2p.ui.BaseView;

/**
 * Created by wz on 17-6-21.
 */

public class IndexContract  {

    public interface view extends BaseView{
        void showResult(IndexBean indexBean);
        void showError(String error);
    }
}
