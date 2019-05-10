package ru.vlabum.study.tickman;

import java.util.ArrayList;
import java.util.List;

public class EventSeatManager {

    private List<SeatListener> seatListeners = new ArrayList<>();

    public void subscribe(final SeatListener listener) {
        seatListeners.add(listener);
    }

    public void unsubscribe(final SeatListener listener) {
        seatListeners.remove(listener);
    }

    public void notify(final Object context, final Event event, final Seat seat, final boolean release) {
        for (SeatListener listener : seatListeners) {
            listener.update(context, event, seat, release);
        }
    }

}
