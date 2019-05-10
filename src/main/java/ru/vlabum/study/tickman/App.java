package ru.vlabum.study.tickman;

import com.sun.org.apache.xpath.internal.operations.Or;
import ru.vlabum.study.tickman.data.DbConnector;
import ru.vlabum.study.tickman.data.DbObjects;
import ru.vlabum.study.tickman.data.DbObjectsCinema;
import ru.vlabum.study.tickman.data.DbObjectsHockey;

import java.sql.Connection;
import java.util.Date;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App {

    public static Connection conn;
    public static void main( String[] args )
    {

        conn = DbConnector.getConnection();
        if (conn == null) {
            exit(0);
            System.out.println("Соединение не установлено");
        }

        String typeSeat = Consts.SEAT_HOCKEY;

        DbObjects dbObjects;
        if (Consts.SEAT_HOCKEY.equals(typeSeat)) {
            dbObjects = new DbObjectsHockey(conn);
        } else if (Consts.SEAT_CINENA.equals(typeSeat)) {
            dbObjects = new DbObjectsCinema(conn);
        } else {
            throw new IllegalArgumentException();
        }

        dbObjects.createObjects();

        SetOfSeatsFacade seatsHockey = new SetOfSeatsFacade(typeSeat);
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

        dbObjects.dropObjects();

    }

}
