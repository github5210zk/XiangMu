package com.zk.xiangmu.activitys;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.zk.xiangmu.R;
import com.zk.xiangmu.adapter.First_Vp_Adapter;
import com.zk.xiangmu.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class First_Activity extends BaseActivity {

    @Bind(R.id.mFirst_bg)
    TextView  mFirstBg;
    @Bind(R.id.mFirst_vp)
    ViewPager mFirstVp;
    First_Vp_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        initViewPager();


    }

    private void initViewPager() {

    }


}
