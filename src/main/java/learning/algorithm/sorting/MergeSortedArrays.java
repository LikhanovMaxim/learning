package learning.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside
the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
denote the elements that should be merged, and the last n elements are set to 0 and should
be ignored. nums2 has a length of n.


 */
public class MergeSortedArrays {
    /*
    1) fori nums2
        find the place to put
        shift nums1 by 1 step
        set nums[i]
    time O(N^2)

    2)
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]

    if n == 0 return;

    start with i=m-1 and j = n-1 (end nums2)
    while j >= 0
        set max of i & j to the end
        check that i>=0;
        if j max
            j--
        if i max
            i--

    [0]  [1]

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]

    [1,3,5,0,0,0]  [-1,2,4]

    [-1,1,2,3,4,5]
    i=2, 1 0
    j=2  1 0 -1
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;
        while (j >= 0 && k >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }
    }

}
