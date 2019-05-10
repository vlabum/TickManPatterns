package ru.vlabum.study.tickman;

import java.util.Date;

public class Event {

    private long id;

    private String name;

    private Date dateBegin;

    public Event (final long id, final String name, final Date dateBegin) {
        this.id = id;
        this.name = name;
        this.dateBegin = dateBegin;
    }

    public long getId() {
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
