package ru.vlabum.study.tickman.data;

import ru.vlabum.study.tickman.Event;
import ru.vlabum.study.tickman.Seat;
import ru.vlabum.study.tickman.SetSeats;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * будто работаем с БД
 */
public class SoldControlDB {

    private Connection conn;

    public SoldControlDB(final Connection conn) {
        this.conn = conn;
    }

    public void insert(final Event event, final Seat seat) {
        // в самой таблице БД должен быть UNIQUE CONSTRAINT по этим двум полям
        PreparedStatement stat = null;
        String insertSql = "INSERT into SoldControl values(?, ?);";
        try {
            stat = conn.prepareStatement(insertSql);
            stat.setLong(1, event.getId());
            stat.setLong(2, seat.getId());
            System.out.println(stat.toString());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            } catch (Exception e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Message: " + e.getMessage());
            }
        }
    }

    public void delete(final Event event, final Seat seat) {
        PreparedStatement stat = null;
        String deleteSql = "delete from SoldControl where eventID = ? and seatID = ?;";
        try {
            stat = conn.prepareStatement(deleteSql);
            stat.setLong(1, event.getId());
            stat.setLong(2, seat.getId());
            System.out.println(stat.toString());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            } catch (NullPointerException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Message: " + e.getMessage());
            }
        }
    }

    public Map<Long, SetSeats> selectAll() {
        Statement stat = null;
        Map<Long, SetSeats> soldControl = new HashMap<>();
        try {
            String selectSql = "SELECT eventID, seatID from SoldControl;";
            stat = conn.createStatement();
            System.out.println(stat.toString());
            ResultSet rs = stat.executeQuery(selectSql);
            while (rs.next()) {
                long eventId = rs.getLong(1);
                long seatId = rs.getLong(2);

                if (!soldControl.containsKey(eventId)) {
                    soldControl.put(eventId, new SetSeats());
                    soldControl.get(eventId).add(seatId);
                } else {
                    if (!(soldControl.get(eventId)).contains(seatId)) {
                        soldControl.get(eventId).add(seatId);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            } catch (NullPointerException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Message: " + e.getMessage());
            }
        }
        return soldControl;
    }

    public boolean exists(final Event event, final Seat seat) {
        boolean exists = false;
        PreparedStatement stat = null;
        String selectSql = "select eventID from SoldControl where eventID = ? and seatID = ?;";
        try {
            stat = conn.prepareStatement(selectSql);
            stat.setLong(1, event.getId());
            stat.setLong(2, seat.getId());
            System.out.println(stat.toString());
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            } catch (NullPointerException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Message: " + e.getMessage());
            }
        }
        return exists;
    }

}
