package ru.vlabum.study.tickman.data;

import org.h2.command.ddl.CreateTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObjectsHockey extends DbObjects {

    public DbObjectsHockey(Connection connection) {
        super(connection);
    }

    @Override
    protected void createTables() {
        Statement statement;
        try {
            statement = getConnection().createStatement();
            String seats = "CREATE TABLE IF NOT EXISTS Seats ( id integer PRIMARY KEY, sector varchar(32), line varchar(21), place varchar(32));";
            String soldControl = "CREATE TABLE IF NOT EXISTS SoldControl ( eventID integer, seatID integer);";
            statement.execute(seats);
            statement.execute(soldControl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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
