package com.bustrack.bustracker.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class DatabaseStopObject {
    private int _id;

    private String stopId;


    public DatabaseStopObject(int _id, String stopId) {
        this._id = _id;
        this.stopId = stopId;
    }

    public int get_Id(){return _id;}

    public void set_Id(int _id) {
        this._id = _id;
    }

    public String getStopId(){return stopId;}

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }
}
