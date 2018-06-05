  package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
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

public class UpdatesAdapter extends BaseAdapter {
     static ArrayList<Updates> values;
     Context mcontext;
     LayoutInflater inflater;
     static int i=1;
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

           if(name.getImageid()==1){

              WebView pdf = (WebView) convertView.findViewById(R.id.web1);
               ImageView img= (ImageView) convertView.findViewById(R.id.img_src);
               pdf.setVisibility(View.INVISIBLE);



               img.setImageResource(name.getImage());



               //     pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

  /*      //img.setImageBitmap(bmp);*/
               img.setOnClickListener(new View.OnClickListener() {
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
                tv5.setVisibility(View.GONE);
               ImageView img=(ImageView)convertView.findViewById(R.id.img_src);
               img.setVisibility(View.INVISIBLE);
               WebView pdf = (WebView) convertView.findViewById(R.id.web1);
                    pdf.getSettings().setJavaScriptEnabled(true);
                    pdf.loadUrl("http://docs.google.com/gview?embedded=true&url=" + name.getUrl());
*/
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
