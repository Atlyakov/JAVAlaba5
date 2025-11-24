public class Cat implements Meowable {
    private String name;

    // Конструктор
    public Cat(String name) {
        this.name = name;
    }

    // Метод мяуканья (реализует интерфейс Meowable)
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Метод для получения текстовой формы "кот: Имя"
    @Override
    public String toString() {
        return "кот: " + name;
    }
}
