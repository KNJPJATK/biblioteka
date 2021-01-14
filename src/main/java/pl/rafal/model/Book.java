package pl.rafal.model;

import java.util.Objects;

public class Book {

    private final String title;
    private final String author;
    private final String description;
    private final String isbn;

    private Reader borrower = null;

    public Book(String title, String author, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return borrower != null;
    }

    public boolean borrow(Reader reader) {
        if (isBorrowed() && !borrower.equals(reader)) {
            return false;
        }
        this.borrower = reader;
        return true;
    }

    public boolean returnBook() {
        if (! isBorrowed()) {
            return false;
        }
        this.borrower = null;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getTitle().equals(book.getTitle()) &&
                getAuthor().equals(book.getAuthor()) &&
                Objects.equals(getDescription(), book.getDescription()) &&
                getIsbn().equals(book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowed=" + isBorrowed() +
                ", borrower=" + borrower +
                '}';
    }
}
