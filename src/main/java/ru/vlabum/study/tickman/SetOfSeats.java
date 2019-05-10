package ru.vlabum.study.tickman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetOfSeats {

    private List<Seat> seats = new ArrayList<>();

    private SeatFactory seatFactory;

    public SetOfSeats(String typeSeat) {
        if (Consts.SEAT_CINENA.equals(typeSeat)) {
            seatFactory = new SeatFactoryCinema();
        } else if (Consts.SEAT_HOCKEY.equals(typeSeat)) {
            seatFactory = new SeatFactoryHockey();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Seat getSeat(final int index) {
        return seats.get(index);
    }

    public Seat getSeatByID(final int id) {
        for (Seat seat : seats) {
            if (seat.getId() == id) {
                return seat;
            }
        }
        return null;
    }

    public void fillSeats(Seat[] seats) {
        this.seats.addAll(Arrays.asList(seats));
    }

    public void addSeat(int id, String[] partsName) {
        seats.add(seatFactory.createSeat(id, partsName));
    }

    public void printSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getFullName());
        }
    }

    /**
     * Печать мест
     * @param n - количество мест в строке
     */
    public void printSeats(int n) {
        int i = 0;
        if (n < 1) {
            n = 1;
        }
        for (Seat seat : seats) {
            if (i++ >= n) {
                System.out.println();
                i = 0;
            }
            System.out.print(seat.getFullName());
            System.out.print(";\t");
        }
    }

}
