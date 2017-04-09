package com.bustrack.bustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bustrack.bustracker.adapters.StopListAdapter;
import com.bustrack.bustracker.database.DatabaseQuery;
import com.bustrack.bustracker.entity.DatabaseStopObject;
import com.bustrack.bustracker.entity.StopObject;
import com.bustrack.bustracker.helpers.Helper;
import com.bustrack.bustracker.java.Stop;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.lang.reflect.Type;
/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class StopListActivity  extends AppCompatActivity{
    private static final String TAG=StopListActivity.class.getSimpleName();

    private DatabaseQuery query;

    //private List<DatabaseStopObject> allStops;

    private StopObject stopObject;

    private RequestQueue queue;

    private List<StopObject> allData;

    private Stop stop;

    private StopListAdapter stopListAdapter;

    private RecyclerView stopRecyclerView;

    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stop);

        setTitle(Helper.STOP_LIST);

        queue = Volley.newRequestQueue(StopListActivity.this);

        Toast.makeText(StopListActivity.this, "Count number of stops", Toast.LENGTH_SHORT).show();


    }

    private void requestJsonObject(){
        String url = Helper.GET_STOP_INFO_BY_ID_URL + input + "?api_key=" + Helper.API_KEY;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                Log.d(TAG, "Response" + response);

                stop = null;
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                JsonObject jsonObj = (JsonObject) new JsonParser().parse(response).getAsJsonObject().get("response");
                Type listType = new TypeToken<List<Stop>>(){}.getType();

                stop = gson.fromJson(jsonObj, listType);

                if(null == stop){
                    Toast.makeText(getApplicationContext(), "Nothing was return", Toast.LENGTH_LONG).show();
                } else{

                    String stopId = stop.getStop_id();
                    String stopCode = stop.getStop_code();
                    String stopAddress = stop.getStop_name();

                    allData.add(new StopObject(stopId, stopCode, stopAddress));

                    stopListAdapter = new StopListAdapter(StopListActivity.this, allData);
                    stopRecyclerView.setAdapter(stopListAdapter);
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

    public void AddEditedStop(View v)
    {
        EditText et = (EditText)findViewById(R.id.edit_stop_id);
        input = et.getText().toString();
        requestJsonObject();

        if(allData != null)
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StopListActivity.this);
            stopRecyclerView = (RecyclerView)findViewById(R.id.stop_list_recycler);
            stopRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
