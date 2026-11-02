package service;

import model.Customer;
import model.Dish;
import model.Order;
import repository.InMemoryOrderRepository;
import repository.OrderRepository;

import java.util.List;

public class OrderService {

    private final OrderRepository repository;
    private final double minAmount;

    public OrderService(OrderRepository repository, double minAmount) {
        this.repository = repository;
        this.minAmount = minAmount;
    }

    public boolean createOrder(Order order) {

        if (order.getTotalAmount() < minAmount) {
            return false;
        }

        repository.saveOrder(order);

        return true;
    }

    public static void main(String[] args) {

        OrderRepository repository =
                new InMemoryOrderRepository();

        OrderService service =
                new OrderService(repository, 20);

        Customer customer =
                new Customer(1, "Dima");

        Dish salad =
                new Dish("Salad", 25);

        Dish water =
                new Dish("Coffee", 2);

        Order order =
                new Order(
                        customer,
                        List.of(salad, water)
                );

        boolean result =
                service.createOrder(order);

        System.out.println(
                "Заказ создан: " + result
        );

        System.out.println(
                "Сумма заказа: " + order.getTotalAmount()
        );
    }
}