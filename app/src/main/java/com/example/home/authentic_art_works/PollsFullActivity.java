package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class PollsFullActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    ImageView iv1;
    String title,desc,option1,option2;
    int progress1,progress2,image;
    RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polls_full);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv1=(TextView)findViewById(R.id.title_poll_full1);
        tv2=(TextView)findViewById(R.id.desc_poll_full1);
        tv3=(TextView)findViewById(R.id.text_full_progress11);
        tv4=(TextView)findViewById(R.id.text_full_progress21);
        iv1=(ImageView)findViewById(R.id.img_poll_full1);
        rb1=(RadioButton)findViewById(R.id.radio_options1);
        rb2=(RadioButton)findViewById(R.id.radio_options2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title=extras.getString("title");
            desc=extras.getString("description");
            option1=extras.getString("option1");
            option2=extras.getString("option2");
            progress1=extras.getInt("progress1");
            progress2=extras.getInt("progress2");
            image=extras.getInt("image");
            //The key argument here must match that used in the other activity
        }

        tv1.setText(title);
        tv2.setText(desc);
        rb1.setText(option1);
        rb2.setText(option2);
        tv3.setText(""+progress1);
        tv4.setText(""+progress2);
        iv1.setImageResource(image);

    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
