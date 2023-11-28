import org.example.Library;
import org.example.Patron;
import org.example.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book;
    private Patron patron;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("To Kill a Mockingbird", "Harper Lee", "B3001", "ISBN3001", "1960");
        patron = new Patron("Alice Smith", "P2001");
        library.add(book);
        library.registerPatron(patron);
    }

    @Test
    void testLendItem() {
        assertFalse(book.isBorrowed);
        library.LendItem(patron, book);
        assertTrue(book.isBorrowed);
        assertTrue(patron.borrowItem.contains(book));
    }

    @Test
    void testReturnItem() {
        library.LendItem(patron, book);
        library.ReturnItem(patron, book);
        assertFalse(book.isBorrowed);
        assertFalse(patron.borrowItem.contains(book));
    }

}
