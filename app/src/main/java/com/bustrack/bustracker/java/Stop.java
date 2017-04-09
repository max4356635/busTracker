package com.bustrack.bustracker.java;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class Stop {
    private String stop_id;

    private String stop_name;

    private String stop_desc;

    private String stop_lat;

    private String stop_lon;

    private String zone_id;

    private String stop_url;

    private String stop_code;

    private String stop_street;

    private String stop_city;

    private String stop_region;

    private String stop_postcode;

    private String stop_country;

    private String location_station;

    private String stop_timezone;

    private String wheelchair_boarding;

    private String direction;

    private String position;

    private String the_geom;

    public Stop(String stop_id, String stop_name, String stop_desc, String stop_lat, String stop_lon,
                 String zone_id, String stop_url, String stop_code,String stop_street, String stop_city, String stop_region,
                 String stop_postcode, String stop_country, String location_station, String stop_timezone,
                 String wheelchair_boarding, String direction, String position, String the_geom) {

        this.stop_id = stop_id;
        this.stop_name = stop_name;
        this.stop_desc = stop_desc;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
        this.zone_id = zone_id;
        this.stop_url = stop_url;
        this.stop_code = stop_code;
        this.stop_street = stop_street;
        this.stop_city = stop_city;
        this.stop_region = stop_region;
        this.stop_postcode = stop_postcode;
        this.stop_country = stop_country;
        this.location_station = location_station;
        this.stop_timezone = stop_timezone;
        this.wheelchair_boarding = wheelchair_boarding;
        this.direction = direction;
        this.position = position;
        this.the_geom = the_geom;
    }


    public String getStop_id() {
        return stop_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public String getStop_desc() {
        return stop_desc;
    }

    public String getStop_lat() {
        return stop_lat;
    }

    public String getStop_lon() {
        return stop_lon;
    }

    public String getZone_id() {
        return zone_id;
    }

    public String getStop_url() {
        return stop_url;
    }

    public String getStop_code() { return stop_code; }

    public String getStop_street() {
        return stop_street;
    }

    public String getStop_city() {
        return stop_city;
    }

    public String getStop_region() {
        return stop_region;
    }

    public String getStop_postcode() {
        return stop_postcode;
    }

    public String getStop_country() {
        return stop_country;
    }

    public String getLocation_station() {
        return location_station;
    }

    public String getStop_timezone() {
        return stop_timezone;
    }

    public String getWheelchair_boarding() {
        return wheelchair_boarding;
    }

    public String getDirection() {
        return direction;
    }

    public String getPosition() {
        return position;
    }

    public String getThe_geom() {
        return the_geom;
    }
}
