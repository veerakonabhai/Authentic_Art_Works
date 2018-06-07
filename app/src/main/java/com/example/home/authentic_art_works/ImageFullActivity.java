package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ImageFullActivity extends AppCompatActivity {
ImageView img;
TextView tv1,tv2;
int image;
String title,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.download_button);
        Bundle b=getIntent().getExtras();
        if(b!=null){
            image=b.getInt("image");
            title=b.getString("title");
            desc=b.getString("desc");
        }
        img=(ImageView)findViewById(R.id.image_full);
        tv1=(TextView)findViewById(R.id.title_full);
        tv2=(TextView)findViewById(R.id.desc_full);
        String url="https://i.ndtvimg.com/i/2018-03/mahesh-babu-instagram_650x400_41521705026.jpg";
        Picasso.get()
                .load(url).placeholder(R.drawable.img2)
                .into(img);
        tv1.setText(title);
        tv2.setText(desc);
      //  Toast.makeText(getApplicationContext(),""+title+" "+desc,Toast.LENGTH_LONG).show();
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
