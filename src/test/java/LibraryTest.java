import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", 2001, "ISBN001");
        book2 = new Book("Title2", "Author2", 2002, "ISBN002");
        book3 = new Book("Title3", "Author1", 2003, "ISBN003");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("Title4", "Author4", 2004, "ISBN004");
        library.addBook(newBook);
        assertTrue(library.getAllBooks().contains(newBook));
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN001");
        assertFalse(library.getAllBooks().contains(book1));
    }

    @Test
    public void testSearchByTitle() {
        List<Book> results = library.searchByTitle("Title1");
        assertEquals(1, results.size());
        assertEquals(book1, results.get(0));
    }

    @Test
    public void testSearchByAuthor() {
        List<Book> results = library.searchByAuthor("Author1");
        assertEquals(2, results.size());
        assertTrue(results.contains(book1));
        assertTrue(results.contains(book3));
    }

    @Test
    public void testSearchByYear() {
        List<Book> results = library.searchByYear(2002);
        assertEquals(1, results.size());
        assertEquals(book2, results.get(0));
    }

    @Test
    public void testGetAllBooks() {
        List<Book> allBooks = library.getAllBooks();
        assertEquals(3, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
        assertTrue(allBooks.contains(book3));
    }
}
