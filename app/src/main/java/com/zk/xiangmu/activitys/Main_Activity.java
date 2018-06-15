package com.zk.xiangmu.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.orhanobut.hawk.Hawk;
import com.zk.xiangmu.R;
import com.zk.xiangmu.fragment.Home_Fragment;
import com.zk.xiangmu.fragment.Mine_Fragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main_Activity extends AppCompatActivity {

    @Bind(R.id.mMain_content)
    FrameLayout     mMainContent;
    @Bind(R.id.mMain_host)
    FragmentTabHost mMainHost;
    @Bind(R.id.mMain_rb)
    RadioButton     mMainRb;
    @Bind(R.id.mMain_rb2)
    RadioButton     mMainRb2;
    @Bind(R.id.mMain_rg)
    RadioGroup      mMainRg;


    private Class fragments[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initHawk();
        initView();
        initClick();
    }

    private void initClick() {
    }

    private void initView() {
        fragments = new Class[]{Home_Fragment.class, Mine_Fragment.class};
        //tabHost关联上下文，FragmentManager和显示区域
        mMainHost.setup(this, getSupportFragmentManager(), R.id.mMain_content);
        for (int i = 0; i < fragments.length; i++) {   //向TabHost中添加fragment和标志位
            TabHost.TabSpec tabSpec = mMainHost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));
            mMainHost.addTab(tabSpec, fragments[i], null);
        }
        mMainHost.setCurrentTab(0);//设置初始选中项
        mMainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mMain_rb:
                        mMainHost.setCurrentTab(0);
                        break;
                    case R.id.mMain_rb2:
                        mMainHost.setCurrentTab(1);
                        break;


                }
            }
        });
    }

    private void initHawk() {
        Hawk.put("MAIN_ACTIVITY", true);
    }


}
