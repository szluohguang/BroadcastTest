package com.example.luo.broadcasttest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private MyBroadcastReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button btSend = ( Button )findViewById( R.id.btSend) ;
        btSend.setOnClickListener( new Button.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( "com.example.luo.broadcasttest.MY_BROADCAST");
                intent.putExtra("tag", "testBroadcast");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction( "com.example.luo.broadcasttest.MY_BROADCAST");
        localReceiver = new MyBroadcastReceiver();
        localBroadcastManager.registerReceiver( localReceiver, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver( localReceiver );
    }
}
