package com.example.home.authentic_art_works;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by home on 18-Mar-18.
 */

public class cardsAdapter extends RecyclerView.Adapter<cardsAdapter.MyViewHolder>{
    private Context mcontext;
    private List<card> cardlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,notifNo,updateNo,desc;
        public ImageView cardimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.title_card);
            desc =(TextView)itemView.findViewById(R.id.text_card);
            cardimg=(ImageView)itemView.findViewById(R.id.img_card);
        }
    }

    public cardsAdapter(Context mcontext, List<card> cardlist){
        this.mcontext=mcontext;
        this.cardlist=cardlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        card album = cardlist.get(position);
        holder.title.setText(album.getTitle());
        holder.desc.setText(album.getDescription() + " songs");

        // loading album cover using Glide library
        Glide.with(mcontext).load(album.getImage()).into(holder.cardimg);
    }

    @Override
    public int getItemCount() {
        return cardlist.size();
    }


}
