package by.zercomp.application.model.entity;

import java.time.LocalDate;

public class Order extends Identifiable {

    private OrderStatus status;
    private Delivery delivery;
    private LocalDate date;


}
