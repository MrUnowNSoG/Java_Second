package org.example;

public class Book extends Item {

    public String author;
    public String ISBN;
    public String yearPublication;

    public Book(String name, String author, String uniqueID, String ISBN, String yearPublication) {
        super(name, uniqueID);
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublication = yearPublication;
    }

    @Override
    public void borrowItem() {
        isBorrowed = true;
        System.out.println("З бібліотеки була взята книга: " + title);
    }

    @Override
    public void returnItem() {
        isBorrowed = false;
        System.out.println("В бібліотеку була повернута книга: " + title);
    }

    @Override
    public void DisplayItem() {
        System.out.println("Книга з назвою: " + title + ". " +
                yearPublication + " року видання. " +
                "За авторством: " + author);
    }
}
