import static org.junit.jupiter.api.Assertions.*;

import org.example.Cart;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Product 1", 10.0);
        product2 = new Product(2, "Product 2", 20.0);
    }

    @Test
    void testAddAndRemoveProduct() {
        assertTrue(cart.getProducts().isEmpty());

        cart.addProduct(product1);
        assertTrue(cart.getProducts().contains(product1));

        cart.removeProduct(product1);
        assertFalse(cart.getProducts().contains(product1));
    }
}
