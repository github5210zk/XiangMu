package com.zk.xiangmu.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zk.xiangmu.R;
import com.zk.xiangmu.base.BaseFragment;
import com.zk.xiangmu.bean.LiShiInfo;
import com.zk.xiangmu.presenter.LiShiPresenter;
import com.zk.xiangmu.utils.ApiService;
import com.zk.xiangmu.view.LiShiView;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/15 0015.
 * 做一个有高逼咯的马龙
 */

public class Home_Fragment extends BaseFragment implements LiShiView {
    LiShiPresenter      presenter;
    Map<String, String> map;

    @Bind(R.id.nHome_tv)
    TextView nHomeTv;
    @Bind(R.id.nHome_bt)
    Button   nHomeBt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        initPresenter();
        initMap();
        return view;
    }

    private void initMap() {
        map = new HashMap<>();
        map.put("e_id", "5555");
        map.put("key", "8f6a291c4e722f29143086e48b04337c");
    }

    private void initPresenter() {
        presenter = new LiShiPresenter();
        presenter.attachView(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        presenter.detachView();
    }


    @OnClick(R.id.nHome_bt)
    public void onViewClicked() {
        presenter.getData(ApiService.URL, map);

    }


    @Override
    public void showData(final Object data) {
        //        LiShiInfo info= (LiShiInfo) data;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (data instanceof LiShiInfo) {
                    LiShiInfo liShiInfo = (LiShiInfo) data;
                    if (liShiInfo != null) {
                        nHomeTv.setText(liShiInfo.toString());
                    }
                }
            }
        });


    }
}
