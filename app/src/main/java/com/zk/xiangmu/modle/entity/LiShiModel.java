package com.zk.xiangmu.modle.entity;

import android.util.Log;

import com.zk.xiangmu.base.BaseCallBack;
import com.zk.xiangmu.base.BaseModel;
import com.zk.xiangmu.bean.LiShiInfo;
import com.zk.xiangmu.utils.RxUtils;

import java.util.Map;

import rx.functions.Action1;

/**
 * Created by Administrator on 2018/6/15 0015.
 * 做一个有高逼咯的马龙
 */

public class LiShiModel extends BaseModel<LiShiInfo> {
    public static final String TAG = "LiShiModel";


    @Override
    public void requestPostAPI(String url, Map params, final BaseCallBack<LiShiInfo> callBack) {
        RxUtils.getInstance().postUrl(url, params, new Action1() {
            @Override
            public void call(Object o) {
                if (o instanceof LiShiInfo) {
                    LiShiInfo liShiInfo = (LiShiInfo) o;
                    Log.e(TAG, "11111111111" + liShiInfo.toString());
                    if (liShiInfo == null) {
                        callBack.onError();
                    } else {
                        callBack.onSuccess(liShiInfo);

                    }
                }


                //                callBack.onComplete();
            }
        });

    }
}
