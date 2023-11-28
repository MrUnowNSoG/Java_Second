import org.example.DVD;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DVDTest {

    @Test
    void testDVDInitialization() {
        DVD dvd = new DVD("Inception", "D1001", 120);
        assertEquals("Inception", dvd.title);
        assertEquals("D1001", dvd.uniqueID);
        assertEquals(120, dvd.getDuraion());
    }

    @Test
    void testBorrowItem() {
        DVD dvd = new DVD("Inception", "D1001", 120);
        assertFalse(dvd.isBorrowed);
        dvd.borrowItem();
        assertTrue(dvd.isBorrowed);
    }
}
