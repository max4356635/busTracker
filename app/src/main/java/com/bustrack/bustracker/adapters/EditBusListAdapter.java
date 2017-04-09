package com.bustrack.bustracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bustrack.bustracker.R;
import com.bustrack.bustracker.entity.EditBusObject;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class EditBusListAdapter extends RecyclerView.Adapter<EditBusListHolders> {
    private List<EditBusObject> editBusObjects;
    protected Context context;

    public EditBusListAdapter(Context context, List<EditBusObject> editBusObjects){
        this.context = context;
        this.editBusObjects = editBusObjects;
    }

    @Override
    public EditBusListHolders onCreateViewHolder(ViewGroup parent, int viewType){
        EditBusListHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_list, parent, false);
        viewHolder = new EditBusListHolders(layoutView, editBusObjects);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EditBusListHolders holder, final int position){
        int _id = editBusObjects.get(position).getId();
        holder.busShortName.setText(Html.fromHtml(String.valueOf(_id)));
        holder.departureStop.setText(Html.fromHtml(editBusObjects.get(position).getDepartureStop()));
        holder.editBusRadioButton.setTag(_id);
    }

    @Override
    public int getItemCount(){return this.editBusObjects.size();}
}
