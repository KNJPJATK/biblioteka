package pl.rafal.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookCatalogTest {

    @Test
    public void testIfBookInCatalogCanBeFoundByTitle() {
        // Given:
        String bookTitle = "Brzydkie Kaczątko";
        BookCatalog bookCatalog = new BookCatalog();
        Book book = new Book(bookTitle, "Author", "Some desc", "12");
        bookCatalog.addBookToCatalog(book);

        // When:
        boolean result = bookCatalog.isBookPresent(bookTitle);

        // Then:
        assertTrue("Książka, która jest w katalogu powinna zostać znaleziona", result);
    }

    @Test
    public void testIfEmptyCatalogNotFindAnyBook() {
        // Given:
        BookCatalog bookCatalog = new BookCatalog();

        // When:
        boolean result = bookCatalog.isBookPresent("Any title");

        // Then:
        assertFalse("Pusty katalog nie powinien znaleźć książki", result);
    }

    @Test
    public void testIfNonExistingBookInCatalogCannotBeFound() {
        // Given:
        Book book = new Book("Some title", "Some author", "Some desc", "Some isbn");
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBookToCatalog(book);

        // When:
        boolean result = bookCatalog.isBookPresent("Some other title");

        // Then:
        assertFalse("Książka z tytułem niewystępującym w katalogu nie powinna być znaleziona", result);
    }

    @Test
    public void testIfNullTitledBookCannotBeFound() {
        // Given:
        BookCatalog bookCatalog = new BookCatalog();

        // When:
        boolean result = bookCatalog.isBookPresent((String) null);

        // Then:
        assertFalse("Null jako tytuł nie powinien być znaleziony w katalogu", result);
    }

}
