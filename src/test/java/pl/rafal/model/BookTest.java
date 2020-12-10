package pl.rafal.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void test() {
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
    public void test2() {
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
    public void test3() {
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
    public void test4() {
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

}