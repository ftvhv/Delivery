package model;
import java.util.List;

public class Order {

    private final Customer customer;
    private final List<Dish> dishes;

    public Order(Customer customer, List<Dish> dishes) {
        this.customer = customer;
        this.dishes = dishes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public double getTotalAmount() {

        double total = 0;

        for (Dish dish : dishes) {
            total += dish.getPrice();
        }

        return total;
    }
}
