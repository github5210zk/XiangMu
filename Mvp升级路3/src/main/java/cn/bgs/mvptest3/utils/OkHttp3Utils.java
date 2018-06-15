package cn.bgs.mvptest3.utils;

import com.google.gson.Gson;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * httpGet()中拼接请求URL - CSDN博客
 * http://blog.csdn.net/qq_26222859/article/details/47261735
 * okhttp3 工具类
 */

public class OkHttp3Utils {
    /**
     * 需要定义至少两个方法
     * get
     * post
     * 去获取数据
     * 需要使用单列模式去把我这个类实列化
     */
    private static OkHttp3Utils mOk3;
    private OkHttpClient ok;
    public static Gson gson;


    private OkHttp3Utils() {
        //创建真正的操作类 OkHttpClient
        if (ok == null) {
            ok = new OkHttpClient
                    .Builder ()
                    .connectTimeout ( 5, TimeUnit.SECONDS )
                    .readTimeout ( 10, TimeUnit.SECONDS )
                    .build ();

            //            gson = new Gson ();
        }
    }

    public static OkHttp3Utils getIantance() {
        //双重判断+ 同步线程锁
        if (mOk3 == null) {
            synchronized (OkHttp3Utils.class) {
                if (mOk3 == null) {
                    mOk3 = new OkHttp3Utils ();
                }
            }
        }
        return mOk3;
    }

    public void postOkhttp(String url, Map<String, String> map, Callback callBack) {
        //上传文字格式 数据的传输，区别于多媒体输出
        FormBody.Builder formbody = new FormBody.Builder ();
        if (map != null && !map.isEmpty ()) {
            //上传参数
            for (String key : map.keySet ()) {
                formbody.add ( key, map.get ( key ) );
            }
            //创建请求体
            FormBody body = formbody.build ();
            Request request = new Request.Builder ()
                    .url ( url )
                    .post ( body )//请求体
                    .build ();
            Call call = ok.newCall ( request );
            //异步请求方式
            call.enqueue ( callBack );
        } else {
            //创建请求体
            FormBody body = formbody.build ();
            Request request = new Request.Builder ()
                    .url ( url )
                    .post ( body )
                    .build ();
            Call call = ok.newCall ( request );
            //异步请求方式
            call.enqueue ( callBack );
        }
    }


}
