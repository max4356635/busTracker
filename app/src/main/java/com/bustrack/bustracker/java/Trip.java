package com.bustrack.bustracker.java;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class Trip {

    private String route_id;

    private String service_id;

    private String trip_id;

    private String trip_headsign;

    private int direction_id;

    private String block_id;

    private String shape_id;

    private String trip_short_name;

    private String trip_type;

    public Trip(String route_id, String service_id, String trip_id, String trip_headsign, int direction_id, String block_id, String shape_id, String trip_short_name, String trip_type) {
        this.route_id = route_id;
        this.service_id = service_id;
        this.trip_id = trip_id;
        this.trip_headsign = trip_headsign;
        this.direction_id = direction_id;
        this.block_id = block_id;
        this.shape_id = shape_id;
        this.trip_short_name = trip_short_name;
        this.trip_type = trip_type;
    }

    public String getRoute_id() {
        return route_id;
    }

    public String getService_id() {
        return service_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public String getTrip_headsign() {
        return trip_headsign;
    }

    public int getDirection_id() {
        return direction_id;
    }

    public String getBlock_id() {
        return block_id;
    }

    public String getShape_id() {
        return shape_id;
    }

    public String getTrip_short_name() {
        return trip_short_name;
    }

    public String getTrip_type() {
        return trip_type;
    }

}
