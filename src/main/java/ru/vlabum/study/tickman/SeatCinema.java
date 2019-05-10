package ru.vlabum.study.tickman;

public class SeatCinema implements Seat{
    private long id;
    private String line;
    private String place;

    public SeatCinema(int id, String... partsName) {
        if (partsName.length != 2) {
            throw new IllegalArgumentException("in second parameter need Line and Place");
        }
        this.id = id;
        this.line = partsName[0];
        this.place = partsName[1];
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getFullName() {
        StringBuilder sb = new StringBuilder()
                .append("row: ")
                .append(line)
                .append(" place: ")
                .append(place);
        return sb.toString();
    }

    @Override
    public String getPartName(int nPart) {
        switch (nPart) {
            case 0: return line;
            case 1: return place;
        }
        return "";
    }

}
