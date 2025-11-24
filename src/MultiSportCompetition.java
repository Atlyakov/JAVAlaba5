import java.io.*;
import java.util.*;

public class MultiSportCompetition {

    // Имя файла с данными
    private static final String FILENAME = "src/Input.txt";

    public void run() {
        Map<Integer, List<Participant>> scoreMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            // Читаем первую строку — количество участников
            String line = reader.readLine();
            if (line == null) {
                System.err.println("Файл пуст.");
                return;
            }
            int n = Integer.parseInt(line);


            // Обрабатываем каждую строку с данными участника
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                if (line == null) break;

                // Разбиваем строку на части (убираем пробелы в начале/конце)
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 6) {
                    System.err.println("Некорректная строка (мало данных): " + line);
                    continue;
                }

                // Извлекаем фамилию и имя
                String surname = parts[0];
                String name = parts[1];

                // Считаем сумму баллов (части 2–5 — это баллы)
                int total = 0;
                for (int j = 2; j <= 5; j++) {
                    total += Integer.parseInt(parts[j]);
                }

                // Добавляем участника в Map: ключ — сумма, значение — список участников
                if (!scoreMap.containsKey(total)) {
                    scoreMap.put(total, new ArrayList<>());
                }
                scoreMap.get(total).add(new Participant(surname, name));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Ошибка преобразования числа: " + e.getMessage());
            return;
        }

        // Сортируем суммы баллов по убыванию
        List<Integer> sortedScores = new ArrayList<>(scoreMap.keySet());
        sortedScores.sort(Collections.reverseOrder());

        // Определяем порог (3‑е место)
        int thresholdScore;
        if (sortedScores.size() <= 3) {
            thresholdScore = sortedScores.get(sortedScores.size() - 1); // последний элемент
        } else {
            thresholdScore = sortedScores.get(2); // третий по величине
        }

        // Выводим всех, кто вошёл в топ
        System.out.println("Лучшие участники:");
        for (int score : sortedScores) {
            if (score < thresholdScore) break; // дальше баллы меньше — выходим
            List<Participant> participants = scoreMap.get(score);
            for (Participant p : participants) {
                System.out.println(p);
            }
        }
    }
}