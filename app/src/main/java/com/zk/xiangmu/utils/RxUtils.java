package com.zk.xiangmu.utils;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/14 0014.
 * 做一个有高逼咯的马龙
 * <p>
 * 这个 管理类 是为了 对 RxZkUtils 进行初始化的操作
 */

public class RxUtils {
    private       ApiService apiService;
    private final Retrofit   retrofit;

    //恶汉式
    private static class RxManger {
        private volatile static RxUtils INSTANCE = new RxUtils();
        //        private  static fianl RxUtils RX_MANAGER = new RxUtils();
    }

    //私有化构造器
    private RxUtils() {
        //创建Retrofit
        retrofit = new Retrofit
                .Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASE_URL)
                .build();
        //可以添加拦截器等等。。。。。
        apiService = retrofit.create(ApiService.class);

    }

    /*
    获取实列
     */
    public static RxUtils getInstance() {

        return RxManger.INSTANCE;
    }


    public void postUrl(String url, Map map, Action1 action1) {
        Observable observable = apiService.postTestInfo(url, map);
        observable
                .subscribeOn(Schedulers.io())
                //                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1);
    }


}
