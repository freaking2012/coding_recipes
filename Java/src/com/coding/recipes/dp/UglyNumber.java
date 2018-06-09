package com.coding.recipes.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shubham1556
 * @created_on 09-Jun-2018
 * <p>
 * GFG: https://www.geeksforgeeks.org/ugly-numbers/
 */
public final class UglyNumber {

    private UglyNumber() {

    }

    /**
     * @param n -- the sequence number
     * @return -- Nth Ugly Number
     */
    static long getNthUglyNumber(int n) {
        List<Long> dp = new ArrayList<>();
        int i2, i3, i5;
        long nextMultipleOf2 = 2L, nextMultipleOf3 = 3L, nextMultipleOf5 = 5L;
        i2 = i3 = i5 = 0;

        dp.add(1L);

        for (int i = 1; i < n; i++) {
            dp.add(Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5)));
            if (dp.get(i).equals(nextMultipleOf2)) {
                i2++;
                nextMultipleOf2 = dp.get(i2) * 2L;
            }

            if (dp.get(i).equals(nextMultipleOf3)) {
                i3++;
                nextMultipleOf3 = dp.get(i3) * 3L;
            }

            if (dp.get(i).equals(nextMultipleOf5)) {
                i5++;
                nextMultipleOf5 = dp.get(i5) * 5L;
            }
        }

        return dp.get(n - 1);
    }

    /**
     * Driver
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(UglyNumber.getNthUglyNumber(150)); // 5832
    }
}
