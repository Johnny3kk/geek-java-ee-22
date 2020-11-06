package ru.geekbrains.persist;

import java.sql.*;
import java.util.Calendar;

public class ToDoRepository {

    private final Connection conn;

    public ToDoRepository(Connection conn) {
        this.conn = conn;
    }

    public void insert(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into todos(description, targetDate) values (?, ?);")){
            stmt.setString(1, toDo.getDescription());
            stmt.setDate(2, Date.valueOf(toDo.getTargetDate()), Calendar.getInstance());
            stmt.execute();
        }
    }

    public void update(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update todos set description = ?, targetDate = ? where id = ?;")){
            stmt.setString(1, toDo.getDescription());
            stmt.setDate(2, Date.valueOf(toDo.getTargetDate()), Calendar.getInstance());
            stmt.setLong(3, toDo.getId());
            stmt.execute();
        }
    }

    public ToDo findById(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, description, targetDate from todos where id = ?;")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new ToDo(rs.getLong(1), rs.getString(2), rs.getDate(3, Calendar.getInstance()).toLocalDate());
            }
        }
        return new ToDo(-1L, "", null);
    }
}
