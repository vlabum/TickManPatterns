package ru.vlabum.study.tickman;

import ru.vlabum.study.tickman.Seat;

public class SeatHockey implements Seat {

    private long id;
    private String sector;
    private String line;
    private String place;

    public SeatHockey(int id, String... partsName) {
        if (partsName.length != 3) {
            throw new IllegalArgumentException("in second parameter need Sector, Line and Place");
        }
        this.id = id;
        this.sector = partsName[0];
        this.line = partsName[1];
        this.place = partsName[2];
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getFullName() {
        StringBuilder sb = new StringBuilder()
                .append(sector)
                .append("-")
                .append(line)
                .append("-")
                .append(place);
        return sb.toString();
    }

    @Override
    public String getPartName(int nPart) {
        switch (nPart) {
            case 0: return sector;
            case 1: return line;
            case 2: return place;
        }
        return "";
    }

}
