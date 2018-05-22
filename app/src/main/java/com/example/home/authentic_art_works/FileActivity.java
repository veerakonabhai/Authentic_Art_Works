package com.example.home.authentic_art_works;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
       // Uri uri =Uri.parse("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf");
     /*   PDFView pdfview =(PDFView)findViewById(R.id.pdfView);
       pdfview.fromAsset("lesson2.pdf").load();*/
        //pdfview.fromUri(uri).load();

        WebView webview1 = (WebView) findViewById(R.id.wv);
        webview1.getSettings().setJavaScriptEnabled(true);
        String filename = "http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf";
        webview1.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

    }
}
