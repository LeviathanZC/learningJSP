package by.zercomp.application.model.entity;

import java.time.LocalDate;
import java.util.Map;

public class Order extends Identifiable {

    private OrderStatus status;
    private Delivery delivery;
    private LocalDate date;
    private Map<Product, Integer> orderList;

    public Order(OrderStatus status, Delivery delivery, LocalDate date) {
        this.status = status;
        this.delivery = delivery;
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (getStatus() != order.getStatus()) return false;
        if (getDelivery() != null ? !getDelivery().equals(order.getDelivery()) : order.getDelivery() != null)
            return false;
        return getDate() != null ? getDate().equals(order.getDate()) : order.getDate() == null;
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = super.hashCode();
        result = prime * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = prime * result + (getDelivery() != null ? getDelivery().hashCode() : 0);
        result = prime * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Order{");
        builder.append("status=").append(status);
        builder.append(", delivery=").append(delivery);
        builder.append(", date=").append(date);
        builder.append('}');
        return builder.toString();
    }
}
