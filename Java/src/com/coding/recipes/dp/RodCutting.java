package com.coding.recipes.dp;

/**
 * @author m.mishra
 * <p>
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example,
 * if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */
public class RodCutting {

    public static void main(String[] args) {

        int n = 8;
        int p[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(calculateMaxPrice(n, p));
    }

    private static int calculateMaxPrice(int n, int[] p) {
        int a[][] = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 0;
                } else if (i > j) {
                    a[i][j] = a[i - 1][j];
                } else {
                    a[i][j] = Math.max(a[i - 1][j], p[i - 1] + a[i][j - i]);
                }

            }
        }
        return a[n][n];
    }
}
