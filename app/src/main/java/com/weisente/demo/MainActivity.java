package com.weisente.demo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weisente.demo.base.Constants;
import com.weisente.demo.util.ShellUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShellUtil.execCommand("am force-stop " +Constants.TARGET_PACKAGE_NAME,true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ShellUtil.execCommand("am start " + "com.zhihu.android/.app.ui.activity.LauncherActivity",true);
            }
        },100);


    }
}
