package learning.algorithm.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExampleT1 {

    /**
     * you have money.
     * value = {int > 0}
     * <p>
     * sum = 2 банкноты +
     * account=10 [50 10 5 2 7 3 ]
     *
     * @param args
     */

    /**
     * * проходим по листу
     * * проверяем есть ли совпадение
     * * кладем в коллекцию
     */
    public static Integer findIdealBanknotes(int receipt, List<Integer> wallet) {
        Set<Integer> needToIndex = new HashSet<>();
        int result = -1;
        for (Integer current : wallet) {
            if (needToIndex.contains(current)) {
                System.out.println("Found " + current + " and " + (receipt - current));
                result = current;
                break;
            }
            needToIndex.add(receipt - current);
        }
        if (result == -1) {
            System.out.println("Cannot find banknotes for " + receipt);
        }
        return result;
    }
}
