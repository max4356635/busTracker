package com.bustrack.bustracker.entity;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class BusObject {
    private String busId;

    private String shortName;

    private String longName;


    public BusObject(String busId,String shortName, String longName){
        this.busId = busId;
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getId(){return busId;}

    public String getShortName(){return shortName;}

    public String getLongName(){return longName;}

}
