import static org.junit.jupiter.api.Assertions.*;

import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class OrderTest {
    @Test
    void testOrderStatus() {
        Order order = new Order(1, Arrays.asList(new Product(1, "Product 1", 10.0)));
        assertEquals("New", order.getStatus());

        order.setStatus("Shipped");
        assertEquals("Shipped", order.getStatus());
    }
}
