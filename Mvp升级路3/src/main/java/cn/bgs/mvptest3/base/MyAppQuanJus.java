package cn.bgs.mvptest3.base;


import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import cn.bgs.mvptest3.BuildConfig;

/**
 * Created by ${周康} on ${Study}.
 */

public class MyAppQuanJus extends Application {
    private static final String TAG = "APPLOG";
    @Override
    public void onCreate() {
        super.onCreate ();
        //初始化Logger
        initLogger ( TAG );

    }
    private void initLogger(String tag) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder ()
                .showThreadInfo ( false )  // 是否显示线程信息，默认 显示
                .methodCount ( 0 )         // 方法栈打印的个数，默认是 2
                .methodOffset ( 7 )        // 设置调用堆栈的函数偏移值，默认是 5
                .logStrategy ( null ) // 设置log打印策略，默认是 LogCat
                .tag ( tag )   // 设置全局TAG，默认是 PRETTY_LOGGER
                .build ();
        Logger.addLogAdapter ( new AndroidLogAdapter ( formatStrategy ) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        } );


    }
}
