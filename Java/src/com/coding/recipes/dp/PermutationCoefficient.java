package com.coding.recipes.dp;

/**
 * @author m.mishra
 * Permutation refers to the process of arranging all the members of a given set to form a sequence.
 * The number of permutations on a set of n elements is given by n! , where “!” represents factorial.
 * The Permutation Coefficient represented by P(n, k) is used to represent the number of ways to obtain
 * an ordered subset having k elements from a set of n elements.
 * <p>
 * The coefficient can also be computed recursively using the below recursive formula:
 * <p>
 * P(n, k) = P(n-1, k) + k* P(n-1, k-1)
 * <p>
 * P(10, 2) = 90
 * P(10, 3) = 720
 * P(10, 0) = 1
 * P(10, 1) = 10
 */
public class PermutationCoefficient {
    public static void main(String[] args) {
        int n = 10;
        int k = 2;
        System.out.println(calculatePermutationCoefficientDP(n, k));
        System.out.println(calculatePermutationCoefficientSimple(n, k));
    }

    private static long calculatePermutationCoefficientSimple(int n, int k) {

        if (k > n) {
            return 0;
        }
        long coeff = 1;
        for (int i = n; i >= n - k + 1; i--) {
            coeff *= i;
        }

        return coeff;
    }

    private static long calculatePermutationCoefficientDP(int n, int k) {

        int a[][] = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > i) {
                    a[i][j] = 0;
                } else if (j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + j * a[i - 1][j - 1];
                }
            }
        }
        return a[n][k];
    }

}
