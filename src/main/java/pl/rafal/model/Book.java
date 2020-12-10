package pl.rafal.model;

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
