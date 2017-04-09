package com.bustrack.bustracker.entity;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class EditBusObject {
    private int id;

    private String departureStop;

    public EditBusObject(int id, String departureStop, String arriveTime){
        this.id = id;

        this.departureStop = departureStop;

    }

    public int getId(){return id;}

    public String getDepartureStop(){return departureStop;}
}
