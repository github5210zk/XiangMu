package com.zk.xiangmu.utils;

import com.zk.xiangmu.bean.LiShiInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2018/6/14 0014.
 * 做一个有高逼咯的马龙
 * <p>
 * <p>
 * 保存 参数的 接口
 */

public interface ApiService {
    String BASE_URL = "http://v.juhe.cn/";
    String URL      = "todayOnhistory/queryDetail.php";


    @POST("{request}") //请求方式 标识  ,在正常的开发中， 后台会给你一个接口地址，括号里面可以用｛Test｝取代快 搭配@Path 动态使用
    //简单的表单形式
    @FormUrlEncoded
    Observable<LiShiInfo> postTestInfo(@Path("request") String request, @FieldMap Map<String, String> hashMap);


}
