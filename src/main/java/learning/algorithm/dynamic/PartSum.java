package learning.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

public class PartSum {

    /**
     * Дан массив целых чисел, нужно найти непустой подотрезок (непрерывную подпоследовательность)
     * с заданной суммой X,
     * либо сказать, что это невозможно.
     *
     * @return
     */
    public int sumSubstring(int[] arr, int k) {
        int res = 0;
        // в самом начале считаем, что ранее была найдена одна сумма равная 0
        // <Храним sum, кол-во раз>
        HashMap<Integer, Integer> partSum = new HashMap<>() {{
            put(0, 1);
        }};
        // идём по массиву и считаем сумму всех элементов до выбранного,
        // после чего добавляем к результату количество ранее найденных сумм значением
        // "S - k", где S - найденная сумма, k - заданная по условию искомая сумма
        // и увеличиваем счётчик для количества найденных сумм со значением S
        // на единицу
        int sum = 0;
        for (int n = arr.length - 1; n >= 0; n--) {
            sum += arr[n];
            res += partSum.getOrDefault(sum - k, 0);
            partSum.put(sum, partSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // arr = [1, 2, 3]; K = 3
//    sum    1,  3, 6
    //       1-3,3-3; 6-3
    //parSum 1;  1,3; 1,3,6
    //
    public int sumSubstring2(int[] arr, int k) {
        int res = 0;
        Map<Integer, Integer> parSum = new HashMap<>() {{
            put(0, 1);
        }};
        int sum = 0;//todo add a case
        for (int element : arr) {
            sum += element;
            if (parSum.get(sum - k) != null) {
                res++;
            }
            parSum.put(sum, parSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
