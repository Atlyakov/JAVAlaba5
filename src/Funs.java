public class Funs {
    public static int meowsCare(Meowable m) {
        int meowCount = 0; // счётчик мяуканий (локальный для метода)
        for (int i = 0; i < 5; i++) { // вызываем мяуканье 5 раз
            m.meow();
            meowCount++; // увеличиваем счётчик
        }
        return meowCount; // возвращаем количество мяуканий
    }
}
