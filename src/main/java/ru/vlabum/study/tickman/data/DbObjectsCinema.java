package ru.vlabum.study.tickman.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObjectsCinema extends DbObjects {

    public DbObjectsCinema(Connection connection) {
        super(connection);
    }

    @Override
    protected void createTables() {
        Statement statement;
        try {
            statement = getConnection().createStatement();
            String seats = "CREATE TABLE IF NOT EXISTS Seats ( id integer PRIMARY KEY, line varchar(21), place varchar(32));";
            String soldControl = "CREATE TABLE IF NOT EXISTS SoldControl ( eventID integer, seatID integer);";
            statement.execute(seats);
            statement.execute(soldControl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void dropTables() {
        Statement statement;
        try {
            statement = getConnection().createStatement();
            String seats = "DROP TABLE IF EXISTS Seats;";
            String soldControl = "DROP TABLE IF EXISTS SoldControl;";
            statement.execute(seats);
            statement.execute(soldControl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

