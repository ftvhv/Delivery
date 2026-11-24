package by.delivery.service;
import by.delivery.model.Customer;
import by.delivery.model.Dish;
import by.delivery.model.Order;
import by.delivery.repository.InMemoryOrderRepository;
import by.delivery.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class OrderService {

        private static final Logger logger = LoggerFactory.getLogger(OrderService.class); 

    private final OrderRepository repository;
    private final double minAmount;

    public OrderService(OrderRepository repository, double minAmount) {
        this.repository = repository;
        this.minAmount = minAmount;
    }

        public boolean createOrder(Order order) {
        logger.info("Zakaz oformlen dlya: {}", order.getCustomer().getName());
        
        try {
                if (order.getTotalAmount() < minAmount) {
                        logger.warn("Summa zakaza {} < min ({})", order.getTotalAmount(), minAmount);
                return false;
                }
                
                logger.info("Zakaz sozdan. Summa: {}", order.getTotalAmount());
                return true;
                
        } catch (Exception e) {
                logger.error("Oshibka zakaza: {}", e.getMessage(), e);
                return false;
        }
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