package learning.algorithm.array;

import java.util.Arrays;

public class FindBestGoods {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Solution s = new Solution();
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{0, 1, 2, 3, 4};
        // int[] a = new int[]{8, 3, 5};
        // int[] b = new int[]{2, 10};
        System.out.println(s.resolve(a, b));
    }

}

//Условие задачи
//На размещено множество товаров, каждый из которых представлен числом. У каждого покупателя есть потребность в товаре, также выраженная числом.
//Если точного товара нет, покупатель выбирает ближайший по значению товар, что вызывает неудовлетворённость, равную разнице между его потребностью и купленным товаром.
//Количество каждого товара не ограничено, и один товар могут купить несколько покупателей.
//Рассчитайте суммарную неудовлетворённость всех покупателей.
//
//Нужно написать функцию, которая примет на вход два массива: массив товаров и массив потребностей покупателей, вычислит сумму неудовлетворённостей
//всех покупателей и вернет результат в виде числа.
// goods.lenght>0
//
//Пример
//# Пример
//# ввод
//goods = [8, 3, 5]
//buyerNeeds = [5, 6]
//        # вывод
//        res = 1 # первый покупатель покупает товар 5 и его неудовлетворённость = 0, второй также покупает товар 5 и его неудовлетворённость = 6-5 = 1
//
//# ввод
//goods = [8, 3, 5]
//buyerNeeds = [2, 10]
//        # вывод
//        res = 1 + 2 = 3
//# ввод
//goods = [2, 3, 4]
//buyerNeeds = [2, 3]
//        # вывод
//        res = 0
//# ввод
//goods = [2, 3, 4]
//buyerNeeds = [1, 10]
//        # вывод
//        res = 1 + 6
/* 1 idea)
   - sorting good
   - fori buyerNeeds
        - binary search.
        - sum+= Min(good[j] - buyerNeeds[i], good[j+1] - buyerNeeds[i])
time O(NlogN + N logN)

2)
   - sorting good
   - fori buyerNeeds
        - forj <
3)
*/
class Solution {

    //# ввод
//goods = [8, 3, 5] - > 3,5,8
//buyerNeeds = [2, 10]  2 -> j = 0. 10 -> j=2
//        # вывод
//        res = 1 + 2 = 3
/*    idea:
    sort goods
    fori needs
        binary search
    time O(NlogN + NlogN)
    space sorting O(logN) in worst case O(N)
  */
    //todo create tests
    public int resolve(int[] goods, int[] buyerNeeds) {
        Arrays.sort(goods);
        int res = 0;
        for (int i = 0; i < buyerNeeds.length; i++) {
            int j = binarySearchOrLess(goods, buyerNeeds[i]);
            System.out.println("j = " + j);
            if (j + 1 < goods.length) {
                res += Math.min(Math.abs(buyerNeeds[i] - goods[j]), Math.abs(buyerNeeds[i] - goods[j]));
            } else {
                res += Math.abs(buyerNeeds[i] - goods[j]);
            }
        }
        return res;
    }

    /*
    1 3 5
    2
    min 0
    max 3
    middle 3

    7
    min 0 1, 2
    max 3
    index 1, 2
    middle 3

    1 2 3
    1
    min 0
    max 3 1
    index 1
    middle 3

    1 2 3
    2
    min 0
    max 3
    index 1
    middle 2

    3 5 8
    10
    min 0
    max 3
    index =
    */
    private int binarySearchOrLess(int[] goods, int find) {
        int min = 0;
        int max = goods.length;
        while (min < max - 1) {
            int index = (min + max) / 2;
            int middle = goods[index];
            if (find == middle) {
                return index;
            }
            if (find > middle) {
                min = index;
            } else {
                max = index;
            }
        }
        return min;
    }

}
