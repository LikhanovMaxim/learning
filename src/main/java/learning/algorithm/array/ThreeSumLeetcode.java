package learning.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSumLeetcode {

    /*
    [-1,0,1,2,-1,-4]
    [-4,-1,-1,0,1,2]
    -4
        -1 2, 0 2, 1, 2

    idea:
    - sort
    - fori
        j = i+1
        k = with end
        while j < k
            if sum==0 add
            if sum>0 need less k--
            if sum<0 need more so j++
    time O(NlogN + N^2) -> O(N2)
    space for sorting O(logN-N)
     */
    public List<List<Integer>> threeSumWithSort(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /*
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].

Input: nums = [0,0,0]
Output: [[0,0,0]]

Input: nums = [0,1,1]
Output: []

[1, 2, -3]
[3, 2]

O(N^2)
matrix[i][j] = num[i] + num[j]

1 2 =   3
1 -3 = -2

fork
find all equals in matrix
    add nums[k], matrix[i], matrix[j]

-1,0,1,2,-1
matrix
-1 0 = -1
-1 1 = 0
-1 2 = 1
-1 -1 = -2
0 1     1
0 2     2
0 -1   -1
1 2     3
1 -1    0
2 -1    1


1) brutforce
fori i = 0
forj j = i +1
    fork k = j+1
        if sums i, j, k = 0
            add to list
O(N^3)
2) []
Map<Sum все значений, Pair<index1, index2>>
for k
    values = map.getAllValues(-k);
    for v values
        get Indexes
        check that it is not equals with k
        //how to make distinct?

1, 2, 3
3 - 1,2
4,  1,3
5,  2,3


-1 -1 -1 1 1 1
0 0 0 0 0
 todo time limit with edge cases
 time O(N^2(sums) + N^2)
 space O(N)
*/
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }
        //
        Set<List<Integer>> result = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            List<int[]> values = map.get(-nums[k]);
            if (values == null) {
                continue;
            }
            for (int[] pair : values) {
                int i = pair[0];
                int j = pair[1];
                if (k <= i || k <= j) {
                    continue;
                }
                int[] triple = new int[]{nums[i], nums[j], nums[k]};
                Arrays.sort(triple);
                result.add(IntStream.of(triple)
                        .boxed()
                        .toList());
            }
        }
        return result.stream().toList();
    }
}
