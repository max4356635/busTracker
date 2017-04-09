package com.bustrack.bustracker.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class StopObject {

    private String id;

    private String code;

    private String name;

    public StopObject(String id, String code,String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId(){return id;}

    public String getCode(){return code;}

    public String getName(){return name;}
}
