package com.wlfz.bean;



public class LoctionBean {

    private double longitude;
    private double latitude ;
    private double ne_lng;
    private double ne_lat;
    private double sw_lat;
    private double sw_lng;
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getNe_lng() {
        return ne_lng;
    }
    public void setNe_lng(double ne_lng) {
        this.ne_lng = ne_lng;
    }
    public double getNe_lat() {
        return ne_lat;
    }
    public void setNe_lat(double ne_lat) {
        this.ne_lat = ne_lat;
    }
    public double getSw_lat() {
        return sw_lat;
    }
    public void setSw_lat(double sw_lat) {
        this.sw_lat = sw_lat;
    }
    public double getSw_lng() {
        return sw_lng;
    }
    public void setSw_lng(double sw_lng) {
        this.sw_lng = sw_lng;
    }
}
