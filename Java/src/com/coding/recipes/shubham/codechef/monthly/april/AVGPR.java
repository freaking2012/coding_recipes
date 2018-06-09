package com.coding.recipes.shubham.codechef.monthly.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Year: 2018
 * https://www.codechef.com/APRIL18B/problems/AVGPR
 */
public class AVGPR {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] in = br.readLine().split(" ");
            int[] seq = new int[n];

            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            Map<Integer, Long> universal = new HashMap<>();

            long ans = 0;

            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(in[i]);

                if (!universal.containsKey(seq[i])) {
                    universal.put(seq[i], 1L);
                    if ((seq[i] & 1) == 1) {
                        odd.add(seq[i]);
                    } else {
                        even.add(seq[i]);
                    }
                } else {
                    long oldCount = universal.get(seq[i]);
                    universal.put(seq[i], oldCount + 1);
                    ans = ans + (universal.get(seq[i]) - 1L);
                }
            }

            System.out.println(getCount(odd, universal) + getCount(even, universal) + ans);
            odd.clear();
            even.clear();
            universal.clear();
        }


    }

    /**
     * @param list
     * @param u
     * @return
     */
    public static long getCount(List<Integer> list, Map<Integer, Long> u) {
        long ans = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (u.containsKey((list.get(i) + list.get(j)) / 2)) {
                    ans += (u.get(list.get(j))) * (u.get(list.get(i)));
                    //System.out.println("(" + list.get(i) + "," + list.get(j) + ")");
                }
            }
        }
        return ans;
    }
}
