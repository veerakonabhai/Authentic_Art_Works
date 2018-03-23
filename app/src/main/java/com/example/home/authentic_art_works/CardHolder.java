package com.example.home.authentic_art_works;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by home on 20-Mar-18.
 */

public class CardHolder extends RecyclerView.ViewHolder {


    public TextView title,notifNo,updateNo,desc;
    public ImageView cardimg,notifimg,updateimg;

        public CardHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.title_card);
          //  desc =(TextView)itemView.findViewById(R.id.text_card);
            cardimg=(ImageView)itemView.findViewById(R.id.img_card);
            notifimg=(ImageView)itemView.findViewById(R.id.notification);
            updateimg=(ImageView)itemView.findViewById(R.id.update);

        }

}
