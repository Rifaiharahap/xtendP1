package com.example.xyzskylake.extend.Model;

/**
 * Created by harzen on 19/08/17.
 */

public class TicketModel {

    protected String id;
    protected String subject;
    protected String description;
    protected double lat;
    protected double lng;
    protected double radius;
    protected long create_date;
    protected String create_by;

    public TicketModel(){

    }

    public TicketModel(String id, String subject, String description,double lat, double lng, double radius,
                long create_date, String create_by){
        setId(id);
        setSubject(subject);
        setDescription(description);
        setLat(lat);
        setLng(lng);
        setRadius(radius);
        setCreate_date(create_date);
        setCreate_by(create_by);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String reate_by) {
        this.create_by = reate_by;
    }

}
