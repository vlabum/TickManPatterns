package ru.vlabum.study.tickman;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SetOfSeats seatsHockey = new SetOfSeats(SetOfSeats.SEAT_HOCKEY);
        seatsHockey.fillSeats(1, new String[] {"A", "1", "1"});
        seatsHockey.fillSeats(2, new String[] {"A", "1", "2"});

        SetOfSeats seatsCinema = new SetOfSeats(SetOfSeats.SEAT_CINENA);
        seatsCinema.fillSeats(1, new String[] {"1", "1"});
        seatsCinema.fillSeats(2, new String[] {"1", "2"});
    }

}
