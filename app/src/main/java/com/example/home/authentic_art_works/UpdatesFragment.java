package com.example.home.authentic_art_works;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdatesFragment extends Fragment {

    ArrayList<Updates> cardlist;
    Updates updates;
    ListView lv;
    UpdatesAdapter uadapter;
    public static Context mcontext;
 //   LinearLayoutManager lm;
    View view;
    public UpdatesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_updates, container, false);
        cardlist=new ArrayList<>();
        int[] images = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        };
        mcontext=this.getActivity();
        SimpleDateFormat s=new SimpleDateFormat("dd/M/yyyy");
        updates=new Updates("ganesh",images[0],4,s.format(new Date()),"hello hwy how are you doing and whatd good  thurrasdy friday");
        cardlist.add(updates);
        updates=new Updates("ganesh",images[0],8,s.format(new Date()),"hello hwy how are you doing and whatd good  thurrasdy friday");
        cardlist.add(updates);
        updates=new Updates("victor",images[0],4,s.format(new Date()),"hello hwy how are you doing and whatd good  thurrasdy friday");
        cardlist.add(updates);
        updates=new Updates("veerraaa",images[2],89,s.format(new Date()),"hello hwy how are you doing and whatd good  thurrasdy friday");
        cardlist.add(updates);
        updates=new Updates("ganeshaaaa",images[1],4,s.format(new Date()),"hello hwy how are you doing and whatd good  thurrasdy friday");
        cardlist.add(updates);

      /*  Uri uri=Uri.parse("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf");
        Bitmap bmp=generateImageFromPdf(uri);*/

   lv=(ListView)view.findViewById(R.id.listview);
     //   lm=new LinearLayoutManager(getActivity());
        uadapter=new UpdatesAdapter(this.getActivity(),cardlist);
        lv.setAdapter(uadapter);
        final SwipeRefreshLayout sr=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh1);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Hello refreshed in updates",Toast.LENGTH_SHORT).show();
                sr.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public String toString() {
        return "Updates";
    }

    Bitmap generateImageFromPdf(Uri pdfUri) {
        int pageNumber = 0;
        PdfiumCore pdfiumCore = new PdfiumCore(this.getActivity());
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
            saveImage(bmp);
            pdfiumCore.closeDocument(pdfDocument);// important!
            return bmp;
        } catch(Exception e) {
            //todo with exception
        }
        return bmp ;
    }

    public final static String FOLDER = Environment.getExternalStorageDirectory() + "/PDF";
    private void saveImage(Bitmap bmp) {
        FileOutputStream out = null;
        try {
            File folder = new File(FOLDER);
            if(!folder.exists())
                folder.mkdirs();
            File file = new File(folder, "PDF.png");
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
        } catch (Exception e) {
            //todo with exception
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (Exception e) {
                //todo with exception
            }
        }
    }
}
