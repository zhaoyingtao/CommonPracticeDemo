package com.snow.practice;

import android.os.Environment;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2019/2/21
 * desc   :
 */

public interface AppConstant {
    String LOCAL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/Android/data/com.snow.practice/";

    //请求域名
    String base_url = "https://www.baidu.com/";
    //是否是debug调试模式
    boolean is_debug = true;
}
