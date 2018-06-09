package com.coding.recipes.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shubham1556
 * @created_on 09-Jun-2018
 * <p>
 * GFG: https://www.geeksforgeeks.org/program-nth-catalan-number/
 *
 * Time = O(n*n)
 */
public class CatalanNumber {

    /**
     * @param n
     * @return
     */
    static long getNthCatalanNumber(int n) {
        List<Long> dp = new ArrayList<>();

        dp.add(1L);
        dp.add(1L);


        for (int i = 2; i <= n; i++) {
            long thisCatalan = 0;
            for (int j = 0; j < i; j++) {
                thisCatalan += dp.get(j) * dp.get(i - j - 1);
            }
            dp.add(thisCatalan);
        }

        return dp.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(CatalanNumber.getNthCatalanNumber(10));
    }
}
