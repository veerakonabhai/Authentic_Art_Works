package com.example.home.authentic_art_works;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    String videourl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_video);
        VideoView myvideo=(VideoView)findViewById(R.id.vv);
        videourl="https://www.youtube.com/watch?v=2wGSKHW2PvI";
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(myvideo);
        myvideo.setMediaController(mediaController);
        myvideo.setVideoURI(Uri.parse(videourl));
        myvideo.start();
      /*  final MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(myvideo);*/


    }
}
