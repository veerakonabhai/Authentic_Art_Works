  package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by home on 06-Apr-18.
 */
/*class UpdateAdapter extends RecyclerView.Adapter<UpdateAdapter.ItemViewHolder>{
    static ArrayList<Updates> values;
    Context mcontext;
    LayoutInflater inflater;
    static int TYPE1=1;
    static int TYPE2=2;
UpdateAdapter(Context mcontext,ArrayList<Updates> values ){
    this.mcontext=mcontext;
    this.values=values;
}
    @Override
    public UpdateAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        if(inflater==null){
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(itemView==null) {
            itemView = inflater.inflate(R.layout.updates, parent, false);
        }



        return new ItemViewHolder(itemView,viewType);

    }

    @Override
    public void onBindViewHolder(UpdateAdapter.ItemViewHolder holder, int position) {
        final Updates name=values.get(position);
        holder.tv1.setText(""+name.getDate());
        holder.tv2.setText(""+name.getLikescount());
        holder.tv3.setText(""+name.getSharecount());
        holder.tv4.setText(""+name.getTitle());
        holder.tv5.setVisibility(View.GONE);
        if(getItemViewType(position)==1){
            holder.img.setImageResource(name.getImage());
            holder.pdf.setVisibility(View.INVISIBLE);
        }
        else if(getItemViewType(position)==2){
            holder.img.setVisibility(View.INVISIBLE);
            holder.pdf.getSettings().setJavaScriptEnabled(true);
            holder.pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + name.getUrl());

        }

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public int getItemViewType(int position) {
        return values.get(position).getImageid();// Assume that this return 1 0r 2
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4,tv5;
        WebView pdf;
        ImageView img;
        public ItemViewHolder(View itemView,int viewType) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.date);
            tv2=(TextView)itemView.findViewById(R.id.like_count);
            tv3=(TextView)itemView.findViewById(R.id.share_cnt) ;
            tv4=(TextView)itemView.findViewById(R.id.title);
            tv5= (TextView) itemView.findViewById(R.id.desc_updates);
            pdf = (WebView) itemView.findViewById(R.id.web1);
            img= (ImageView) itemView.findViewById(R.id.img_src);
        }
    }
}*/
public  class UpdatesAdapter extends RecyclerView.Adapter<UpdatesAdapter.ItemViewHolder>{
    static ArrayList<Updates> values;
    Context mcontext;
    LayoutInflater inflater;
    static int TYPE1=1;
    static int TYPE2=2;
    UpdatesAdapter(Context mcontext,ArrayList<Updates> values ){
        this.mcontext=mcontext;
        this.values=values;
    }
    @Override
    public UpdatesAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        if(inflater==null){
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(itemView==null) {
            itemView = inflater.inflate(R.layout.updates, parent, false);
        }



        return new ItemViewHolder(itemView,viewType);

    }

