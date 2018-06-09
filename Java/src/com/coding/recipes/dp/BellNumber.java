package com.coding.recipes.dp;

/**
 * @author m.mishra
 * @created_on 09-Jun-2018
 * Bell Number (Number of ways to Partition a Set)
 * Given a set of n elements, find number of ways of partitioning it.
 * Input:  n = 2
 * Output: Number of ways = 2
 * Explanation: Let the set be {1, 2}
 * { {1}, {2} }
 * { {1, 2} }
 * <p>
 * Input:  n = 3
 * Output: Number of ways = 5
 * Explanation: Let the set be {1, 2, 3}
 * { {1}, {2}, {3} }
 * { {1}, {2, 3} }
 * { {2}, {1, 3} }
 * { {3}, {1, 2} }
 * { {1, 2, 3} }.
 * The output is called Bell number
 * First few Bell numbers are 1, 1, 2, 5, 15, 52, 203 (starts with index 0. ie. for n = 5, number is 52)
 * State transition formulta is S(n+1, k) = k*S(n, k) + S(n, k-1) here k = 1 to n
 * <p>
 * When we add a (n+1)’th element to k partitions, there are two possibilities.
 * 1) It is added as a single element set to existing partitions, i.e, S(n, k-1)
 * 2) It is added to all sets of every partition, i.e., k*S(n, k)
 * <p>
 * Therefore S(n+1, k) = k*S(n, k) + S(n, k-1) which means S(n, k) = k*S(n-1, k) + S(n-1, k-1)
 */
public class BellNumber {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(computeBellNumber(n));
    }

    /**
     * @param n
     */
    private static long computeBellNumber(int n) {


        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += calculateForKSubsets(n, i);
        }
        return sum;
    }

    /**
     * @param n
     * @param i
     * @return
     */
    private static long calculateForKSubsets(int n, int k) {
        int a[][] = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            a[i][0] = 0;
        }
        for (int i = 0; i <= k; i++) {
            a[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1 || i == j) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = j * a[i - 1][j] + a[i - 1][j - 1];
                }
            }
        }
        return a[n][k];
    }
}
