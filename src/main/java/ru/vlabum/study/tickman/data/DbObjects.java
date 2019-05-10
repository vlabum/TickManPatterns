package ru.vlabum.study.tickman.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DbObjects {

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;

    public DbObjects(Connection connection) {
        this.connection = connection;
    }

    public void createObjects() {
        createSequences();
        createTables();
    }

    public void dropObjects() {
        dropTables();
        dropSequences();
    }

    protected void createTables() {
    }

    protected void dropTables() {
    }

    protected void createSequences() {
    }

    protected void dropSequences() {
    }

}
