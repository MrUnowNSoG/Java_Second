package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Батько Горіо", "Оноре де Бальзак", "12624563", 1835));
        library.addBook(new Book("Божественна комедія", "Данте Аліг'єрі", "1834564", 1265));
        library.addBook(new Book("Замок", "Франц Кафка", "1446563", 1926));
        library.addBook(new Book("Голод", "Кнут Гамсун", "6434546", 1819));

        library.displayBooks();


        System.out.println("Test find at name: ");
        library.findBookByTitle("C# для усіх");
        library.findBookByTitle("Божественна комедія");


        System.out.println("Test remove at ISBN: ");
        library.removeBookByISBN("2452564");
        library.removeBookByISBN("1446563");

        library.displayBooks();
    }
}