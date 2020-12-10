package pl.rafal;

import pl.rafal.model.Book;
import pl.rafal.model.Reader;

public class Main {

    public static void main(String[] args) {
        Book book = new Book(
                "Domain Driven Design",
                "Eric Evans",
                "Some description...",
                "356789");
        Reader reader = new Reader(
                "Rafał",
                "Ja",
                "10");
        Reader reader2 = new Reader(
                "Kamil",
                "Boj",
                "290");

        System.out.println(book.borrow(reader));
        System.out.println(book.borrow(reader2));

        System.out.println(book);
        System.out.println(reader);
    }

}