    @Override
    public void onBindViewHolder(UpdatesAdapter.ItemViewHolder holder, int position) {
        final Updates name=values.get(position);
        holder.tv1.setText(""+name.getDate());
        holder.tv2.setText(""+name.getLikescount());
        holder.tv3.setText(""+name.getSharecount());
        holder.tv4.setText(""+name.getTitle());
        holder.tv5.setVisibility(View.GONE);
        if(getItemViewType(position)==1){
            holder.img.setImageResource(name.getImage());
            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(mcontext,UpdatesActivity.class);
                    i.putExtra("id",name.getImageid());
                    i.putExtra("title",name.getTitle());
                    i.putExtra("date",name.getDate());
                    i.putExtra("likescount",name.getLikescount());
                    i.putExtra("sharecount",name.getSharecount());
                    i.putExtra("description",name.getDesc());
                    i.putExtra("image",name.getImage());

                    mcontext.startActivity(i);
                }
            });
            holder.pdf.setVisibility(View.INVISIBLE);
        }
        else if(getItemViewType(position)==2){
            holder.img.setVisibility(View.INVISIBLE);
            holder.pdf.getSettings().setJavaScriptEnabled(true);
            holder.pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + name.getUrl());
            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(mcontext,UpdatesActivity.class);
                    i.putExtra("id",name.getImageid());
                    i.putExtra("title",name.getTitle());
                    i.putExtra("date",name.getDate());
                    i.putExtra("likescount",name.getLikescount());
                    i.putExtra("sharecount",name.getSharecount());
                    i.putExtra("description",name.getDesc());
                    i.putExtra("pdf",name.getUrl());
                    mcontext.startActivity(i);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public int getItemViewType(int position) {
        return values.get(position).getImageid();// Assume that this return 1 0r 2
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4,tv5;
        WebView pdf;
        ImageView img;
        CardView cv;
        public ItemViewHolder(View itemView,int viewType) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.date);
            tv2=(TextView)itemView.findViewById(R.id.like_count);
            tv3=(TextView)itemView.findViewById(R.id.share_cnt) ;
            tv4=(TextView)itemView.findViewById(R.id.title);
            tv5= (TextView) itemView.findViewById(R.id.desc_updates);
            pdf = (WebView) itemView.findViewById(R.id.web1);
            img= (ImageView) itemView.findViewById(R.id.img_src);
            cv=(CardView)itemView.findViewById(R.id.cvinupdates);
        }
    }
}/*extends BaseAdapter {
    static ArrayList<Updates> values;
     Context mcontext;
     LayoutInflater inflater;
     static int i= 1;
     TextView tv1,tv2,tv3,tv4,tv5;
// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public UpdatesAdapter(Context mcontext,ArrayList<Updates> values){
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
        final Updates name = values.get(position);
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.updates, parent, false);
        }

        tv1=(TextView)convertView.findViewById(R.id.date);
        tv2=(TextView)convertView.findViewById(R.id.like_count);
        tv3=(TextView)convertView.findViewById(R.id.share_cnt) ;
        tv4=(TextView)convertView.findViewById(R.id.title);
        tv5= (TextView) convertView.findViewById(R.id.desc_updates);
        tv1.setText(""+name.getDate());
        tv2.setText(""+name.getLikescount());
        tv3.setText(""+name.getSharecount());
        tv4.setText(""+name.getTitle());
        tv5.setVisibility(View.GONE);

           if(name.getUrl().equals("")){

              WebView pdf = (WebView) convertView.findViewById(R.id.web1);
               ImageView img= (ImageView) convertView.findViewById(R.id.img_src);
               pdf.setVisibility(View.INVISIBLE);



               img.setImageResource(name.getImage());



               //     pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

  /*      //img.setImageBitmap(bmp);*/
       /*        img.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i=new Intent(mcontext,UpdatesActivity.class);
                       i.putExtra("title",name.getTitle());
                       i.putExtra("date",name.getDate());
                       i.putExtra("likescount",name.getLikescount());
                       i.putExtra("sharecount",name.getSharecount());
                       i.putExtra("description",name.getDesc());
                       i.putExtra("image",name.getImage());
                       mcontext.startActivity(i);
                   }
               });

            }
            else {
               /* convertView = inflater.inflate(R.layout.updates1, parent, false);
                tv1 = (TextView) convertView.findViewById(R.id.date);
                tv2 = (TextView) convertView.findViewById(R.id.like_count);
                tv3 = (TextView) convertView.findViewById(R.id.share_cnt);
                tv4 = (TextView) convertView.findViewById(R.id.title);
                tv5 = (TextView) convertView.findViewById(R.id.desc_updates);



                tv1.setText("" + name.getDate());
                tv2.setText("" + name.getLikescount());
                tv3.setText("" + name.getLikescount());
                tv4.setText("" + name.getTitle());
                tv5.setVisibility(View.GONE);*/
           /*    ImageView img=(ImageView)convertView.findViewById(R.id.img_src);
               img.setVisibility(View.INVISIBLE);
               WebView pdf = (WebView) convertView.findViewById(R.id.web1);
                    pdf.getSettings().setJavaScriptEnabled(true);
                    pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + name.getUrl());

            }



       /* tv1=(TextView)convertView.findViewById(R.id.date);
        tv2=(TextView)convertView.findViewById(R.id.like_count);
        tv3=(TextView)convertView.findViewById(R.id.share_cnt) ;
        tv4=(TextView)convertView.findViewById(R.id.title);
        tv5= (TextView) convertView.findViewById(R.id.desc_updates);
        ImageView img= (ImageView) convertView.findViewById(R.id.img_src);


        tv1.setText(""+name.getDate());
        tv2.setText(""+name.getLikescount());
        tv3.setText(""+name.getSharecount());
        tv4.setText(""+name.getTitle());
        tv5.setVisibility(View.GONE);

        img.setImageResource(name.getImage());



   //     pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

  /*      //img.setImageBitmap(bmp);*/
     /*  img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mcontext,UpdatesActivity.class);
                i.putExtra("title",name.getTitle());
                i.putExtra("date",name.getDate());
                i.putExtra("likescount",name.getLikescount());
                i.putExtra("sharecount",name.getSharecount());
                i.putExtra("description",name.getDesc());
                i.putExtra("image",name.getImage());
                mcontext.startActivity(i);
            }
        });*/
/*
        return convertView;
    }

    Bitmap generateImageFromPdf(Uri pdfUri) {
        int pageNumber = 0;
        PdfiumCore pdfiumCore = new PdfiumCore(mcontext);
        Bitmap bmp=null;
        try {
            //http://www.programcreek.com/java-api-examples/index.php?api=android.os.ParcelFileDescriptor
            ParcelFileDescriptor fd = mcontext.getContentResolver().openFileDescriptor(pdfUri, "r");
            PdfDocument pdfDocument = pdfiumCore.newDocument(fd);
            pdfiumCore.openPage(pdfDocument, pageNumber);
            int width = pdfiumCore.getPageWidthPoint(pdfDocument, pageNumber);
            int height = pdfiumCore.getPageHeightPoint(pdfDocument, pageNumber);
            bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            pdfiumCore.renderPageBitmap(pdfDocument, bmp, pageNumber, 0, 0, width, height);
        //    saveImage(bmp);
            pdfiumCore.closeDocument(pdfDocument);// important!
            return bmp;
        } catch(Exception e) {
            //todo with exception
        }
        return bmp ;
    }




}
*/