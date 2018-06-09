package com.coding.recipes.dp;

/**
 * @author shubham1556
 * @created_on 09-Jun-2018
 * <p>
 * GFG: https://www.geeksforgeeks.org/tiling-problem/
 */
public final class TilingProblem {

    private TilingProblem() {

    }

    /**
     * @param breadth
     * @return
     */
    static long getSolution(int breadth) {
        long[] dp = new long[breadth + 1];

        dp[0] = 0; // 2 X 0 floor do not exists
        dp[1] = 1; // 2 X 1 floor has single way to tile
        dp[2] = 2; // 2 X 2 fllor can be tiled in 2 ways
        for (int i = 3; i <= breadth; i++) {
            // if first tile is put vertically; (ways: dp[i-1)
            // if first tile is put horizontally, you are bound to put the tile below it also horizontally; ways:
            // dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[breadth];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(TilingProblem.getSolution(5));
    }
}
