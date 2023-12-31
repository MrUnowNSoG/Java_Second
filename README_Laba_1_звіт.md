План розробки програми для Laba_1:

1. Аналіз Вимог
Визначення ключових вимог програми: додавання, видалення, пошук та відображення книг.
Уточнення атрибітів книги: назва, автор, номер ISBN, рік видання.
2. Планування
Розробка загального плану програми та її структуру.
Визначення, які класи будуть потрібні (наприклад, Book і Library).
3. Розробка Класу Book
Створення класу Book з полями для назви, автора, ISBN і року видання.
Додавання конструктора, геттери та сеттери, метод toString().
4. Розробка Класу Library
Створення класу Library, який використовує ArrayList для зберігання об'єктів Book.
Реалізування методу для додавання, видалення, пошуку за назвою та відображення всіх книг.
5. Реалізація Логіки Програми
Реалізузація логіки для взаємодії з користувачем, наприклад, через консольний інтерфейс.
6. Тестування
Розробка тестового сценарію за допомогою JUnit.
Тест кожної функцій (додавання, пошук, видалення, відображення).
7. Рефакторинг і Оптимізація
Переглядання коду на предмет можливих покращень та оптимізації.
Оформлення коду більш читабельним та ефективним.
8. Завершення
Перевірка, що всі вимоги задоволені.
Завершення роботи над проектом.


Послідовність Виконаних Дій в Програмі
1) Створення Книги: Користувач вводить деталі книги, і вона додається до бібліотеки.
2) Відображення Книг: Програма показує список всіх книг у бібліотеці.
3) Пошук Книги за Назвою: Користувач вводить назву книги, і програма відображає відповідну книгу, якщо вона є в бібліотеці.
4) Видалення Книги: Користувач вводить ISBN книги, і вона видаляється з бібліотеки, якщо існує.