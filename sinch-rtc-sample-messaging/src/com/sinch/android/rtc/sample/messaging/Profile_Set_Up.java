package com.sinch.android.rtc.sample.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Profile_Set_Up extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__set__up);
        EditText name = (EditText) findViewById(R.id.editText);
        RadioButton male = (RadioButton) findViewById(R.id.radioButton);
        RadioButton female = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton NA = (RadioButton) findViewById(R.id.radioButton3);
        EditText age = (EditText) findViewById(R.id.editText2);
        EditText hometown = (EditText) findViewById(R.id.editText3);
        Button done = (Button) findViewById(R.id.button);

        LoginActivity.login.setName(name.toString());
        if(male.isChecked())
        {
            LoginActivity.login.setGender(0);
        } // end if
        else if(female.isChecked()){
            LoginActivity.login.setGender(1);
        }
        else{
            LoginActivity.login.setGender(2);
        }
        //LoginActivity.login.setAge(Integer.parseInt(age.toString()));
        LoginActivity.login.setAge(13);
        LoginActivity.login.setTown(hometown.toString());
        LoginActivity.profiles.add(LoginActivity.login);

        final Intent intent = new Intent(this, MyFeed.class);
        //final Intent intent = new Intent(this, MessageService.class);
        //intent.putExtra(MessageService.INTENT_EXTRA_USERNAME, LoginActivity.login.getUserName());
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // move onto homepage
                //startService(intent);
                startActivity(intent);
            }
        }) ;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile__set__up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
