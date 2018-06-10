package com.coding.recipes.dp;

/**
 * @author m.mishra
 * <p>
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-subsequence
 * <p>
 * More Examples:
 * <p>
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * <p>
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * <p>
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println(calculateLISTopDown(arr));
        System.out.println(calculateLISBottomUp(arr));
    }

    private static int calculateLISBottomUp(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    a[i] = Math.max(a[i], 1 + a[j]);
                }
            }
            max = Math.max(a[i], max);
        }
        return max;
    }

    private static int calculateLISTopDown(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            max = Integer.max(LIS(a, arr, i), max);
        }
        return max;
    }

    private static int LIS(int[] a, int[] arr, int ind) {
        int max = 1;
        if (a[ind] > 0) return a[ind];
        for (int i = 0; i < ind; i++) {
            if (arr[i] < arr[ind]) {
                max = Math.max(max, 1 + LIS(a, arr, i));
            }
        }
        a[ind] = max;
        return max;
    }
}
