package com.bustrack.bustracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.bustrack.bustracker.entity.DatabaseStopObject;
import com.bustrack.bustracker.java.Stop;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class DatabaseQuery extends DatabaseObject{
    private final String TABLE_NAME = "data";

    private final String KEY_NAME = "_id";

    public DatabaseQuery(Context context) {
        super(context);
    }

    public List<DatabaseStopObject> getStoredDataStops(){
        List<DatabaseStopObject> allLocations = new ArrayList<DatabaseStopObject>();
        String query = "Select * from data";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                System.out.println("Response number " + id);
                String storedData = cursor.getString(cursor.getColumnIndexOrThrow("cotent"));
                System.out.println("Response number " + storedData);
                allLocations.add(new DatabaseStopObject(id, storedData));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return allLocations;
    }

    public int countAllStoredStops(){
        int total = 0;
        String query = "Select * from data";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            total = cursor.getCount();
        }
        cursor.close();
        return total;
    }

    private boolean isStopExist(String stopId){
        String query = "Select * from data where cotent=" + "'"+ stopId +"'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            return true;
        }
        cursor.close();
        return false;
    }

    public void insertNewLocation(String stopId){
        ContentValues values = new ContentValues();
        values.put("cotent", stopId);
        if(!isStopExist(stopId)){
            getDbConnection().insert(TABLE_NAME, null, values);
        }
        getDbConnection().close();
    }

    public boolean deleteLocation(int stopId){
        return getDbConnection().delete(TABLE_NAME, KEY_NAME + "=" + stopId, null) > 0;
    }

    public void deleteAllLocationContent(){
        getDbConnection().execSQL("delete from " + TABLE_NAME);
    }

}
