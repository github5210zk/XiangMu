package cn.bgs.mvptest3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import cn.bgs.mvptest3.base.BaseActivity;
import cn.bgs.mvptest3.presenter.XinWenPresenter;
import cn.bgs.mvptest3.utils.UrlHttpUtils;
import cn.bgs.mvptest3.view.XinWenView;

public class MainActivity extends BaseActivity implements XinWenView {


    //    private ListView mListview;
    private TextView mTextview;
    private Button mButton;
    XinWenPresenter presenter;
    Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.tv_main );
        initView ();
        initPresenter ();
        initMap ();
        initOnClick ();

    }

    private void initPresenter() {
        presenter = new XinWenPresenter ();
        presenter.attachView ( this );

    }

    private void initMap() {
        map = new HashMap<> ();
        map.put ( "type", "yule" );
        map.put ( "key", "d05b58fa6901ad9bed77a1ef08bd6ccb" );
    }

    private void initOnClick() {
        mButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                presenter.getData ( UrlHttpUtils.HTTP, map );

            }
        } );
    }

    @Override
    public void showData(final String data) {
        runOnUiThread ( new Runnable () {
            @Override
            public void run() {
                mTextview.setText ( data );
            }
        } );


    }

    private void initView() {
        //        mListview = findViewById ( R.id.mListView );
        mTextview = findViewById ( R.id.mTextview );
        mButton = findViewById ( R.id.mButton );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        presenter.detachView ();
    }
}
