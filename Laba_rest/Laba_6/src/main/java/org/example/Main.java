package org.example;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);
        cinema.bookSeats(0, 3, new int[]{5, 6, 7});
        cinema.bookSeats(1, 5, new int[]{2, 3, 4, 5, 6});
        cinema.cancelBooking(0, 3, new int[]{6, 7});
        cinema.printSeatingArrangement(0);
        System.out.println("Наявність 3 послідовних місць: " + cinema.checkAvailability(0, 3));
        cinema.autoBook(2, 4);
        cinema.printSeatingArrangement(2);
    }
}
