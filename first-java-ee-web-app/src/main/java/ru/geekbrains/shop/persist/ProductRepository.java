package ru.geekbrains.shop.persist;

import ru.geekbrains.persist.ToDo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductRepository {

    private final Connection conn;

    public ProductRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }

    public void insert(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into products(`name`, brand, description, cost) values (?, ?, ?, ?);")){
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getDescription());
            stmt.setBigDecimal(4, product.getCost());
            stmt.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update products set `name` = ?, brand = ?, description = ?, cost = ? where id = ?;")){
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getDescription());
            stmt.setBigDecimal(4, product.getCost());
            stmt.setLong(5, product.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from products where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Product findById(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, `name`, brand, description, cost from products where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5));
            }
        }
        return new Product(-1L, "", "", "", new BigDecimal(-1));
    }

    public List<Product> findAll() throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( "select id, `name`, brand, description, cost from products");

            while (rs.next()) {
                res.add(new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute( "create table if not exists products (\n" +
                    "\tid int auto_increment primary key, \n" +
                    "`name` varchar(25), \n" +
                    "brand varchar(25), \n" +
                    "description varchar(110), \n" +
                    "cost decimal \n" +
                    ");");
        }
    }

}
