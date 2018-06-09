package com.coding.recipes.shubham.codechef.monthly.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Year: 2018
 * https://www.codechef.com/APRIL18B/problems/CHEFWORK
 */
public class CHEFWORK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Integer> workerCosts =
                Arrays.stream(br.readLine().split(" ")).map(r -> Integer.parseInt(r)).collect(Collectors.toList());

        List<Integer> workerTypes =
                Arrays.stream(br.readLine().split(" ")).map(r -> Integer.parseInt(r)).collect(Collectors.toList());

        int type1Best = 100001;
        int type2Best = 100001;
        int type3Best = 100001;

        for (int i = 0; i < t; i++) {
            switch (workerTypes.get(i)) {
                case 1:
                    type1Best = Integer.min(type1Best, workerCosts.get(i));
                    break;
                case 2:
                    type2Best = Integer.min(type2Best, workerCosts.get(i));
                    break;
                case 3:
                    type3Best = Integer.min(type3Best, workerCosts.get(i));
                default:
                    break;
            }
        }

        System.out.println(Integer.min(type1Best + type2Best, type3Best));
    }
}
