package com.zk.xiangmu.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.hawk.Hawk;
import com.zk.xiangmu.R;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Welcome_Activity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Bind(R.id.mWelcome_gif)
    GifImageView mWelcomeGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        initGif();
    }

    /**
     * 初始化GIF
     */
    private void initGif() {
        //TODO 动态图片需注意OOM
        //温馨提示：GifDrawable 设置静态图片的话会报null point 异常
        GifDrawable gifFromResource = null;
        try {
            gifFromResource = new GifDrawable(getResources(), R.drawable.welcome_gif);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置动画的播放速度
        gifFromResource.setSpeed(1.0f);

        mWelcomeGif.setImageDrawable(gifFromResource);
        GifDrawable gifDrawable = null;

        //默认false
        boolean flag = Hawk.get("MAIN_ACTIVITY", false);
        //true 跳转到 主页面   false跳转到 首次安装界面
        if (flag) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Welcome_Activity.this, Main_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);


        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Welcome_Activity.this, First_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);

        }

    }
}
