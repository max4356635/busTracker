package com.bustrack.bustracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bustrack.bustracker.adapters.BusListAdapter;
import com.bustrack.bustracker.entity.BusObject;
import com.bustrack.bustracker.helpers.Helper;
import com.bustrack.bustracker.java.Route;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class BusListActivity extends AppCompatActivity{
    private static final String TAG = BusListActivity.class.getSimpleName();

    private RequestQueue queue;

    private List<Route> routes;

    private List<BusObject> busObjects;

    private BusListAdapter busListAdapter;

    private RecyclerView busListRecyclerView;

    private String theStopId;
    @Override
    protected void onCreate(Bundle savedInstanceState){


        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                theStopId = "1111";
            } else{
                theStopId = extras.getString("theStopId");
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bus);

        setTitle(Helper.BUS_LIST);

        queue = Volley.newRequestQueue(BusListActivity.this);
        busObjects = new ArrayList<BusObject>();

        requestJsonObject();

        Toast.makeText(BusListActivity.this, "Count numebr of bus at current Stop:" + busObjects.size(), Toast.LENGTH_LONG).show();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BusListActivity.this);
        busListRecyclerView = (RecyclerView)findViewById(R.id.bus_list);
    }

    private void requestJsonObject(){
        String url = Helper.GET_STOP_INFO_BY_ID_URL + theStopId + "?api_key=" + Helper.API_KEY;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response" + response);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                JsonArray objArray = (JsonArray) new JsonParser().parse(response).getAsJsonObject().get("response");
                Type listType = new TypeToken<List<Route>>() {
                }.getType();
                routes = gson.fromJson(objArray, listType);

                if (null == routes) {
                    Toast.makeText(getApplicationContext(), "Nothing was return", Toast.LENGTH_LONG).show();
                } else {
                    int size = routes.size();
                    for (int i = 0; i < size; i++) {
                        Route route = routes.get(i);
                        String id = route.getRoute_id();
                        String shortName = route.getRoute_short_name();
                        String longName = route.getRoute_long_name();

                        busObjects.add(new BusObject(id, shortName, longName));
                    }

                        busListAdapter = new BusListAdapter(BusListActivity.this, busObjects);
                        busListRecyclerView.setAdapter(busListAdapter);
                    }
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Log.d(TAG, "Error" + error.getMessage());
                }
        });
        queue.add(stringRequest);
    }
}
