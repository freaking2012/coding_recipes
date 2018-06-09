package com.coding.recipes.dp;

/**
 * @author m.mishra
 */
public class GoldMine {
    /*Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is
    the amount of gold in tons.
    Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\)
    that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally
    down towards the right. Find out maximum amount of gold he can collect.

            Examples:

    Input : mat[][] = {{1, 3, 3},
        {2, 1, 4},
        {0, 6, 4}};
    Output : 12
    {(1,0)->(2,1)->(2,2)}

    Input: mat[][] = { {1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}};
    Output : 16
            (2,0) -> (1,1) -> (1,2) -> (0,3) OR
            (2,0) -> (3,1) -> (2,2) -> (2,3)

    Input : mat[][] = {{10, 33, 13, 15},
        {22, 21, 04, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}};
    Output : 83
    */

    public static void main(String[] args) {

        int mat[][] = {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        System.out.println(calculateMaxGold(mat, 4, 4));
    }

    private static int calculateMaxGold(int[][] mat, int n, int m) {

        int a[][] = new int[n + 2][m + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                a[j][i] = mat[j - 1][i - 1] + max(a[j - 1][i - 1], a[j][i - 1], a[j + 1][i - 1]);
                if (a[j][i] > max) {
                    max = a[j][i];
                }
            }
        }
        return max;
    }

    private static int max(int a, int b, int c) {
        return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
    }
}
