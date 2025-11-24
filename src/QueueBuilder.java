import java.util.*;

public class QueueBuilder {

    public static Queue<Integer> buildQueueFromList(List<Integer> L) {
        Queue<Integer> queue = new LinkedList<>(); // Используем LinkedList как реализацию Queue


        // Добавляем элементы из списка L в очередь
        for (Integer item : L) {
            queue.offer(item);
        }

        // Создаём зеркальную копию списка L (в обратном порядке)
        List<Integer> reversed = new ArrayList<>(L);
        Collections.reverse(reversed);

        // Добавляем зеркальные элементы в очередь
        for (Integer item : reversed) {
            queue.offer(item);
        }

        return queue;
    }
}