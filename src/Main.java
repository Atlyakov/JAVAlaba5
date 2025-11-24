import java.util.*;
import java.io.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckErrors check = new CheckErrors();
        System.out.println("Выберите задание 1-8:");
        int choice = check.CheckNumber();

        switch (choice) {
            case 1:
                Fraction f1 = new Fraction(3, 4);
                Fraction f2 = new Fraction(-6, -8); // Эквивалентно 6/8 → 3/4 после нормализации

                Fraction f3 = new Fraction(1, 2);

                System.out.println(f1);           // "3/4"
                System.out.println(f1.getValue()); // 0.75

                System.out.println(f2);           // "3/4" (знак перенесён)
                System.out.println(f2.getValue()); // 0.75
                System.out.println("Одинаковые дроби?\n true (одинаковые числитель и знаменатель)\n false (разные)\n Результат: "); // true (одинаковые числитель и знаменатель)
                System.out.println(f1.equals(f2)); // true (одинаковые числитель и знаменатель)
                break;

            case 2:
                // Создаём кота
                Meowable m = new Cat("Барсик");

                // Передаём кота в метод meowsCare и получаем количество мяуканий
                int meowCount = Funs.meowsCare(m);

                // Выводим количество мяуканий
                System.out.println("Кот мяукал " + meowCount + " раз");

                break;

            case 3:
                List<Integer> L1 = new ArrayList<>(List.of(1, 3, 5, 7, 9));
                List<Integer> L2 = List.of(2, 4, 6, 8, 10);

                InsertIntoL1.insertIntoL1(L1, L2);

                System.out.println("L1 после вставки: " + L1);
                // Вывод: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                break;
            case 4:
                MultiSportCompetition competition = new MultiSportCompetition();
                competition.run();
                break;
            case 5:
                UniqueLettersCounter counter = new UniqueLettersCounter();
                counter.countUniqueLetters();
                break;
            case 6:
                List<Integer> L = Arrays.asList(1, 2, 3);
                // Строим очередь
                Queue<Integer> resultQueue = QueueBuilder.buildQueueFromList(L);
                // Выводим результат
                System.out.println("Полученная очередь: " + resultQueue);
                // Вывод: [1, 2, 3, 3, 2, 1]
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }

    }
}




