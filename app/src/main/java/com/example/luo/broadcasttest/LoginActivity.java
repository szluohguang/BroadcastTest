package com.example.luo.broadcasttest;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by luo on 2016/1/9.
 */
public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPassword;
    private Button btSubmit;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.login);

        etAccount = ( EditText) findViewById( R.id.edAccount);
        etPassword = ( EditText)findViewById( R.id.edPassword);
        btSubmit = ( Button )findViewById( R.id.btSubmit );

        btSubmit.setOnClickListener( new Button.OnClickListener() {
            @Override
            public void onClick( View v ) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                if( account.equals( "admin") && password.equals( "1234")) {
                    Intent intent = new Intent( LoginActivity.this, MainActivity.class );
                    startActivity( intent );
                    finish();
                }
                else {
                    Toast.makeText( LoginActivity.this, "Account or Password is invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
