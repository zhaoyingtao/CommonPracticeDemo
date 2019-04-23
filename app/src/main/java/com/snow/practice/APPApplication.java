package com.snow.practice;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.snow.common.CommonLibConstant;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2018/12/22
 * desc   :
 */

public class APPApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        //今日头条适配配置
        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false)
                .setSupportSubunits(Subunits.NONE);
        //common依赖库的相关初始化
        CommonLibConstant.init()
                .setAppContext(this)
                .setIsDebug(AppConstant.is_debug)
                .setNoNetWorkRemind("无网络")
                //存储权限别忘了
                .setSharedPreferencesName("practice_db")
                .setCrashSavePath(AppConstant.LOCAL_PATH)
                .setExternalNetworkIP();//要设置这个必有连网权限
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
