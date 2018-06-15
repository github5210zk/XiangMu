package com.zk.xiangmu.presenter;

import android.util.Log;

import com.zk.xiangmu.base.BaseCallBack;
import com.zk.xiangmu.base.BasePresenter;
import com.zk.xiangmu.bean.LiShiInfo;
import com.zk.xiangmu.modle.DataModel;
import com.zk.xiangmu.modle.Token;
import com.zk.xiangmu.view.LiShiView;

import java.util.Map;

import static com.zk.xiangmu.modle.entity.LiShiModel.TAG;

/**
 * Created by Administrator on 2018/6/15 0015.
 * 做一个有高逼咯的马龙
 */

public class LiShiPresenter extends BasePresenter<LiShiView> {
    public LiShiPresenter() {
        //构造器不需要任何参数
    }

    public void getData(String url, Map map) {
        final LiShiView view = getView();
        //        view.showLoading();
        DataModel.request(Token.API_XINWEN_DATA)
                .requestPostAPI(url, map, new BaseCallBack<LiShiInfo>() {
                    @Override
                    public void onSuccess(LiShiInfo data) {
                        Log.e(TAG, "call: "+data.toString() );
                    Object o=data;
                        if (isViewAttached())
                            view.showData(o);
                    }

                    @Override
                    public void onFailuer(LiShiInfo msg) {
                        if (isViewAttached())
                            view.showToast(msg.toString());
                    }


                    @Override
                    public void onError() {
                        if (isViewAttached())
                            view.showErr();
                    }

                    @Override
                    public void onComplete() {
                        //                        if (isViewAttached())
                        //                            view.hideLoading();
                    }
                });

    }
}
