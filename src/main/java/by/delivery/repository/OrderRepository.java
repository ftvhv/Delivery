package by.delivery.repository;

import by.delivery.model.Order;

public interface OrderRepository {
    void saveOrder(Order order);
}
