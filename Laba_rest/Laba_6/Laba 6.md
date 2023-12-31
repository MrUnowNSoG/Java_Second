Звіт 

"Кінотеатральний резерваційний додаток"
Цей додаток, створений на Java, втілює в собі управління кінотеатром із п'ятьма залами, кожен із яких містить 10 рядів по 20 місць. Він дозволяє користувачам бронювати, скасовувати бронювання, перевіряти доступність місць та шукати найоптимальніші місця для перегляду.

Ініціалізація залу:
Додаток використовує тривимірний масив для відтворення розташування місць у кінозалі. Зали, ряди та місця представлені в масиві, ініціалізованому нулями, які символізують вільні місця.

Основні функції:
Бронювання місць: Метод bookSeats дозволяє забронювати обрані місця, міняючи статус місць на зайняті.
Скасування бронювання: За допомогою cancelBooking, користувачі можуть скасувати раніше заброньовані місця.
Перевірка наявності місць: checkAvailability дозволяє перевірити, чи є достатньо вільних місць в зазначеному ряду та залі.
Пошук найкращих місць: findBestAvailable визначає найкращі місця залежно від кількості необхідних місць.

Використання додатку:
Щоб скористатися функціоналом, необхідно створити екземпляр класу Cinema та використовувати його методи для управління бронюванням:

java
Copy code
Cinema cinema = new Cinema(5, 10, 20); // ініціалізація кінотеатру

// Бронювання місць
int[] seats = {4, 5, 6};
try {
    cinema.bookSeats(1, 3, seats);
} catch (BookingException e) {
    System.out.println("Error in booking: " + e.getMessage());
}

Бонусні можливості:
Для додаткового функціоналу можна реалізувати autoBook, що автоматично знайде та забронює найкращі доступні місця на задану кількість осіб.