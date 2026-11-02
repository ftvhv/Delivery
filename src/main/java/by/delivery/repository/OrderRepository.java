package repository;

import model.Order;

public interface OrderRepository {
    void saveOrder(Order order);
}
