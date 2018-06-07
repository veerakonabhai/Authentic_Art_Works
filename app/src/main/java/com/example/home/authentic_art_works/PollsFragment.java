package com.example.home.authentic_art_works;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PollsFragment extends Fragment {

    ArrayList<Polls> polls;
    PollAdapter adapter;
    Polls poll;
    RecyclerView rv;
    View view;
    public PollsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_polls, container, false);
        rv=( RecyclerView)view.findViewById(R.id.polls_rv);
        polls=new ArrayList<>();
        poll=new Polls(R.drawable.img3,"Doctor Strange","yes","no",40,50,"hello");
        polls.add(poll);
        poll=new Polls(R.drawable.img2,"Terminator","accept","reject",80,20,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.hello hwy how are you doing and whatd good  thurrasdy friday");
        polls.add(poll);
        poll=new Polls(R.drawable.img3,"Fast and Furious","like","dislike",30,70,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.hello hwy how are you doing and whatd good  thurrasdy friday");
        polls.add(poll);
        poll=new Polls(R.drawable.img3,"Jungle Book","accept","reject",45,55,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.hello hwy how are you doing and whatd good  thurrasdy friday");
        polls.add(poll);
        poll=new Polls(R.drawable.img3,"Jurassic World","yes","no",15,85,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.hello hwy how are you doing and whatd good  thurrasdy friday");
        polls.add(poll);
        adapter=new PollAdapter(this.getActivity(),polls);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
       // rv.setAdapter(uadapter);
        rv.setAdapter(adapter);
        final SwipeRefreshLayout mySwipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipeinpolls);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(getContext(),"Refresh is called",Toast.LENGTH_LONG).show();



                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
        return view;
    }

    @Override
    public String toString() {
        return "Polls";
    }
}
class PollAdapter extends RecyclerView.Adapter<PollAdapter.ItemViewHolder>{
    ArrayList<Polls> values;
    Context mcontext;
    LayoutInflater inflater;

    PollAdapter(Context mcontext,ArrayList<Polls> values){
        this.mcontext=mcontext;
        this.values=values;
    }
    @Override
    public PollAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(itemView==null)
        {
            itemView=inflater.inflate(R.layout.polls,parent,false);
        }
        return new ItemViewHolder(itemView,viewType);
    }

    @Override
    public void onBindViewHolder(PollAdapter.ItemViewHolder holder, int position) {
        final PollAdapter.ItemViewHolder holder1=holder;
        final int position1=position;
        final Polls poll = values.get(position);
        holder1.img.setImageResource(poll.getImageid());
        holder1.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
                Intent i=new Intent(mcontext,PollsFullActivity.class);
                //Intent i=new Intent(mcontext,UpdatesActivity.class);
                i.putExtra("title",poll.getTitle());
                i.putExtra("option1",poll.getOption1());
                i.putExtra("option2",poll.getOption2());
                i.putExtra("progress1",poll.getOptper1());
                i.putExtra("progress2",poll.getOptper2());
                i.putExtra("description",poll.getDesc());
                i.putExtra("image",poll.getImageid());
                mcontext.startActivity(i);
            }
        });
        holder1.tv1.setText(poll.getTitle());
        holder1.rb1.setText(poll.getOption1());
        holder1. rb2.setText(poll.getOption2());
        holder1.tv2.setText(""+(poll.getOptper1()));
        holder1.tv3.setText(""+(poll.getOptper2()));
        holder1.ps1.setProgress(poll.getOptper1());
        holder1.ps2.setProgress(poll.getOptper2());

        holder1.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Position="+position1,Toast.LENGTH_LONG).show();
                AlertDialog.Builder ad=new AlertDialog.Builder(mcontext);
                ad.setTitle("Confirming your opinion");
                ad.setMessage("Please confirm your opinion!");
                ad.setCancelable(false);
                ad.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  /*      rb1.setVisibility(View.GONE);
                        rb2.setVisibility(View.GONE);
                        tv2.setVisibility(View.VISIBLE);
                        tv3.setVisibility(View.VISIBLE);
                        ps1.setVisibility(View.VISIBLE);
                        ps2.setVisibility(View.VISIBLE);*/

                        holder1.tv2.setText(""+(poll.getOptper1()+1));
                        holder1.tv3.setText(""+(poll.getOptper2()-1));

                        holder1.ps1.setProgress((poll.getOptper1()+1));
                        holder1.ps2.setProgress((poll.getOptper2()-1));
                        holder1.rb1.setEnabled(false);
                        holder1.rb2.setEnabled(false);
                        //  dialog.cancel();
                    }
                });
                ad.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=ad.create();
                alert.show();
            }
        });
        holder1.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Position="+position1,Toast.LENGTH_LONG).show();
                AlertDialog.Builder ad=new AlertDialog.Builder(mcontext);
                ad.setTitle("Confirming your opinion");
                ad.setMessage("Please confirm your opinion!");
                ad.setCancelable(false);
                ad.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  /*      rb1.setVisibility(View.GONE);
                        rb2.setVisibility(View.GONE);
                        tv2.setVisibility(View.VISIBLE);
                        tv3.setVisibility(View.VISIBLE);
                        ps1.setVisibility(View.VISIBLE);
                        ps2.setVisibility(View.VISIBLE);*/

                       holder1.tv2.setText(""+(poll.getOptper1()-1));
                        holder1.tv3.setText(""+(poll.getOptper2()+1));

                        holder1.ps1.setProgress((poll.getOptper1()-1));
                        holder1.ps2.setProgress((poll.getOptper2()+1));

                        holder1.rb1.setEnabled(false);
                        holder1.rb2.setEnabled(false);
                        //  dialog.cancel();
                    }
                });
                ad.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=ad.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        RadioButton rb1,rb2;
        TextView tv1,tv2,tv3;
        ProgressBar ps1,ps2;
        ImageView img;
        public ItemViewHolder(View convertView,int viewType) {
            super(convertView);
            img= (ImageView) convertView.findViewById(R.id.img_src_poll);
            tv1=(TextView)convertView.findViewById(R.id.title_poll);
            rb1=(RadioButton)convertView.findViewById(R.id.radio_option1);
            rb2=(RadioButton)convertView.findViewById(R.id.radio_option2);

            tv2=(TextView)convertView.findViewById(R.id.text_progress1);
            tv3=(TextView)convertView.findViewById(R.id.text_progress2) ;
            // TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);

            ps1=(ProgressBar)convertView.findViewById(R.id.poll_progress1);
            ps2=(ProgressBar)convertView.findViewById(R.id.poll_progress2);
        }
    }
}
class Polls{
    int imageid;
    String option1;
    String option2;
    String title;
    int optper1,optper2;
    String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getOptper1() {
        return optper1;
    }

