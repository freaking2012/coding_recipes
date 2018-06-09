package com.coding.recipes.shubham.codechef.monthly.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Year: 2018
 * https://www.codechef.com/APRIL18B/problems/GOODPREF
 */

public class GOODPREF_slow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long n = Long.parseLong(input[1]);
            int len = input[0].length();
            long aCount = 0, bCount = 0, ans = 0;
            for (int j = 0; j < n; j++) {
                for (long i = 0; i < len; i++) {
                    if (input[0].charAt((int) i) == 'a') {
                        aCount++;
                    } else {
                        bCount++;
                    }
                    // is prefix till here a good one
                    if (aCount > bCount) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}