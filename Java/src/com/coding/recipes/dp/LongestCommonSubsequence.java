package com.coding.recipes.dp;

/**
 * @author m.mishra
 * <p>
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * <p>
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences
 * between two files), and has applications in bioinformatics.
 * <p>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(computeLCSTopDown(a, b));
        System.out.println(computeLCSBottomUp(a, b));
    }

    private static int computeLCSBottomUp(String a, String b) {
        int n = a.length();
        int m = b.length();
        int tab[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0||j==0) {
                    tab[i][j]=0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1)) {
                    tab[i][j]=tab[i-1][j-1] + 1;
                } else {
                    tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                }
            }
        }
        return tab[n][m];
    }

    private static int computeLCSTopDown(String a, String b) {
        int n = a.length();
        int m = b.length();
        return LCS(new int[n + 1][m + 1], a, b, n, m);
    }

    private static int LCS(int tab[][], String a, String b, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if(tab[n][m] > 0) {
            return tab[n][m];
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            tab[n][m] = 1 + LCS(tab, a, b, n - 1, m - 1);
        } else {
            tab[n][m] = Math.max(LCS(tab, a, b, n - 1, m), LCS(tab, a, b, n, m - 1));
        }
        return tab[n][m];
    }


}
