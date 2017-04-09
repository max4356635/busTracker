package com.bustrack.bustracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bustrack.bustracker.entity.StopObject;
import com.bustrack.bustracker.R;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class StopListHolders extends RecyclerView.ViewHolder{
    private static final String TAG = StopListHolders.class.getSimpleName();

    public TextView stopCode;

    public TextView stopAddress;

    public Button busListButton;

    public StopListHolders(final View itemView, final List<StopObject> stopObjects){
        super(itemView);
        stopCode = (TextView)itemView.findViewById(R.id.stop_code);
        stopAddress = (TextView)itemView.findViewById(R.id.stop_address);
        busListButton = (Button)itemView.findViewById(R.id.bus_list_button);
    }
}
