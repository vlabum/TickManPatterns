package ru.vlabum.study.tickman;

public abstract class SeatFactory {

    public abstract Seat createSeat(int id, String[] partsName);

}
