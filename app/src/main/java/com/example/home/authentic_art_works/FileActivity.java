package com.example.home.authentic_art_works;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Uri uri =Uri.parse("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf");
     /*   PDFView pdfview =(PDFView)findViewById(R.id.pdfView);
       pdfview.fromAsset("lesson2.pdf").load();*/
        //pdfview.fromUri(uri).load();

        //To display the pdf file inbuilt pdfviewer. Need to download file from url to sdcard
     /*   File filename = new File("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf");
        Uri path = Uri.fromFile(filename);
        Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
        pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfOpenintent.setDataAndType(path, "application/pdf");
        try {
            startActivity(pdfOpenintent);
        }
        catch (ActivityNotFoundException e) {

        }*/
       WebView webview1 = (WebView) findViewById(R.id.wv);
        webview1.getSettings().setJavaScriptEnabled(true);
        String filename = "http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf";
        webview1.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
