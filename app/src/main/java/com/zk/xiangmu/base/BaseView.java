package com.zk.xiangmu.base;

import android.content.Context;

/**
 * Created by ${周康} on ${Study}.
 */

public interface BaseView {
    /**
     * 显示正在加载view
     */
    void showLoading();

    /**
     * 关闭正在加载view
     */
    void hideLoading();

    /**
     * 显示提示
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showErr();

    void showData(Object data);


    /**
     * 获取上下文
     *
     * @return
     */
    Context getContext();


}
