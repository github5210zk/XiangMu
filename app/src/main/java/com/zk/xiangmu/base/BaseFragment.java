package com.zk.xiangmu.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.zk.xiangmu.R;

/**
 * Created by Administrator on 2018/6/15 0015.
 * 做一个有高逼咯的马龙
 */

public class BaseFragment extends Fragment implements BaseView {
    //进度条
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化进度条
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("正在加载数据");
    }

    //    @Nullable
    //    @Override
    //    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //        //初始化进度条
    //        mProgressDialog = new ProgressDialog(getActivity());
    //        mProgressDialog.setCancelable(false);
    //        mProgressDialog.setMessage("正在加载数据");
    //        return super.onCreateView(inflater, container, savedInstanceState);
    //    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideLoading();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    @Override
    public void showToast(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showErr() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(getResources().getString(R.string.api_error_msg));

            }
        });
    }

    @Override
    public void showData(Object data) {
        
    }


    @Override
    public Context getContext() {
        return BaseFragment.this.getActivity();
    }



}
