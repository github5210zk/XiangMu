package cn.bgs.mvptest3.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import cn.bgs.mvptest3.R;


/**
 * Created by ${周康} on ${Study}.
 */

public class BaseActivity extends Activity implements BaseView {
    //进度条
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        //初始化进度条
        mProgressDialog = new ProgressDialog ( this );
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
        runOnUiThread ( new Runnable () {
            @Override
            public void run() {
                Toast.makeText ( getContext (), msg, Toast.LENGTH_SHORT ).show ();
            }
        } );

    }

    @Override
    public void showErr() {
        runOnUiThread ( new Runnable () {
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
    public void showData(String data) {
    }
}
