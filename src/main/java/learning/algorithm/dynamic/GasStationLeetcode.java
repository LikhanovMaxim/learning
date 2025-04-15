package learning.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

public class GasStationLeetcode {
    /**
     * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param gas
     * @param cost
     * @return
     */
    // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // sum [-2, -2, -2, 3, 3]. Sum <0 then
    // [1 20 21] [30 1 1]
    // sum [-29, 19, 20]
    // sum [19, -29, 20]
    // sum [i] = gas[i] - cost[i]
    // sum [0 0 0]
    // [1 2 3] [1 2 3]
    // fori start
    // forj
    //         check tank += gas[j] - cost[j]
    //            tank>0 then j++
    // 1) find Max 2) and travel fori;

    //gas = [5,1,2,3,4]
    //cost =[4,4,1,5,1]
    //    sum  [1,-3,1,-2,3]
    //    part [1, -2, -1, -3, 0]

    // sum [19, -29, 20] = > [0, -10, 20]
    //[-2, -3, 120, -100, -20, 30]
    //-2 -3 0 20, 0, 30
    //[-2, -3, 120, -500, -20, 3000]
    //[-2, -5, 113, -///, -//, 3000]
    //-2 -3 0 -380, -400, 30
    //[0...0] [0...0]
    // !!!! Time Limit Exceeded
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) {
            return -1;
        }
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] >= 0) {
                int tank = 0;
                for (int j = i; j < i + diff.length; j++) {
                    tank += diff[j % diff.length];
                    if (tank < 0) break;
                }
                if (tank >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }

//    TODO here need faster
    //gas = [5,1,2,3,4]
    //cost =[4,4,1,5,1]
    //diff  [1,-3,1,-2,3]
//      sum  1 -2, -1, -3, 0
//    case 2
//     [100, 0, 0]
//     [50, 10, 10]
//      50 -10 -10
//  sum 50  40  30
    //Dynamic
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int isExistWay = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
            isExistWay += diff[i];
        }
        if (isExistWay < 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            map.put(sum, i);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() > max) {
                max = e.getKey();
            }
        }
        return map.getOrDefault(max, -1);
    }
}
