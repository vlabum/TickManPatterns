package ru.vlabum.study.tickman;

public interface SeatListener {
    void update(Object context, Event event, Seat seat, boolean release);
}
