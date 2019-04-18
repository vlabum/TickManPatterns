package ru.vlabum.study.tickman;

public class SeatFactoryHockey extends SeatFactory {
    @Override
    public Seat createSeat(int id, String[] partsName) {
        return new SeatHockey(id, partsName);
    }
}
