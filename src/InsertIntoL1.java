import java.util.ArrayList;
import java.util.List;

public class InsertIntoL1 {
    // Свойства класса
    private List<Integer> targetList;   // Список, в который вставляем элементы
    private List<Integer> sourceList;    // Список с элементами для вставки


    public InsertIntoL1(List<Integer> target, List<Integer> source) {
        if (target == null) {
            throw new IllegalArgumentException("Целевой список не может быть null");
        }
        if (source == null) {
            throw new IllegalArgumentException("Исходный список не может быть null");
        }
        this.targetList = new ArrayList<>(target);  // Копируем, чтобы не изменять внешний объект
        this.sourceList = new ArrayList<>(source);
    }

    /**
     * Вставляет элементы sourceList в targetList с сохранением отсортированного порядка.
     */
    public void insert() {
        for (Integer elem : sourceList) {
            // Находим позицию для вставки
            int pos = 0;
            while (pos < targetList.size() && targetList.get(pos) < elem) {
                pos++;
            }
            targetList.add(pos, elem);
        }
    }

    /**
     * Возвращает модифицированный целевой список.
     */
    public List<Integer> getResult() {
        return new ArrayList<>(targetList);
    }

    /**
     * Строковое представление объекта.
     */
    @Override
    public String toString() {
        return "InsertIntoL1{" +
                "targetList=" + targetList +
                ", sourceList=" + sourceList +
                "}";
    }
}
