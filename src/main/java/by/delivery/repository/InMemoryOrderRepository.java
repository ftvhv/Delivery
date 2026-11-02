package repository;
import model.Order;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

