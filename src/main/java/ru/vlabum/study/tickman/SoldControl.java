package ru.vlabum.study.tickman;

import ru.vlabum.study.tickman.data.SoldControlDB;

import java.util.HashMap;
import java.util.Map;

public class SoldControl implements SeatListener {

    public SoldControlManager soldControlManager = new SoldControlManager();

    private SoldControlDB soldControlDB = new SoldControlDB(App.conn);

    private Map<Long, SetSeats> soldControl;

    public SoldControl() {
        soldControl = soldControlDB.selectAll();
    }

    @Override
    public void update(final Object context, Event event, Seat seat, boolean release) {
        if (release) {
            releaseSeat(context, event, seat);
        } else {
            addSeat(context, event, seat);
        }
    }

    private void releaseSeat(final Object context, final Event event, final Seat seat) {
        boolean isAffected = false;
        final long eventId = event.getId();
        boolean found = find(event, seat);
        if (found) {
            soldControl.get(eventId).remove(seat.getId());
            if (soldControl.get(eventId).isEmpty()) {
                soldControl.remove(eventId);
            }
            isAffected = true;
        }
        soldControlManager.notify(context, event, seat, false, isAffected);
        soldControlDB.delete(event, seat);
    }

    private void addSeat(final Object context, final Event event, final Seat seat) {
        boolean isAffected = false;
        final long eventId = event.getId();
        boolean found = find(event, seat);
        if (!found) {
            if (soldControl.containsKey(eventId)) {
                soldControl.get(eventId).add(seat.getId());
            } else {
                soldControl.put(eventId, new SetSeats());
                soldControl.get(eventId).add(seat.getId());
            }
            isAffected = true;
        }
        soldControlManager.notify(context, event, seat, isAffected, false);
        soldControlDB.insert(event, seat);
    }

    private boolean find(final Event event, final Seat seat) {
        boolean found = false;
        boolean foundEvent = false;
        final long eventId = event.getId();
        final long seatId = seat.getId();
        // ищем в коллекции
        if (soldControl.containsKey(eventId)) {
            foundEvent = true;
            if (soldControl.get(eventId).contains(seatId)) {
                found = true;
            }
        }
        // смотрим в БД
        if (!found) {
            if (soldControlDB.exists(event, seat)) {
                if (!foundEvent) {
                    soldControl.put(eventId, new SetSeats());
                }
                soldControl.get(eventId).add(seatId);
                found = true;
            }
        }
        return found;
    }

}
