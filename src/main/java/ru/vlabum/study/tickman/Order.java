package ru.vlabum.study.tickman;

import java.util.ArrayList;
import java.util.List;

public class Order implements SoldControlListener {

    public EventSeatManager eventSeatManager = new EventSeatManager();

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addSeat(final Event event, final Seat seat) {
        eventSeatManager.notify(this, event, seat, false);
    }

    public void releaseSeat(final Event event, final Seat seat) {
        eventSeatManager.notify(this, event, seat, true);
    }

    // окончательно добавляем место в заказ, только после того, как пройдет проверка в SoldControl
    private void addSeatCall(final Event event, final Seat seat) {
        orderItems.add(new OrderItem(event, seat));
        System.out.println("added " + seat.getFullName());
    }

    private void releaseSeatCall(final Event event, final Seat seat) {
        for (OrderItem oi : orderItems) {
            if (oi.getEvent().getId() == event.getId() && oi.getSeat().getId() == seat.getId()) {
                orderItems.remove(oi);
                System.out.println("removed " + seat.getFullName());
            }
        }
    }

    @Override
    public void update(final Object context, final Event event, final Seat seat, final boolean isAdded, final boolean isDeleted) {
        if (this.equals(context)) {
            if (isAdded) {
                addSeatCall(event, seat);
            } else if (isDeleted) {
                releaseSeatCall(event, seat);
            } else {
                System.out.println("Nothing!!");
            }
        }
    }
}
