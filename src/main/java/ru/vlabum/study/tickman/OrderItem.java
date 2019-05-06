package ru.vlabum.study.tickman;

public class OrderItem {

    private Seat seat;

    private Event event;

    public OrderItem (final Event event, final Seat seat) {
        this.seat = seat;
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public Event getEvent() {
        return event;
    }
}
