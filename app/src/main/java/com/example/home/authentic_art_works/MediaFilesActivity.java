package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MediaFilesActivity extends AppCompatActivity {
    ActivityFilesAdapter adapter;
    ActivityFilesAdapter.File media;
    ArrayList<ActivityFilesAdapter.File> values;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_files);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        view=inflater.from(getActivity()).inflate(R.layout.fragment_media_files, container, false);
        values=new ArrayList<>();
        media=new ActivityFilesAdapter.File("veera",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("john cena",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("undertaker",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("roman reigns",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("ganesh",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("kaushik",R.drawable.pdf);
        values.add(media);
        media=new ActivityFilesAdapter.File("brock lesnar",R.drawable.pdf);
        values.add(media);

        lv=(ListView)findViewById(R.id.lvinfiles);
        adapter=new ActivityFilesAdapter(this,values);
        lv.setAdapter(adapter);

    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
class ActivityFilesAdapter extends BaseAdapter {

    public static class File{
        String title;
        int image;

        public File(String title,int img){
            this.title=title;
            this.image=img;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    ArrayList<File> media;
    Context mcontext;
    LayoutInflater inflater;
    TextView tv1;
    ImageView img;

    public ActivityFilesAdapter(Context mc,ArrayList<ActivityFilesAdapter.File> media){
        this.mcontext=mc;
        this.media=media;

    }
    @Override
    public int getCount() {
        return media.size();
    }

    @Override
    public Object getItem(int i) {
        return media.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.media_files_layout,parent,false);
        }
        tv1=(TextView)convertView.findViewById(R.id.title);
        img=(ImageView)convertView.findViewById(R.id.folder_icon);
        final File m=media.get(position);
        tv1.setText(m.getTitle());
        img.setImageResource(m.getImage());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"Hello media",Toast.LENGTH_LONG).show();
                Intent i=new Intent(mcontext,FileActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);
            }
        });
        return convertView;
    }
}