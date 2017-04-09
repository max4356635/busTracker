package com.bustrack.bustracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bustrack.bustracker.R;
import com.bustrack.bustracker.entity.BusObject;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class BusListAdapter extends RecyclerView.Adapter<BusListHolders>{
    private List<BusObject> busObjects;
    protected Context context;

    public BusListAdapter(Context context, List<BusObject> busObjects){
        this.context = context;
        this.busObjects = busObjects;
    }

    @Override
    public BusListHolders onCreateViewHolder(ViewGroup parent, int viewType){
        BusListHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_list, parent, false);
        viewHolder = new BusListHolders(layoutView, busObjects);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BusListHolders holder, final int position){
        String _id = busObjects.get(position).getId();
        holder.busShortName.setText(Html.fromHtml(String.valueOf(_id)));
        holder.departureStop.setText(Html.fromHtml(busObjects.get(position).getLongName()));
        holder.trackButton.setTag(_id);
    }

    @Override
    public int getItemCount(){return this.busObjects.size();}
}
