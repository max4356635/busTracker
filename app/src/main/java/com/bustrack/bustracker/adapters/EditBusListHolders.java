package com.bustrack.bustracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bustrack.bustracker.R;
import com.bustrack.bustracker.entity.EditBusObject;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class EditBusListHolders extends RecyclerView.ViewHolder{
    private static final String TAG = EditBusListHolders.class.getSimpleName();

    public TextView busShortName;

    public TextView departureStop;

    public RadioButton editBusRadioButton;

    public EditBusListHolders(final View itemView, final List<EditBusObject> editBusObjects){
        super(itemView);
        busShortName = (TextView)itemView.findViewById(R.id.bus_short_name_edit);
        editBusRadioButton = (RadioButton)itemView.findViewById(R.id.edit_bus_radio_button);
    }
}
