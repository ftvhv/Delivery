import model.Customer;
import model.Dish;
import model.Order;
import repository.InMemoryOrderRepository;
import repository.OrderRepository;
import service.OrderService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    public void firstTest() {

        OrderRepository repository =
                new InMemoryOrderRepository();

        OrderService service =
                new OrderService(repository, 20);

        Order order =
                new Order(
                        new Customer(1, "Dima"),
                        List.of(
                                new Dish("Salad", 25),
                                new Dish("Coffee", 2)
                        )
                );

        boolean result =
                service.createOrder(order);

        assertTrue(
                result,
                "Заказ с достаточной суммой должен быть принят"
        );
    }

    @Test
    public void secondTest() {

        OrderRepository repository =
                new InMemoryOrderRepository();

        OrderService service =
                new OrderService(repository, 20);

        Order order =
                new Order(
                        new Customer(1, "Dima"),
                        List.of(
                                new Dish("Salad", 7),
                                new Dish("Coffee", 3)
                        )
                );

        boolean result =
                service.createOrder(order);

        assertFalse(
                result,
                "Заказ меньше минимальной суммы должен быть отклонён"
        );
    }

    @Test
    public void thirdTest() {

        OrderRepository repository =
                new InMemoryOrderRepository();

        OrderService service =
                new OrderService(repository, 20);

        Order order =
                new Order(
                        new Customer(1, "Dima"),
                        List.of(
                                new Dish("Salad", 20)
                        )
                );

        boolean result =
                service.createOrder(order);

        assertTrue(
                result,
                "Заказ на минимальную сумму должен быть принят"
        );
    }
}