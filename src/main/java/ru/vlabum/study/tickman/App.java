package ru.vlabum.study.tickman;

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
        seatsHockey.printSeats();

        SetOfSeatsFacade seatsCinema = new SetOfSeatsFacade(Consts.SEAT_CINENA);
        seatsCinema.fillSeats();
        seatsCinema.printSeats();
    }

}
