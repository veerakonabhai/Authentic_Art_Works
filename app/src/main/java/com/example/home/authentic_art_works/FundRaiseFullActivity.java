package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FundRaiseFullActivity extends AppCompatActivity {

    String title,desc,startdate,enddate;
    int image,percent,raisedamt,targetamt;

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    ImageView iv1;
    ProgressBar ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_raise_full);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv1=(TextView)findViewById(R.id.title_funds_full);
        tv2=(TextView)findViewById(R.id.desc_funds_full);
        tv3=(TextView)findViewById(R.id.date_start_funds_full);
        tv4=(TextView)findViewById(R.id.date_end_funds_full);
        tv5=(TextView)findViewById(R.id.raised_amount_full);
        tv6=(TextView)findViewById(R.id.target_amount_full);
        iv1=(ImageView)findViewById(R.id.img_funds_full);
        ps=(ProgressBar)findViewById(R.id.fund_meter_full);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            image=extras.getInt("image");
            title=extras.getString("title");
            desc=extras.getString("desc");
            startdate=extras.getString("startdate");
            enddate=extras.getString("enddate");
            percent=extras.getInt("percent");
            raisedamt=extras.getInt("raisedamt");
            targetamt=extras.getInt("targetamt");
            //The key argument here must match that used in the other activity
        }

        tv1.setText(title);
        tv2.setText(desc);
        tv3.setText("starts on: "+startdate);
        tv4.setText("ends on: "+enddate);
        tv5.setText(""+raisedamt);
        tv6.setText(""+targetamt);
        iv1.setImageResource(image);
        ps.setProgress(percent);
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
