package com.example.luo.broadcasttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by luo on 2016/1/9.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected  void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity( this );
    }
}
