import org.example.Order;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    @Test
    void testGetOrderStatus() {
        Order orderMock = Mockito.mock(Order.class);
        when(orderMock.getStatus()).thenReturn("Shipped");

        String status = orderMock.getStatus();
        assertEquals("Shipped", status);
    }
}
