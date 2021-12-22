package persistence;

import domain.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderRepositroy {
    ResultSet findAllInformationFromThisOrder(int id) throws SQLException;

    Order findById(int id) throws SQLException;

    List<Order> findAll() throws SQLException;

    Order save(Order order) throws SQLException;

    void delete(int id) throws SQLException;
}
