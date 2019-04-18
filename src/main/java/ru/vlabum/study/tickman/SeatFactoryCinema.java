package ru.vlabum.study.tickman;

public class SeatFactoryCinema extends SeatFactory {
    @Override
    public Seat createSeat(int id, String[] partsName) {
        return new SeatCinema(id, partsName);
    }
}
