package by.zercomp.application.model.service;

import by.zercomp.application.model.entity.Order;
import by.zercomp.application.model.exception.ServiceException;

import javax.transaction.Status;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(long id) throws ServiceException;

    List<Order> findByStatus(Status status) throws ServiceException;

    List<Order> findByUser(long id) throws ServiceException;

    List<Order> findInRange(LocalDate start, LocalDate end) throws ServiceException;

    void changeStatus(Order order, Status newStatus) throws ServiceException;



}
