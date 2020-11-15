package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Order;
import by.zercomp.application.model.entity.OrderStatus;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao {

    Order findById(long id) throws DaoException;

    List<Order> findByStatus(OrderStatus status) throws DaoException;

    List<Order> findByUser(User user) throws DaoException;

    List<Order> findInDateRange(LocalDate start, LocalDate end) throws DaoException;

}
