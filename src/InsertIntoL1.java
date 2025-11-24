import java.util.ArrayList;
import java.util.List;
class InsertIntoL1 {
    public static void insertIntoL1(List<Integer> L1, List<Integer> L2) {
        for (Integer elem : L2) {
            // Находим позицию для вставки
            int pos = 0;
            while (pos < L1.size() && L1.get(pos) < elem) {
                pos++;
            }
            L1.add(pos, elem); // Вставляем в нужную позицию
        }
    }
}