    public void setOptper1(int optper1) {
        this.optper1 = optper1;
    }

    public int getOptper2() {
        return optper2;
    }

    public void setOptper2(int optper2) {
        this.optper2 = optper2;
    }

    Polls(int imageid, String title,String option1, String option2, int optper1, int optper2,String desc){
        this.title=title;
        this.imageid=imageid;
        this.option1=option1;
        this.option2=option2;
        this.optper1=optper1;
        this.optper2=optper2;
        this.desc=desc;

    }

}
class PollsAdapter extends BaseAdapter {

    static class Polls{
        int imageid;
        String option1;
        String option2;
        String title;
        int optper1,optper2;
        String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }



        public int getImageid() {
            return imageid;
        }

        public void setImageid(int imageid) {
            this.imageid = imageid;
        }

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

        public int getOptper1() {
            return optper1;
        }

        public void setOptper1(int optper1) {
            this.optper1 = optper1;
        }

        public int getOptper2() {
            return optper2;
        }

        public void setOptper2(int optper2) {
            this.optper2 = optper2;
        }

        Polls(int imageid, String title,String option1, String option2, int optper1, int optper2,String desc){
            this.title=title;
            this.imageid=imageid;
            this.option1=option1;
            this.option2=option2;
            this.optper1=optper1;
            this.optper2=optper2;
            this.desc=desc;

        }

    }
    static ArrayList<Polls> values;
    Context mcontext;
    LayoutInflater inflater;

    RadioButton rb1,rb2;
    TextView tv1,tv2,tv3;
    ProgressBar ps1,ps2;
    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public PollsAdapter(Context mcontext,ArrayList<Polls> values){
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
            convertView=inflater.inflate(R.layout.polls,parent,false);
        }
        ImageView img= (ImageView) convertView.findViewById(R.id.img_src_poll);
        tv1=(TextView)convertView.findViewById(R.id.title_poll);
        rb1=(RadioButton)convertView.findViewById(R.id.radio_option1);
        rb2=(RadioButton)convertView.findViewById(R.id.radio_option2);

        tv2=(TextView)convertView.findViewById(R.id.text_progress1);
        tv3=(TextView)convertView.findViewById(R.id.text_progress2) ;
        // TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);

        ps1=(ProgressBar)convertView.findViewById(R.id.poll_progress1);
        ps2=(ProgressBar)convertView.findViewById(R.id.poll_progress2);

      /*  tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        ps1.setVisibility(View.GONE);
        ps2.setVisibility(View.GONE);
*/
        final Polls poll = values.get(position);
        img.setImageResource(poll.getImageid());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
                Intent i=new Intent(mcontext,PollsFullActivity.class);
                //Intent i=new Intent(mcontext,UpdatesActivity.class);
                i.putExtra("title",poll.getTitle());
                i.putExtra("option1",poll.getOption1());
                i.putExtra("option2",poll.getOption2());
                i.putExtra("progress1",poll.getOptper1());
                i.putExtra("progress2",poll.getOptper2());
                i.putExtra("description",poll.getDesc());
                i.putExtra("image",poll.getImageid());
                mcontext.startActivity(i);
            }
        });
        tv1.setText(poll.getTitle());
        rb1.setText(poll.getOption1());
        rb2.setText(poll.getOption2());
        ps1.setProgress(poll.getOptper1());
        ps2.setProgress(poll.getOptper2());
        Log.d("progress bars",""+poll.getOptper1()+" "+poll.getOptper2());
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Position="+position,Toast.LENGTH_LONG).show();
                AlertDialog.Builder ad=new AlertDialog.Builder(mcontext);
                ad.setTitle("Confirming your opinion");
                ad.setMessage("Please confirm your opinion!");
                ad.setCancelable(false);
                ad.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  /*      rb1.setVisibility(View.GONE);
                        rb2.setVisibility(View.GONE);
                        tv2.setVisibility(View.VISIBLE);
                        tv3.setVisibility(View.VISIBLE);
                        ps1.setVisibility(View.VISIBLE);
                        ps2.setVisibility(View.VISIBLE);*/

                        tv2.setText(""+(poll.getOptper1()+1));
                        tv3.setText(""+(poll.getOptper2()-1));

                        ps1.setProgress((poll.getOptper1()+1));
                        ps2.setProgress((poll.getOptper2()-1));
                      //  dialog.cancel();
                    }
                });
                ad.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=ad.create();
                alert.show();
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Position="+position,Toast.LENGTH_LONG).show();
                AlertDialog.Builder ad=new AlertDialog.Builder(mcontext);
                ad.setTitle("Confirming your opinion");
                ad.setMessage("Please confirm your opinion!");
                ad.setCancelable(false);
                ad.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  /*      rb1.setVisibility(View.GONE);
                        rb2.setVisibility(View.GONE);
                        tv2.setVisibility(View.VISIBLE);
                        tv3.setVisibility(View.VISIBLE);
                        ps1.setVisibility(View.VISIBLE);
                        ps2.setVisibility(View.VISIBLE);*/

                        tv2.setText(""+(poll.getOptper1()-1));
                        tv3.setText(""+(poll.getOptper2()+1));

                        ps1.setProgress((poll.getOptper1()-1));
                        ps2.setProgress((poll.getOptper2()+1));
                        //  dialog.cancel();
                    }
                });
                ad.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=ad.create();
                alert.show();
            }
        });
        return convertView;
    }




}

