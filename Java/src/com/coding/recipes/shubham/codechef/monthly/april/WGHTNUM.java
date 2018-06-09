package com.coding.recipes.shubham.codechef.monthly.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Year: 2018
 * https://www.codechef.com/APRIL18B/problems/WGHTNUM
 */
public class WGHTNUM {

    public static long MOD = 1000000007L;

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(br.readLine());
        while (t-- > 0) {
            String[] in = (br.readLine()).split(" ");

            long num = Long.parseLong(in[0]);
            long wt = Long.parseLong(in[1]);

            long ans = computePower(num - 2L);
            System.out.println((ans * getMultiplier(wt)) % MOD);
        }
    }

    /**
     * @param i
     * @return
     */
    public static long computePower(long i) {
        long result = 1L;
        long a = 10L;
        while (i > 0) {
            if ((i & 1) == 1) {
                result = (result * (a % MOD)) % MOD;
            }
            i >>= 1;
            a = ((a % MOD) * (a % MOD)) % MOD;
        }
        return result;
    }

    public static long getMultiplier(long wt) {
        if (Math.abs(wt) > 9L) {
            return 0L;
        }
        if (wt < 0) {
            return 10L + wt;
        } else {
            return 9L - wt;
        }
    }
}
