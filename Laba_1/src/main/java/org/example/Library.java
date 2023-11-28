package org.example;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByISBN(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

