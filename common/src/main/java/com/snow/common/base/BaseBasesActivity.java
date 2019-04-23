package com.snow.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.snow.common.R;
import com.snow.common.tool.bar.StatusNavBar;

import butterknife.ButterKnife;


/**
 * Created by zyt on 2018/10/12.
 * 项目最开始使用了baseActivity，为了统一处理又写了一个基类
 */

public abstract class BaseBasesActivity extends AppCompatActivity {
    protected boolean isStatusBar = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //设置状态栏透明度
        if (isStatusBar) {
            StatusNavBar.with(this).statusBarColor(R.color.transparent).statusBarDarkFont(true).navigationBarColor(R.color.black_degree_50).init();
        }
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
    }


    protected abstract int getContentViewId();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
