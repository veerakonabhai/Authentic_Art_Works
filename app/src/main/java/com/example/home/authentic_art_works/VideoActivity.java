package com.example.home.authentic_art_works;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
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
        myvideo.setVideoURI(Uri.parse(videourl));
        myvideo.start();
        String id="2wGSKHW2PvI";
    //    public static void watchYoutubeVideo(Context context, String id){
            Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=2wGSKHW2PvI"));
            try {
                startActivity(appIntent);
            } catch (Exception ex) {
                Toast.makeText(this,"exception raised dude",Toast.LENGTH_LONG).show();
                startActivity(webIntent);
            }

      /*  final MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(myvideo);*/


    }
}
