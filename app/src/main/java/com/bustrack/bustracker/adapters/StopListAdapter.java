package com.bustrack.bustracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bustrack.bustracker.entity.StopObject;
import com.bustrack.bustracker.R;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class StopListAdapter extends RecyclerView.Adapter<StopListHolders>{
    private List<StopObject> stopObjects;
    protected Context context;

    public StopListAdapter(Context context, List<StopObject> stopObjects){
        this.context = context;
        this.stopObjects = stopObjects;
    }

    @Override
    public StopListHolders onCreateViewHolder(ViewGroup parent, int viewType){
        StopListHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stop_list, parent, false);
        viewHolder = new StopListHolders(layoutView, stopObjects);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final StopListHolders holder, final int position){
        String _id = stopObjects.get(position).getId();
        holder.stopCode.setText(Html.fromHtml(stopObjects.get(position).getCode()));
        holder.stopAddress.setText(Html.fromHtml(stopObjects.get(position).getName()));
        holder.busListButton.setTag(_id);
    }

    @Override
    public int getItemCount(){return this.stopObjects.size();}
}
