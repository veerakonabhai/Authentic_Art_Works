package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageFullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.download_button);
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
