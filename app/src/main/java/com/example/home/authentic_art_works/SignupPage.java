package com.example.home.authentic_art_works;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rilixtech.CountryCodePicker;

public class SignupPage extends AppCompatActivity {
   Button OtpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        getSupportActionBar().hide();
        OtpButton=(Button)findViewById(R.id.otp_btn);


    }
    public void onButton(View v){


                CountryCodePicker ccp;
                AppCompatEditText edtPhoneNumber;



                ccp = (CountryCodePicker) findViewById(R.id.ccp);
                edtPhoneNumber = (AppCompatEditText) findViewById(R.id.phone_number_edt);



                ccp.registerPhoneNumberTextView(edtPhoneNumber);
                String countrycode=ccp.getSelectedCountryCode();
                String country=ccp.getSelectedCountryName();
                String phone=ccp.getFullNumber();
                if(ccp.isValid()) {
                    Toast.makeText(getApplicationContext(), "" + country + " " + countrycode + " " + phone, Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),SignupPage2.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter valid number", Toast.LENGTH_LONG).show();
                }


    }
}
