Звіт

"Система банківського обслуговування"
Цей додаток є симуляцією банківської системи з функціоналом для створення облікових записів, депозитів і виведення коштів, а також переводів між обліковими записами. Він був створений за допомогою Java.

Зміст:

Вимоги
Інструкції користування
Архітектура програми
Процедура тестування
Вимоги:
Для роботи цього додатку необхідно мати встановлену Java.

Інструкції користування:
Запустіть додаток через ваше улюблене середовище для розробки або через командний рядок:

java Main

Ви матимете змогу створювати нові рахунки, здійснювати транзакції на вкладення та виведення коштів, а також робити переводи між рахунками.

Архітектура програми:
Проект включає кілька основних компонентів:

BankAccount.java: Визначає банківський рахунок, включаючи інформацію про номер рахунку, власника і баланс.
Bank.java: Описує банк з методами для управління рахунками та проведення транзакцій.
Main.java: Основний клас, що запускає програму.
InsufficientFundsException.java: Клас виключення, призначений для ситуацій з недостатнім балансом на рахунку.
NegativeAmountException.java: Обробляє випадки введення негативної суми.
AccountNotFoundException.java: Використовується для випадків, коли обліковий запис не може бути знайдений.

Тестування:
Програма включає тестування за допомогою JUnit, щоб переконатися в правильній роботі і обробці виняткових ситуацій.