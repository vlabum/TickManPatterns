package ru.vlabum.study.tickman;

import java.util.ArrayList;
import java.util.List;

public class SetOfSeats {

    public static String SEAT_HOCKEY = "hockey";

    public static String SEAT_CINENA = "cinema";

    private List<Seat> seats = new ArrayList<>();

    private SeatFactory seatFactory;

    public SetOfSeats(String typeSeat) {
        if (SEAT_CINENA.equals(typeSeat)) {
            seatFactory = new SeatFactoryCinema();
        } else if (SEAT_HOCKEY.equals(typeSeat)) {
            seatFactory = new SeatFactoryHockey();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void fillSeats(int id, String[] partsName) {
        seats.add(seatFactory.createSeat(id, partsName));
    }

}
