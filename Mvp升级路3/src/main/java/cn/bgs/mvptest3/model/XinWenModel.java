package cn.bgs.mvptest3.model;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Map;

import cn.bgs.mvptest3.base.BaseCallBack;
import cn.bgs.mvptest3.base.BaseModel;
import cn.bgs.mvptest3.utils.OkHttp3Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ${周康} on ${Study}.
 */

public class XinWenModel extends BaseModel<String> {

    @Override
    public void requestPostAPI(String url, Map params, final BaseCallBack<String> callBack) {
        OkHttp3Utils.getIantance ().postOkhttp ( url, params, new Callback () {
            @Override
            public void onFailure(Call call, IOException e) {

                callBack.onFailuer ( "请求失败:参数有误" );
                callBack.onComplete ();
                Log.e ( "XINWEN", e.getLocalizedMessage () + "222222" );

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful ()) {
                    String result = response.body ().string ().trim ();
                    Logger.e ( "XinWenModel", "~~~~~~" +result );
                    Log.e ( "XinWenModel", "~~~~~~" +result );

                    callBack.onSuccess ( result );
                } else {
                    callBack.onError ();

                }

                callBack.onComplete ();


            }
        } );
    }
}