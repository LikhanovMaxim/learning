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
     * account= 10 [50 10 5 2 7 3 ]
     *
     * @param args
     */

    /**
     * * проходим по листу
     * * проверяем есть ли совпадение
     * * кладем в коллекцию банкноту которую нужно найти
     * time O(N)
     * space O(N)
     */
    public static Integer findIdealBanknotes(int receipt, List<Integer> wallet) {
        Set<Integer> needToIndex = new HashSet<>();
        for (Integer current : wallet) {
            if (needToIndex.contains(current)) {
                System.out.println("Found " + current + " and " + (receipt - current));
                return current;
            }
            needToIndex.add(receipt - current);
        }
        System.out.println("Cannot find banknotes for " + receipt);
        return -1;
    }
}
