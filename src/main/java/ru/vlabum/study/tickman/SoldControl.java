package ru.vlabum.study.tickman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoldControl implements SeatListener {

    public SoldControlManager soldControlManager = new SoldControlManager();

    private Map<Integer, SetSeats> map = new HashMap<>();

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
        if (map.containsKey(event.getId())) {
            if (map.get(event.getId()).contains(seat.getID())) {
                map.get(event.getId()).remove(seat.getID());
                isAffected = true;
            }
        }
        soldControlManager.notify(context, event, seat, false, isAffected);
    }

    private void addSeat(final Object context, final Event event, final Seat seat) {
        boolean isAffected = false;
        if (!map.containsKey(event.getId())) {
            map.put(event.getId(), new SetSeats());
            map.get(event.getId()).add(seat.getID());
            isAffected = true;
        } else {
            if (!(map.get(event.getId())).contains(seat.getID())) {
                map.get(event.getId()).add(seat.getID());
                isAffected = true;
            }
        }
        soldControlManager.notify(context, event, seat, isAffected, false);
    }

    class SetSeats {

        Set<Integer> set = new HashSet<>();

        void add (final Integer id) {
            set.add(id);
        }

        void remove(final Integer id) {
            set.remove(id);
        }

        boolean contains(final Integer id) {
            return set.contains(id);
        }
    }

}
