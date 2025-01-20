import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        library.addBook(book);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testAddBookNull() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        library.addBook(book);
        boolean removed = library.removeBook(book);

        assertTrue(removed);
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveBookNotInLibrary() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        boolean removed = library.removeBook(book);

        assertFalse(removed);
    }

    @Test
    public void testRemoveBookNull() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    public void testGetBooks() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1");
        Book book2 = new Book("Title2", "Author2");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testGetBooksImmutable() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");
        library.addBook(book);

        List<Book> books = library.getBooks();
        assertThrows(UnsupportedOperationException.class, () -> books.add(new Book("Title2", "Author2")));
    }

    @Test
    public void testGetBookCount() {
        Library library = new Library();
        assertEquals(0, library.getBookCount());

        library.addBook(new Book("Title1", "Author1"));
        assertEquals(1, library.getBookCount());
    }
}
