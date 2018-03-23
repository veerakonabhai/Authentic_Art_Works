package com.example.home.authentic_art_works;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
       // ActionBar actionbar = getActionBar();
        getSupportActionBar().setHomeButtonEnabled(true);
        login=(Button)findViewById(R.id.login_btn);
       // signup=(Button)findViewById(R.id.signup_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"logged in",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),HomeMainActivity.class);
                startActivity(i);
            }
        });
     /*   signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignupPage.class);
                startActivity(i);
            }
        });*/
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
