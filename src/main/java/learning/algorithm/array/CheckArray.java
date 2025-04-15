package learning.algorithm.array;

import lombok.val;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArray {
}

//Условие задачи
//Мы любим проводить соревнования, — недавно мы устроили чемпионат по шагам. И вот настало время подводить итоги!
//
//Необходимо определить userIds участников, которые прошли наибольшее количество шагов steps за все дни, не пропустив ни одного дня соревнований.
//
//        Пример
//# Пример 1
//        # ввод
//statistics = [
//        [{ userId: 1, steps: 1000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 1000 }]
//        ]
//
//        # вывод
//        champions = { userIds: [2], steps: 2500 }
//
//        # Пример 2
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }]
//        ]
//
//        # вывод
//        champions = { userIds: [1, 2], steps: 5500 }
//
//        # Пример 3
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 2, steps: 1000 }, { userId: 1, steps: 2000 }]
//        ]
//
//        # Пример 4
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 1, steps: 2000 }]
//        ]
//champions = { userIds: [], steps: 0 }
//
//        # Пример 5
//statistics = []
//champions = { userIds: [], steps: 0 }
//
//        # Пример 6
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 1, steps: 2000 }]
//        ]
//champions = { userIds: [], steps: 0 }
//
//
//
//
//
//        {1, 2}
//        {1}
//
//res= {1}
//
//// Map<Integer, Integer> countSteps;
//// List<Integer> skipDayUser;
//
//class Static{
//    Integer userId;
//    Integer steps;
//}
//
//// time - O(N * M + U + U) = O(N*M)
//// space - O(U)
//class Solution{
//    Pair<List<Integer>, Integer> calculate(List<List<Static>> statistics){
//        //Integer sizeDays = 3. statistics.lenght=4
//        // left = steps, right = sizeDays
//        Map<Integer, Pair<Integer, Integer>> countSteps = new HashMap();
//        //List<Integer> skipDayUsers;
//        /**
//         # Пример 7
//         statistics = [
//         [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//         [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//         [{ userId: 2, steps: 1000 }]
//         [{ userId: 1, steps: 100_000 }, { userId: 2, steps: 2000 }]
//         ]
//         champions = { userIds: [2], steps: 5000 }
//         **/
//        fori(int i=0; i<statistics.lenght; i++){
//            List<Static> statistics2 = statistics.get(i);
//            forj(j=0; j<statistics2; j++){
//                Pair<> pair = countSteps.get(statics.getUserId());
//                // check nulls
//                countSteps.put(statics2[j].getUserId(), new Pair(pair.getLeft + statistics2[j].getSteps , pair.getRight + 1)
//                        //countSteps.put(statics.getUserId(), countSteps.getOrDefault(statics.getUserId(), 0) + statistics2.getSteps);
//
//            }
//        }
//        // [{1, {105_500, 3}, {2, {7500, 4}}]
//        List<Integer> champions = new ArrayList();
//        int max = 0;
//        for(Map.entry entry: countSteps.entrySet()){
//            val value = entry.getValue();
//            if (value.getRight < statics.length){
//                continue;
//            }
//            if(value.getLeft>max){
//                max= value.getLeft();
//            }
//        }
//        //max=7500
//        for(Map.entry entry: countSteps.entrySet()){
//            val value = entry.getValue();
//            if(value.getLeft == max && value.getRight == statics.length){
//                champions.add(entry.getKey());
//            }
//        }
//        return new Pair(champions, max);
//        //{[1], 7500}
//    }
//}
//
//
//Условие задачи
//На размещено множество товаров, каждый из которых представлен числом. У каждого покупателя есть потребность в товаре, также выраженная числом.
//Если точного товара нет, покупатель выбирает ближайший по значению товар, что вызывает неудовлетворённость, равную разнице между его потребностью и купленным товаром.
//Количество каждого товара не ограничено, и один товар могут купить несколько покупателей.
//Рассчитайте суммарную неудовлетворённость всех покупателей.
//
//Нужно написать функцию, которая примет на вход два массива: массив товаров и массив потребностей покупателей, вычислит сумму неудовлетворённостей
//всех покупателей и вернет результат в виде числа.
//
//Пример
//# Пример
//# ввод
//goods = [8, 3, 5]
//buyerNeeds = [5, 6]
//        # вывод
//        res = 1 # первый покупатель покупает товар 5 и его неудовлетворённость = 0, второй также покупает товар 5 и его неудовлетворённость = 6-5 = 1
//
//        # Пример
//# ввод
//goods = [8, 3, 5]
//buyerNeeds = [2, 10]
//        # вывод
//        res = 1 + 2 = 3
//
//
//# Пример
//# ввод
//goods = [8, 3, 5]
//buyerNeeds = [2, 2, 2]
//        # вывод
//        res = 1 + 1 + 1 = 3
//
////sort goods
//// res = 0
//// fori buyerNeeds
////     binary
////     res+=max -  buyerNeeds[i]
//
//// goods = [8, 3, 5]. [3, 5, 8]
//// buyerNeeds = [5, 6]
//
//
//# Пример
//# ввод
//goods = [8]
//buyerNeeds = [5]
//
//
//goods = [7,10]
//buyerNeeds = [8]
//// time - O(NlogN + N * M)
//// space - O(1 + N);
//class Solution{
//    res calc(List<Int> goods, List<Int> buyerNeeds){
//        val sortGoods = Arrays.sort(goods);
//        val res = 0;
//        //
//// goods = [8, 3, 5], 3, 5,8
//// buyerNeeds = [5, 6]
//        fori (buyerNeeds) {
//            val find=buyerNeeds[i];
//            //index outbox
//            forj(sortGoods) {
//                if(find 8 <= 10 sortGoods[j]){
//                    break;
//                }
//            }
//            j=1;
//            //index if
//            val f1 = abs(find - sortGoods[j]);
//            //f1 =2
//            //index if
//            val f2 = abs(find - sortGoods[j-1]);
//            // f2 = 8-7 = 1
//            res+=min(f1, f2);
//            // res = 1
//        }
//        return res;
//    }
//}










