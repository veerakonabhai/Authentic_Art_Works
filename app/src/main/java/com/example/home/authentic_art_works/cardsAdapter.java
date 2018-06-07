package com.example.home.authentic_art_works;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by home on 18-Mar-18.
 */

public class cardsAdapter extends BaseAdapter{
    private Context mcontext;
    private ArrayList<card> cardlist;
    public TextView title,notifNo,updateNo;
    public ImageView cardimg,menu,notification,logo;

    /*public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,notifNo,updateNo,desc;
        public ImageView cardimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.title_card);
            desc =(TextView)itemView.findViewById(R.id.text_card);
            cardimg=(ImageView)itemView.findViewById(R.id.img_card);
        }
    }*/

    public cardsAdapter(Context mcontext, ArrayList<card> cardlist){
        this.mcontext=mcontext;
        this.cardlist=cardlist;
    }
/*
    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mcontext)
                .inflate(R.layout.card_home, parent, false);

        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        Log.d("onbindView","displayiing card");
        card album = cardlist.get(position);
        holder.title.setText(album.getTitle());
        holder.desc.setText(album.getDescription() + " songs");
        try {
            Glide.with(mcontext).load(album.getImage()).into(holder.cardimg);
        }
        catch (Exception e){
            Log.d("in bind view","error inflatinng image");
        }
    }



    @Override
    public int getItemCount()
    {
        int arr = 0;
        try{
            if (cardlist.size()==0){
                arr=0;
            }
            else{
                arr=cardlist.size();
            }
        }catch (Exception e){

        }
        return arr;
    }
*/

    @Override
    public int getCount() {
        return cardlist.size();
    }

    @Override
    public Object getItem(int i) {
        return cardlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //card c=(card)this.getItem(i);
        final int position=i;
        View itemView=view;

            itemView=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_home, viewGroup, false);

        title =(TextView)itemView.findViewById(R.id.title_card);
        //desc =(TextView)itemView.findViewById(R.id.text_card);
        cardimg=(ImageView)itemView.findViewById(R.id.img_card);
      //  notifimg=(ImageView)view.findViewById(R.id.notification);
      //  updateimg=(ImageView)view.findViewById(R.id.update);
        notifNo=(TextView)itemView.findViewById(R.id.notification_count);
        menu=(ImageView)itemView.findViewById(R.id.menu);
        notification=(ImageView)itemView.findViewById(R.id.notification);
        logo=(ImageView)itemView.findViewById(R.id.admin);
        Picasso.get()
                .load(cardlist.get(i).getLogo()).placeholder(R.drawable.img2)
                .into(logo);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mcontext,NotificationsActivity.class);
                //put that particular grid identity
                mcontext.startActivity(i);
            }
        });
        title.setText(cardlist.get(i).getTitle());
      //  desc.setText(cardlist.get(i).getDescription() + " songs");
        cardimg.setImageResource(cardlist.get(i).getImage());
        if(cardlist.get(i).getNumberNotification()==0){
            notifNo.setVisibility(View.GONE);
        }
        else{
            notifNo.setText(""+cardlist.get(i).getNumberNotification());
        }
        updateNo=(TextView)itemView.findViewById(R.id.updates_count);
        if(cardlist.get(i).getNumberUpdate()==0){
            updateNo.setVisibility(View.GONE);
        }
        else{
            updateNo.setText(""+cardlist.get(i).getNumberUpdate());
        }
        /*setting up widgets when user long presses the image*/

        cardimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"HELLO"+position,Toast.LENGTH_LONG).show();

                    Intent i=new Intent(mcontext,IndividualActivity.class);
                    i.putExtra("grid position",position);
                    mcontext.startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a popup menu
                Toast.makeText(mcontext,"you are clicking",Toast.LENGTH_SHORT).show();
                PopupMenu popup = new PopupMenu(mcontext, menu);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.card_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.hide:
                                //handle menu1 click
                                Toast.makeText(mcontext,"Hide",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.remove:
                                //handle menu2 click
                                Toast.makeText(mcontext,"Remove",Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
                popup.show();
             //   showPopupMenu(menu);
                /*
                PopupMenu popup = new PopupMenu(mcontext, menu);
                //inflating menu from xml resource
                popup.inflate(R.menu.card_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.hide:
                                //handle menu1 click
                                Toast.makeText(mcontext,"Hide",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.remove:
                                //handle menu2 click
                                Toast.makeText(mcontext,"Remove",Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();*/

            }
        });



                /*
                Code to implement widgets
                ShortcutManager shortcutManager;
                shortcutManager = getSystemService("ShortcutManager.class");

                ShortcutInfo shortcut = new ShortcutInfo.Builder(mcontext, "id1")
                        .setShortLabel("Web site")
                        .setLongLabel("Open the web site")
                        .setIcon(Icon.createWithResource(mcontext, R.drawable.notification))
                        .setIntent(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.mysite.example.com/")))
                        .build();
                if(shortcutManager.getDynamicShortcuts().size()==0)
                 shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
                else
                    shortcutManager.addDynamicShortcuts(Arrays.asList(shortcut));
                */

//            Glide.with(mcontext).load(c.getImage()).into(cardimg);
           // Glide.with(mcontext).load(c.getNumberNotification()).into(notifimg);
           // Glide.with(mcontext).load(c.getNumberUpdate()).into(updateimg);

        return itemView;
    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mcontext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hide:
                        //handle menu1 click
                        Toast.makeText(mcontext,"Hide",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.remove:
                        //handle menu2 click
                        Toast.makeText(mcontext,"Remove",Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
        popup.show();
    }
}
