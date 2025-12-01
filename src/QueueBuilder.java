import java.util.*;

/**
 * Класс для построения очереди на основе списка с зеркальным отражением элементов.
 */
public class QueueBuilder {
    // Свойства класса
    private List<Integer> sourceList;
    private Queue<Integer> resultQueue;

    /**
     * Конструктор по умолчанию.
     */
    public QueueBuilder() {
        this.sourceList = new ArrayList<>();
        this.resultQueue = new LinkedList<>();
    }

    /**
     * Конструктор с заданным списком.
     */
    public QueueBuilder(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Исходный список не может быть null");
        }
        this.sourceList = new ArrayList<>(source);
        this.resultQueue = new LinkedList<>();
    }

    /**
     * Строит очередь: сначала элементы исходного списка, затем их зеркальное отражение.
     */
    public Queue<Integer> buildQueue() {
        // Очищаем результат перед построением
        resultQueue.clear();

        // Добавляем элементы из исходного списка
        for (Integer item : sourceList) {
            resultQueue.offer(item);
        }

        // Создаём зеркальную копию (в обратном порядке)
        List<Integer> reversed = new ArrayList<>(sourceList);
        Collections.reverse(reversed);

        // Добавляем зеркальные элементы
        for (Integer item : reversed) {
            resultQueue.offer(item);
        }

        return resultQueue;
    }

    /**
     * Возвращает исходный список.
     */
    public List<Integer> getSourceList() {
        return new ArrayList<>(sourceList);
    }

    /**
     * Устанавливает новый исходный список.
     */
    public void setSourceList(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Исходный список не может быть null");
        }
        this.sourceList = new ArrayList<>(source);
    }

    /**
     * Возвращает текущую построенную очередь.
     */
    public Queue<Integer> getResultQueue() {
        return new LinkedList<>(resultQueue);
    }

    /**
     * Очищает текущую очередь.
     */
    public void clearQueue() {
        resultQueue.clear();
    }

    @Override
    public String toString() {
        return "QueueBuilder{" +
                "sourceList=" + resultQueue +
                "}";
    }
}
