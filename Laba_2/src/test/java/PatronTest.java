import org.example.Patron;
import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatronTest {

    @Test
    void testPatronBorrowAndReturnItem() {
        Patron patron = new Patron("John Doe", "P1001");
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "B2001", "ISBN2001", "1925");

        assertTrue(patron.GetItemForIndex(0) == null);
        patron.Borrow(book);
        assertTrue(book.isBorrowed);
        assertEquals(1, patron.GetSize());

        patron.Return(book);
        assertFalse(book.isBorrowed);
        assertTrue(patron.GetItemForIndex(0) == null);
    }
}
