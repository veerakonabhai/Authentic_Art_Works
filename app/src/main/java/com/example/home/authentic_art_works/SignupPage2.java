package com.example.home.authentic_art_works;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupPage2 extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    EditText dateOfBirth;
    Button submit;
    CheckBox terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page2);
        getSupportActionBar().hide();
        dateOfBirth= (EditText) findViewById(R.id.DoB);
        submit=(Button)findViewById(R.id.signup_submit);
        terms=(CheckBox)findViewById(R.id.TandC);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateOfBirth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpd=new DatePickerDialog(SignupPage2.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                DatePicker dp = dpd.getDatePicker();
                //Set the DatePicker minimum date selection to current date
                //dp.setMinDate(myCalendar.getTimeInMillis());//get the current day
                //dp.setMinDate(System.currentTimeMillis() - 1000);// Alternate way to get the current day

                //Add 6 days with current date
                myCalendar.add(Calendar.DAY_OF_MONTH,0);

                //Set the maximum date to select from DatePickerDialog
                dp.setMaxDate(myCalendar.getTimeInMillis());
                dpd.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(terms.isChecked()){
                    Toast.makeText(getApplicationContext(),"signed up",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please accept the terms and conditions",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

}

