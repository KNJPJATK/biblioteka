package pl.rafal.model;

import java.util.HashMap;
import java.util.Map;

public class BookCatalog {

    private static BookCatalog instance;

    BookCatalog() {}

    public static BookCatalog getInstance() {
        if (instance == null) {
            instance = new BookCatalog();
        }
        return instance;
    }

    private final Map<Book, Integer> catalog = new HashMap<>();

    public boolean isBookPresent(String title) {
        return catalog
                .keySet()
                .stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    boolean isBookPresent(Book book) {
        return catalog.containsKey(book);
    }

    public void addBookToCatalog(Book book) {
        if (isBookPresent(book)) {
            Integer qty = catalog.get(book);
            catalog.put(book, qty+1);
        } else {
            catalog.put(book, 1);
        }
    }

}
