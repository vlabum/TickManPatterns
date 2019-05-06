package ru.vlabum.study.tickman;

import ru.vlabum.study.tickman.data.SeatsData;

public class SetOfSeatsFacade {

    private SetOfSeats setOfSeats;

    private String typeSeat;

    public SetOfSeatsFacade(String typeSeat) {
        if (typeSeat == null) {
            throw new IllegalArgumentException();
        }

        if (Consts.SEAT_HOCKEY.equals(typeSeat) || Consts.SEAT_CINENA.equals(typeSeat)) {
                setOfSeats = new SetOfSeats(typeSeat);
                this.typeSeat = typeSeat;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void fillSeats() {
        // тут можно сделать обращение к БД или файлу
        setOfSeats.fillSeats((new SeatsData(typeSeat)).getData());
    }

    public void printSeats() {
        setOfSeats.printSeats(10);
    }

}
