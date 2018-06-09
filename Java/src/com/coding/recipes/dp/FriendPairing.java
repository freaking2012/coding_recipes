package com.coding.recipes.dp;

/**
 * @author m.mishra
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single
 * or can be paired up.
 * <p>
 * Examples :
 * <p>
 * Input  : n = 3
 * Output : 4
 * <p>
 * Explanation
 * {1}, {2}, {3} : all single
 * {1}, {2,3} : 2 and 3 paired but 1 is single.
 * {1,2}, {3} : 1 and 2 are paired but 3 is single.
 * {1,3}, {2} : 1 and 3 are paired but 2 is single.
 * Note that {1,2} and {2,1} are considered same.
 * <p>
 * Input  : n = 4
 * Output : 10
 */
public class FriendPairing {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(calculatePairsBottomUp(n));
        System.out.println(calculatePairsTopDown(n));
    }

    private static int calculatePairsBottomUp(int n) {
        int a[] = new int[n + 1];
        for (int i = 0; i <= 2; i++) {
            a[i] = i;
        }
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + (i - 1) * a[i - 2];
        }
        return a[n];
    }

    private static int calculatePairsTopDown(int n) {
        int a[] = new int[n + 1];
        return calculatePairsTopDownApproach(a, n);
    }

    private static int calculatePairsTopDownApproach(int a[], int n) {

        if (a[n] > 0) {
            return a[n];
        }
        if (n <= 2) {
            return (a[n] = n);
        }
        return calculatePairsTopDownApproach(a, n - 1) + (n - 1) * calculatePairsTopDownApproach(a, n - 2);
    }
}
