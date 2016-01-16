package com.example.luo.broadcasttest;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by luo on 2016/1/9.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive( final Context context, Intent intent ) {
 //       Toast.makeText( context, "Receive: " + intent.getStringExtra("tag"), Toast.LENGTH_SHORT).show();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder( context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();
                        Intent intent2 = new Intent(context, LoginActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent2);
                    }
                }
        );
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
