package com.example.xyzskylake.extend.Model;

/**
 * Created by harzen on 19/08/17.
 */

public class ActionModel {

    protected  String id;
    protected  String ticket_id;
    protected  String name;
    protected  String comment ;
    protected  String photo;
    protected  long date;

    public ActionModel(){

    }

    public ActionModel(String id, String ticket_id, String name, String comment, String photo, long date){

        setId(id);
        setTicket_id(ticket_id);
        setName(name);
        setComment(comment);
        setPhoto(photo);
        setDate(date);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

}
