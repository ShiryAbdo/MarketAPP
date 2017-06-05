package com.example.shaymaa.disegnnew;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Shaymaa on 5/28/2017.
 */

public class CustomFilter  extends Filter{
    MyAdapter adapter;
    ArrayList<Products> filterList;
    public CustomFilter(ArrayList<Products> filterList, MyAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;
    }
    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Products> filteredProductses =new ArrayList<>();
            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredProductses.add(filterList.get(i));
                }
            }
            results.count= filteredProductses.size();
            results.values= filteredProductses;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }
    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.productses = (ArrayList<Products>) results.values;
        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
