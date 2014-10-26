package com.sinch.android.rtc.sample.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.dolby.dap.DolbyAudioProcessing;
import com.dolby.dap.OnDolbyAudioProcessingEventListener;


import java.util.ArrayList;

public class LoginActivity extends Activity implements OnDolbyAudioProcessingEventListener {

    private EditText txtUsername;

    public static ArrayList<Profile> profiles = new ArrayList<Profile>();
    public static Profile login = new Profile();
    DolbyAudioProcessing mDolbyAudioProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtUsername = (EditText) findViewById(R.id.loginName);

        View btnLogin = findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        mDolbyAudioProcessing = DolbyAudioProcessing.getDolbyAudioProcessing(this, DolbyAudioProcessing.PROFILE.GAME, this);

        if (mDolbyAudioProcessing == null){
            //Toast.makeText(this, "Dolby isn't available on this device", Toast.LENGTH_SHORT).show();
            //finish();
            return;
        }

    }

    private void login() {

        String userName = txtUsername.getText().toString();

        if (userName.isEmpty()) {
            Toast.makeText(this, "Please enter a username", Toast.LENGTH_LONG).show();
            return;
        }
        Profile login = new Profile();
        login.setUserName(userName);
        System.out.println(login.getUserName());

        Intent sIntent = new Intent(LoginActivity.this, MessageService.class);
        sIntent.putExtra("intentExtraUsername", userName);
        startService(sIntent);

        Intent intent = new Intent(LoginActivity.this, Profile_Set_Up.class);
        startActivity(intent);
    }

    @Override
    public void onDolbyAudioProcessingClientConnected() {

    }

    @Override
    public void onDolbyAudioProcessingClientDisconnected() {

    }

    @Override
    public void onDolbyAudioProcessingEnabled(boolean b) {

    }

    @Override
    public void onDolbyAudioProcessingProfileSelected(DolbyAudioProcessing.PROFILE profile) {

    }
}
