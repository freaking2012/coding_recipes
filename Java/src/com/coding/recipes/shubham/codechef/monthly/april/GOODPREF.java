package com.coding.recipes.shubham.codechef.monthly.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Year: 2018
 * https://www.codechef.com/APRIL18B/problems/GOODPREF
 */
public class GOODPREF {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");

            long n = Long.parseLong(input[1]);
            int len = input[0].length();

            long ans = 0, delta = 0, preDelta = 0;
            long A = 0, B = 0;

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < len; i++) {
                    if (input[0].charAt(i) == 'a') {
                        A++;
                    } else {
                        B++;
                    }
                    if (A > B) {
                        ans++;
                        delta++;
                    }
                }
                if (delta == preDelta) {
                    ans = ans + (n - j - 1) * delta;
                    break;
                } else {
                    preDelta = delta;
                    delta = 0;
                }
            }
            System.out.println(ans);
        }
    }
}
