package com.example.shaymaa.disegnnew;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import java.util.ArrayList;
 import android.widget.Filter;




public class MyAdapter  extends RecyclerView.Adapter<MyHolder> implements Filterable {
    Context c;
    ArrayList<Products> productses,filterList;
    CustomFilter filter;
    public MyAdapter(Context ctx,ArrayList<Products> productses)
    {
        this.c=ctx;
        this.productses = productses;
        this.filterList= productses;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,null);
        //HOLDER
        MyHolder holder=new MyHolder(v);
        return holder;
    }
    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        //BIND DATA
        holder.posTxt.setText("$"+ productses.get(position).getPos());
        holder.nameTxt.setText(productses.get(position).getName());
        holder.img.setImageResource(productses.get(position).getImg());
        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, productses.get(pos).getName(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return productses.size();
    }
    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
