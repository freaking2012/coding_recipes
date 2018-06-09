package com.coding.recipes.dp;

/**
 * @author shubham1556
 * @created_on 09-Jun-2018
 * <p>
 * GFG: https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange {

    /**
     * @param set
     * @param coins
     * @param value
     * @return
     */
    static long getSolution(int[] set, int coins, int value) {

        // dp(i) tells the number ways Rs i can be represented using given set of coins
        long[] dp = new long[value + 1];

        for (int i = 0; i <= value; i++) {
            dp[i] = 0;
        }

        // use base case value to add 1 to mark a new way found
        dp[0] = 1;

        // iterate over all coins and update dp states
        for (int i = 0; i < coins; i++) {
            // starting with coin value till the target value
            for (int j = set[i]; j <= value; j++) {
                // Use set[i] coin
                dp[j] = dp[j] + dp[j - set[i]];
            }
        }

        return dp[value];
    }

    public static void main(String[] args) {
        System.out.println(CoinChange.getSolution(new int[] { 2, 5, 3, 6 }, 4, 10));
    }
}
