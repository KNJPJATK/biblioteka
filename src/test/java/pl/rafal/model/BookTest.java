package pl.rafal.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testIfBrandNewBookIsReadyToBorrow() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");

        // When:

        // Then:
        assertFalse("Nowy obiekt nie powinien być wypożyczony", book.isBorrowed());
    }

    @Test
    public void testBorrowBookForAReader() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");
        Reader reader = new Reader("Konrad", "Walenrod", "33");

        // When:
        boolean result = book.borrow(reader);

        // Then:
        assertTrue("Wypożyczenie nowej książki powinno się udać", result);
        assertTrue("Po udanym wypożyczeniu książka powinna być wypożyczona", book.isBorrowed());
    }

    @Test
    public void testIfBorrowedBookCannotBeBorrowedAgain() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");
        Reader reader1 = new Reader("Konrad", "Walenrod", "33");
        Reader reader2 = new Reader("Mikłaj", "Kopernik", "34");
        book.borrow(reader1);

        // When:
        boolean result = book.borrow(reader2);

        // Then:
        assertFalse("Wypożyczenie wypożyczonej książki nie może się udać", result);
        assertTrue("Po udanym wypożyczeniu książka powinna być wypożyczona", book.isBorrowed());
    }

    @Test
    public void testIfBorrowedBookCanBeBorrowedAgainForTheSameReader() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");
        Reader reader = new Reader("Konrad", "Walenrod", "33");
        book.borrow(reader);

        // When:
        boolean result = book.borrow(reader);

        // Then:
        assertTrue("Ponowne wypożyczenie dla tego samego czytelnika powinno się udać", result);
        assertTrue("Po udanym wypożyczeniu książka powinna być wypożyczona", book.isBorrowed());
    }

    @Test
    public void testIfBrandNewBookCannotBeReturned() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");

        // When:
        boolean result = book.returnBook();

        // Then:
        assertFalse("Nowa książka nie może być zwrócona", result);
    }

    @Test
    public void testIfBorrowedBookCanBeReturned() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");
        book.borrow(new Reader("Konrad", "Walenrod", "33"));

        // When:
        boolean result = book.returnBook();

        // Then:
        assertTrue("Wypożyczona książka powinna móc być zwrócona", result);
    }

    @Test
    public void testIfReturnedBookCanBeBorrowedAgain() {
        // Given:
        Book book = new Book(
                "DDD",
                "E E",
                "Desc",
                "ISBN");
        book.borrow(new Reader("Konrad", "Walenrod", "33"));
        book.returnBook();

        // When:
        boolean result = book.borrow(new Reader("Konrad", "Mickiewicz", "4"));

        // Then:
        assertTrue("Oddana książka może byż ponownie wypożyczona", result);
    }

}