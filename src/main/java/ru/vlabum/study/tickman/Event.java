package ru.vlabum.study.tickman;

import java.util.Date;

public class Event {

    private int id;

    private String name;

    private Date dateBegin;

    public Event (final int id, final String name, final Date dateBegin) {
        this.id = id;
        this.name = name;
        this.dateBegin = dateBegin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }
}
