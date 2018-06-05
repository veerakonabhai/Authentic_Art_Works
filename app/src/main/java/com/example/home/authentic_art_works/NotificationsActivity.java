package com.example.home.authentic_art_works;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NotificationsActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<NotificationsAdapter.Notification> notifications;
    NotificationsAdapter adapter;
    NotificationsAdapter.Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv=(ListView)findViewById(R.id.lvinnotifi);
        notifications=new ArrayList<>();
        notification=new NotificationsAdapter.Notification("Ganesh","Helllo your app has to be updated buddy.");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Veera","Helllo your app has to be updated buddy.No need waste fellow keep it");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Doctor Strange","Helllo your app has to be updated buddy.Very strange behaviour");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Ganesh","Helllo your app has to be updated buddy.");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Ganesh","Helllo your app has to be updated buddy.");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Ganesh","Helllo your app has to be updated buddy.");
        notifications.add(notification);
        notification=new NotificationsAdapter.Notification("Ganesh","Helllo your app has to be updated buddy.");
        notifications.add(notification);
        adapter=new NotificationsAdapter(this,notifications);
        lv.setAdapter(adapter);
    }
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
class NotificationsAdapter extends BaseAdapter{

    static class Notification{
        String name,msg;

        public Notification(String name,String msg){
            this.name=name;
            this.msg=msg;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }


    ArrayList<Notification> notifications;
    Notification notification;
    LayoutInflater inflater;
    Context mcontext;
    TextView tv1,tv2;

    NotificationsAdapter(Context mcontext,ArrayList<Notification> notifications){
        this.mcontext=mcontext;
        this.notifications=notifications;
    }
    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int position) {
        return notifications.get(position);
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
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.notifications, parent, false);
        }
        tv1=(TextView)convertView.findViewById(R.id.name_notification);
        tv2=(TextView)convertView.findViewById(R.id.notification);
        notification=notifications.get(position);
        tv1.setText(notification.getName());
        tv2.setText(notification.getMsg());
        return convertView;
    }
}