package ru.vlabum.study.tickman;

public interface SoldControlListener {
    void update(Object context, Event event, Seat seat, boolean isAdded, boolean isDeleted);
}
