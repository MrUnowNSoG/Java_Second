import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.addBook(new Book("Title1", "Author1", "ISBN1", 2001));
        library.addBook(new Book("Title2", "Author2", "ISBN2", 2002));
    }

    @Test
    void testAddBook() {
        library.addBook(new Book("Title3", "Author3", "ISBN3", 2003));
        assertNotNull(library.findBookByTitle("Title3"));
    }

    @Test
    void testRemoveBookByISBN() {
        library.removeBookByISBN("ISBN1");
        assertNull(library.findBookByTitle("Title1"));
    }

    @Test
    void testFindBookByTitle() {
        assertNotNull(library.findBookByTitle("Title2"));
        assertNull(library.findBookByTitle("NonExistingTitle"));
    }
}
