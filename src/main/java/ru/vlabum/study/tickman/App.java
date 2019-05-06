package ru.vlabum.study.tickman;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SetOfSeatsFacade seatsHockey = new SetOfSeatsFacade(Consts.SEAT_HOCKEY);
        seatsHockey.fillSeats();
//        seatsHockey.printSeats();

//        SetOfSeatsFacade seatsCinema = new SetOfSeatsFacade(Consts.SEAT_CINENA);
//        seatsCinema.fillSeats();
//        seatsCinema.printSeats();

        SoldControl soldControl = new SoldControl();
        Order order = new Order();

        // 2 наблюдателя в обе стороны
        soldControl.soldControlManager.subscribe(order);
        order.eventSeatManager.subscribe(soldControl);

        final Event event = new Event(1, "Мероприятие", new Date());
        order.addSeat(event, seatsHockey.getSeat(1));
        order.addSeat(event, seatsHockey.getSeat(2));
        order.addSeat(event, seatsHockey.getSeat(1));
        order.releaseSeat(event, seatsHockey.getSeat(1));
        order.addSeat(event, seatsHockey.getSeat(1));

    }

}
