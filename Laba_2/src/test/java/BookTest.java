import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookInitialization() {
        Book book = new Book("1984", "George Orwell", "B1001", "ISBN1001", "1949");

        assertEquals("1984", book.title);
        assertEquals("George Orwell", book.author);
        assertEquals("B1001", book.uniqueID);
        assertEquals("ISBN1001", book.ISBN);
        assertEquals("1949", book.yearPublication);
    }

    @Test
    void testBorrowItem() {
        Book book = new Book("1984", "George Orwell", "B1001", "ISBN1001", "1949");
        assertFalse(book.isBorrowed);
        book.borrowItem();
        assertTrue(book.isBorrowed);
    }
}