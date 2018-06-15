package com.zk.xiangmu.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zk.xiangmu.R;


/**
 * Created by ${周康} on ${Study}.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {
    //进度条
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        //初始化进度条
        mProgressDialog = new ProgressDialog( this );
        mProgressDialog.setCancelable ( false );
        mProgressDialog.setMessage ( "正在加载数据" );
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing ()) {
            mProgressDialog.show ();
        }
    }

    @Override
    protected void onResume() {
        super.onResume ();
        //        hideLoading();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing ()) {
            mProgressDialog.dismiss ();
        }

    }

    @Override
    public void showToast(final String msg) {
        runOnUiThread ( new Runnable() {
            @Override
            public void run() {
                Toast.makeText ( getContext (), msg, Toast.LENGTH_SHORT ).show ();
            }
        } );

    }

    @Override
    public void showErr() {
        runOnUiThread ( new Runnable() {
            @Override
            public void run() {
                showToast ( getResources ().getString ( R.string.api_error_msg ) );

            }
        } );
    }


    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    @Override
    public void showData(Object data) {
    }
}
