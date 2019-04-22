package ru.vlabum.study.tickman.data;

import ru.vlabum.study.tickman.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс-заглушка
 */
public class SeatsData {

    private Seat[] seats;

    private SeatFactory seatFactory;

    public SeatsData(final String typeSeat) {


        if (Consts.SEAT_CINENA.equals(typeSeat)) {
            seatFactory = new SeatFactoryCinema();
        } else if (Consts.SEAT_HOCKEY.equals(typeSeat)) {
            seatFactory = new SeatFactoryHockey();
        } else {
            throw new IllegalArgumentException();
        }

        // конфигурация зала ледовой арены (секторов, рядов в секторе, места в ряду), тут предполагаем одинаковые секторы
        int hSectors = 4, hRows = 20, hPlaces = 20;
        // конфигурация кинозала
        int cRows = 12, cPlaces = 20;

        seats = new Seat[Consts.SEAT_HOCKEY.equals(typeSeat) ? hSectors * hRows * hPlaces : cRows * cPlaces];

        if (Consts.SEAT_HOCKEY.equals(typeSeat)) {
            for (int i = 0; i < hSectors; i++) {
                for (int j = 0; j < hRows; j++) {
                    for (int k = 0; k < hPlaces; k++) {
                        final String sector = String.format("%d", i);
                        final String row = String.format("%d", j + 1);
                        final String place = String.format("%d", k + 1);
                        seats[i * hRows * hPlaces + j * hPlaces + k] =
                                seatFactory.createSeat(i * hRows * hPlaces + j * hPlaces + k, sector, row, place);
                    }
                }
            }
        }

        if (Consts.SEAT_CINENA.equals(typeSeat)) {
            for (int i = 0; i < cRows; i++) {
                for (int j = 0; j < cPlaces; j++) {
                    final String row = String.format("%d", i + 1);
                    final String place = String.format("%d", j + 1);
                    seats[i * cPlaces + j] = seatFactory.createSeat(i * cPlaces + j, row, place);
                }
            }
        }
    }

    public Seat[] getData() {
        return seats;
    }

}
