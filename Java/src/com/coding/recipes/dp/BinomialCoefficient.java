package com.coding.recipes.dp;

/**
 * @author shubham1556
 * @created_on 09-Jun-2018
 * <p>
 * GFG: https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * <p>
 * Time = O(n*k)
 */
public class BinomialCoefficient {


    /**
     * We know ncr = n-1Cr-1 + n-1Cr
     *
     * @param n
     * @param r
     * @return
     */
    static long getnCr(int n, int r) {

        long[][] dp = new long[n + 1][r + 1];

        // Bottom Up Approach
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(r, i); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][r];
    }

    public static void main(String[] args) {
        System.out.println(BinomialCoefficient.getnCr(5, 2));
    }
}
