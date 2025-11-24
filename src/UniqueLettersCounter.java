import java.io.*;
import java.util.*;

public class UniqueLettersCounter {
    private String filename = "src/Input5.txt";

    // Метод для подсчёта уникальных букв
    public void countUniqueLetters() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Set<Character> uniqueLetters = new HashSet<>();

            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    char lowerC = Character.toLowerCase(c);
                    if (Character.isLetter(lowerC)) {
                        uniqueLetters.add(lowerC);
                    }
                }
            }

            System.out.println("Количество разных букв в тексте: " + uniqueLetters.size());
            System.out.println("Уникальные буквы: " + uniqueLetters);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Главный метод для запуска программы
    public static void main(String[] args) {
        UniqueLettersCounter counter = new UniqueLettersCounter();
        counter.countUniqueLetters();
    }
}
