package com.snow.practice;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.snow.common.base.BaseBasesActivity;
import com.snow.common.tool.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseBasesActivity {
    @BindView(R.id.text_view01)
    TextView textView01;
    @BindView(R.id.text_view02)
    TextView textView02;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ToastUtils.getInstance().showToast(textView02.getText().toString());
    }

    @OnClick({R.id.text_view01, R.id.text_view02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_view01:
               ToastUtils.getInstance().showToast(textView01.getText().toString());
                break;
            case R.id.text_view02:
                ToastUtils.getInstance().showToast(textView02.getText().toString());
                break;
        }
    }
}
