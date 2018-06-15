package com.zk.xiangmu.base;

import java.util.Map;

/**
 * Created by ${周康} on ${Study}.
 */

public abstract class BaseModel<T>  {
//    protected String[] mParams;
//
//    public BaseModel params(String... args) {
//        mParams = args;
//        return this;
//    }

    //添加CallBack 并执行数据请求
    //具体的数据请求由子类实现
    //    public abstract void execute(Callback callBack);

    //    //执行Get网络请求，此类看需求由自己选择写与不写
    //    protected void requestGetAPI(String url, Map params,BaseCallBack callBack) {
    //        //这里写具体的网络请求
    //    }

    //执行Post网络请求，此类看需求由自己选择写与不写
    public abstract void requestPostAPI(String url, Map params, BaseCallBack<T> callBack);
    //这里写具体的网络请求


}
