package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class UpdatesActivity extends AppCompatActivity {

    String title,desc,date,url;
    int likes,shares,image,id;

    TextView tv1,tv2,tv3,tv4,tv5;
    ImageView iv1;
    WebView pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id=extras.getInt("id");
            title=extras.getString("title");
            desc=extras.getString("description");
            date=extras.getString("date");
            likes=extras.getInt("likescount");
            shares=extras.getInt("sharecount");
            if(id==1)
              image=extras.getInt("image");
            else if(id==2)
                url=extras.getString("pdf");
            //The key argument here must match that used in the other activity
        }
        tv1=(TextView)findViewById(R.id.title);
        tv2=(TextView)findViewById(R.id.desc_updates);
        tv3=(TextView)findViewById(R.id.like_count);
        tv4=(TextView)findViewById(R.id.share_cnt);
        tv5=(TextView)findViewById(R.id.date);
        iv1=(ImageView)findViewById(R.id.img_src);
        pdf=(WebView)findViewById(R.id.webview);

        tv1.setText(title);
        tv2.setText(desc);
        tv3.setText(" "+likes);
        tv4.setText(" "+shares);
        tv5.setText(date);
        if(id==1) {
            iv1.setImageResource(image);
            pdf.setVisibility(View.INVISIBLE);
        }
        else if(id==2) {
            pdf.getSettings().setJavaScriptEnabled(true);
            pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
            iv1.setVisibility(View.INVISIBLE);
        }
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
