package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MediaImagesActivity extends AppCompatActivity {
    GridView gv;
    ArrayList<ActivityAdapter.Image> images;
    ActivityAdapter adapter;
    ActivityAdapter.Image image;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_media_images);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//setHomeButtonEnabled(true);
        gv=(GridView)findViewById(R.id.gv3);
        images=new ArrayList<>();
        image=new ActivityAdapter.Image(R.drawable.img1,"scenery","Its in AlASKA");
        images.add(image);
        image=new ActivityAdapter.Image(R.drawable.img3,"SCENIC BEAUTY","SOUTHAFRICA");
        images.add(image);
        image=new ActivityAdapter.Image(R.drawable.img1,"nono","yes yes");
        images.add(image);
        image=new ActivityAdapter.Image(R.drawable.img2,"daniel bryan","yesyes man");
        images.add(image);
        image=new ActivityAdapter.Image(R.drawable.img3,"undertaker","deadman");
        images.add(image);
        image=new ActivityAdapter.Image(R.drawable.img2,"randy orton","viper");
        images.add(image);
        adapter=new ActivityAdapter(getApplicationContext(),images);
        gv.setAdapter(adapter);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
class ActivityAdapter extends BaseAdapter{

    public static class Image{
        int id;
        String title,desc;
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        Image(int id,String title,String desc){
            this.title=title;
            this.id=id;
            this.desc=desc;
        }
    }
    ArrayList<Image> values;
    Image image;
    Context mcontext;
    LayoutInflater inflater;
    ImageView iv;
    ActivityAdapter(Context mcontext, ArrayList<Image> values){
        this.mcontext=mcontext;
        this.values=values;
    }
    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.media_images_layout,parent,false);
        }
        iv=(ImageView)convertView.findViewById(R.id.iv1);
        image=values.get(position);

        iv.setImageResource(image.getId());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(mcontext,"Hello Image",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("https://i.ndtvimg.com/i/2018-03/mahesh-babu-instagram_650x400_41521705026.jpg"), "image/*");
               */
                Intent intent = new Intent(mcontext,ImageFullActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("image",image.getId());
                intent.putExtra("title",image.getTitle());
                intent.putExtra("desc",image.getDesc());
                Toast.makeText(mcontext, ""+image.getTitle()+" "+image.getDesc(), Toast.LENGTH_SHORT).show();
                mcontext.startActivity(intent);

              //  Intent i=new Intent(mcontext,ImageActivity.class);
              //  mcontext.startActivity(i);
            }
        });
        return convertView;
    }
}
