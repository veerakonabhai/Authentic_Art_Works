package com.example.home.authentic_art_works;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FundRaiseFragment extends Fragment {
    ArrayList<FundRaiseAdapter.FundRaise> funds;
    FundRaiseAdapter adapter;
    FundRaiseAdapter.FundRaise fund;
    ListView lv;
    View view;
    public FundRaiseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_fund_raise, container, false);

        lv=(ListView)view.findViewById(R.id.listviewinfunds);
        SimpleDateFormat s=new SimpleDateFormat("dd/M/yyyy");
        funds=new ArrayList<>();
        fund=new FundRaiseAdapter.FundRaise(R.drawable.img1,"chuchu","he is the man born with flair and with red eyes",""+s.format(new Date()),""+"13/06/2019",40000,100000);
        funds.add(fund);

        fund=new FundRaiseAdapter.FundRaise(R.drawable.img2,"chowchow","he is the man born with flair and with red eyes",""+s.format(new Date()),""+"13/06/2019",40000,100000);
        funds.add(fund);

        fund=new FundRaiseAdapter.FundRaise(R.drawable.img1,"coohu","he is the man born with flair and with red eyes",""+s.format(new Date()),""+"13/06/2019",40000,100000);
        funds.add(fund);

        fund=new FundRaiseAdapter.FundRaise(R.drawable.img3,"caucau","he is the man born with flair and with red eyes",""+s.format(new Date()),""+"13/06/2019",4000,100000);
        funds.add(fund);
        adapter=new FundRaiseAdapter(this.getActivity(),funds);
        lv.setAdapter(adapter);
        return view;

    }

    @Override
    public String toString() {
        return "FundsRaise";
    }
}
class FundRaiseAdapter extends BaseAdapter {

    static class FundRaise{
        int imageid;
        String title,desc,enddate,startdate;
        int targetamt,raisedamt;
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

        public String getEnddate() {
            return enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public int getTargetamt() {
            return targetamt;
        }

        public void setTargetamt(int targetamt) {
            this.targetamt = targetamt;
        }





        public int getImageid() {
            return imageid;
        }

        public void setImageid(int imageid) {
            this.imageid = imageid;
        }

        public int getRaisedamt() {
            return raisedamt;
        }

        public void setRaisedamt(int raisedamt) {
            this.raisedamt = raisedamt;
        }

        public FundRaise(int imageid,String title,String desc,String startdate,String enddate,int raisedamt,int targetamt){
            this.imageid=imageid;
            this.title=title;
            this.desc=desc;
            this.startdate=startdate;
            this.enddate=enddate;
            this.raisedamt=raisedamt;
            this.targetamt=targetamt;

        }
    }
    static ArrayList<FundRaise> values;
    Context mcontext;
    LayoutInflater inflater;
    ImageView iv;
    TextView tv1,tv2,tv3,tv4;
    ProgressBar ps1;
    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public FundRaiseAdapter(Context mcontext,ArrayList<FundRaise> values){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.fundraise,parent,false);
        }
        iv= (ImageView) convertView.findViewById(R.id.img_funds);
        tv1=(TextView)convertView.findViewById(R.id.title_funds);
        tv2=(TextView)convertView.findViewById(R.id.date_funds);
        tv3=(TextView)convertView.findViewById(R.id.raised_amount);
        tv4=(TextView)convertView.findViewById(R.id.target_amount);

        // TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);

        ps1=(ProgressBar)convertView.findViewById(R.id.fund_meter);



        final FundRaise fund = values.get(position);
        iv.setImageResource(fund.getImageid());
        tv1.setText(fund.getTitle());
        tv2.setText("ends on:"+fund.getEnddate());
        tv3.setText(""+fund.getRaisedamt());
        tv4.setText(""+fund.getTargetamt());
        final float percent=((float)fund.getRaisedamt()/(float)fund.getTargetamt())*100.0f;
        //   Toast.makeText(mcontext,""+percent,Toast.LENGTH_LONG).show();
        ps1.setProgress((int)percent);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
                Intent i=new Intent(mcontext,FundRaiseFullActivity.class);
                i.putExtra("image",fund.getImageid());
                i.putExtra("title",fund.getTitle());
                i.putExtra("startdate",fund.getStartdate());
                i.putExtra("enddate",fund.getEnddate());
                i.putExtra("percent",(int)percent);
                i.putExtra("raisedamt",fund.getRaisedamt());
                i.putExtra("targetamt",fund.getTargetamt());
                i.putExtra("desc",fund.getDesc());
                mcontext.startActivity(i);
            }
        });



        return convertView;
    }




}



