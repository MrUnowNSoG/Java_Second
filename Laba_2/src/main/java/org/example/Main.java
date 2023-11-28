package org.example;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        //Add Book
        library.add(new Book("Батько Горіо", "Оноре де Бальзак", "12624563", "1251","1835"));
        library.add(new Book("Божественна комедія", "Данте Аліг'єрі", "1834564", "1241","1265"));
        library.add(new Book("Замок", "Франц Кафка", "1446563", "1231","1926"));
        library.add(new Book("Голод", "Кнут Гамсун", "6434546", "1281","1819"));

        //Add DVD
        library.add(new DVD("Коротко про C#", "3462256", 120));
        library.add(new DVD("Коротко про Base Date", "3462253", 30));
        library.add(new DVD("Klavdia Petrivna — Я щаслива", "3462223", 2));

        System.out.println();
        System.out.println("Перевірка чи можна добавити 2 предмета з одинаковим ID");
        library.add(new Book("Голод", "Кнут Гамсун", "6434546", "1281","1819"));
        System.out.println();

        //Remove Item
        library.remove(library.GetItem(5));
        System.out.println();

        //Add patron
        library.registerPatron(new Patron("Alex", "1"));
        library.registerPatron(new Patron("Konstantunopoli", "32"));
        System.out.println();
        library.registerPatron(new Patron("Tretii", "1"));
        System.out.println();

        //Borrow Item
        library.LendItem(library.GetPatron(0), library.GetItem(4));
        library.LendItem(library.GetPatron(1), library.GetItem(1));
        System.out.println();
        library.listBorrowed();
        System.out.println();

        //Return Item
        library.ReturnItem(library.GetPatron(0), library.GetItem(4));
        System.out.println();
        library.listBorrowed();
        System.out.println();

        //Show info
        System.out.println();
        library.listAvailable();
        System.out.println();
        library.listBorrowed();

        //Old
        library.findItemAtName("Голод");
    }
}
