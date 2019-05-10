package ru.vlabum.study.tickman;

import java.util.ArrayList;
import java.util.List;

public class SoldControlManager {

    private List<SoldControlListener> listeners = new ArrayList<>();

    public void subscribe(final SoldControlListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(final SoldControlListener listener) {
        listeners.remove(listener);
    }

    public void notify (final Object context, final Event event, final Seat seat, final boolean isAdded, final boolean isDeleted) {
        for (SoldControlListener listener : listeners) {
            listener.update(context, event, seat, isAdded, isDeleted);
        }
    }

}
