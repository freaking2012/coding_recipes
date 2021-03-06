package com.coding.recipes.miscellaneous;

import java.io.IOException;

/**
 * Created by shubham on 6/30/17.
 */

/**
 * KMP: https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 * A string matching algorithm that finds whether a pattern is present in the text.
 */

public class KMPPatternMatching_S {
    private int[] prefixArrayComputation(char pattern[]) {

        /**
         * the longestPrefixSuffix Array stores for each index - i, the length of longest substring from 0 to i which
         * is prefix as well as suffix of substring(0 to i)
         *
         * It aids in O(n+m) complexity instead of O(n*n), as in case of mismatch while comparing pattern with text, we
         * don't start over the match with zeroth index of pattern, but we leverage the matches done so far and avoiding
         * rematching again the longest prefix which is also suffix.
         */
        int longestPrefixSuffix[] = new int[pattern.length];
        int j = 0, i;

        for (i = 1; i < pattern.length; ) {
            if (pattern[j] == pattern[i]) {
                longestPrefixSuffix[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    longestPrefixSuffix[i] = 0;
                    i++;
                } else {
                    j = longestPrefixSuffix[j - 1];
                }
            }

        }
        return longestPrefixSuffix;
    }

    public boolean KMPMatch(char text[], char pattern[]) {
        int lps[] = prefixArrayComputation(pattern);
        int i = 0, j = 0;

        while (i < text.length && j < pattern.length) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else {
                    /**
                     * Going to position of longest prefix which is also suffix in the pattern substring(0,i-1) and not
                     * starting over the match from 0th index.
                     */
                    j = lps[j - 1];
                }
            }
        }

        if (j == pattern.length)
            return true;
        else
            return false;
    }


    public static void main(String args[]) throws IOException {
        String text = "shubhshubham";
        String pattern = "shubhamr";
        KMPPatternMatching_S obj = new KMPPatternMatching_S();
        System.out.println("Running test 1.");
        boolean ans = obj.KMPMatch(text.toCharArray(), pattern.toCharArray());
        System.out.println("ANS: " + ans);

    }
}
