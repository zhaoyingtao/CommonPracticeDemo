[ ![Download](https://api.bintray.com/packages/zhaoyingtao/maven/basetools_lib/images/download.svg) ](https://bintray.com/zhaoyingtao/maven/basetools_lib/_latestVersion)


经常写demo需要写很多重复代码和基本配置，为了简化引入下面库吧   

简单适用方法：以下三步是必须写的，否则会出问题   

1、在app的build.gradle添加如下代码：   
```
android {
    //支持java1.8
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
dependencies {
 api 'com.bintray.library:basetools_lib:1.0.0'
 }
```
2、在AndroidManifest.xml中配置   
```
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
  
   <application>
  <!--今日头条适配尺寸配置-->
        <meta-data
            android:name="design_width_in_dp"
            android:value="375" />
        <meta-data
            android:name="design_height_in_dp"
            android:value="667" />
    </application>
  
```

3、写APPApplication类     
```
public class APPApplication extends MultiDexApplication {
   private String LOCAL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
              + "/Android/data/com.snow.practice/";

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
                  .setNoNetWorkRemind("无网络")
                  //存储权限别忘了
                  .setSharedPreferencesName("card_db")
                  .setCrashSavePath(LOCAL_PATH)
                  .setExternalNetworkIP();//要设置这个必有连网权限
      }

      @Override
      protected void attachBaseContext(Context base) {
          super.attachBaseContext(base);
          MultiDex.install(this);
      }
}
```
