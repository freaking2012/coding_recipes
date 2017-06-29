package com.coding.recipes.miscellaneous;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by shubham on 6/28/17.
 */
public class Spiral_S {

    /**
     * given a N X N matrix print its element in spiral order starting with left to right, top to bottom
     */

    int[][] arr;
    int order;
    int count;

    private void peelLayer(int layer, int col) {
        col--;

        //LEFT -> RIGHT
        for (int i = layer; i <= col; i++) {
            count++;
            System.out.println(arr[layer][i]);
        }

        //TOP -> BOTTOM
        for (int i = layer + 1; i <= col - 1; i++) {
            count++;
            System.out.println(arr[i][col]);
        }

        //RIGHT -> LEFT
        for (int i = col; i >= layer; i--) {
            count++;
            System.out.println(arr[col][i]);
        }

        //BOTTOM -> TOP
        for (int i = col - 1; i >= layer + 1; i--) {
            count++;
            System.out.println(arr[i][layer]);
        }
    }

    public static void main(String args[]) throws IOException {
        Reader s = new Reader();
        Spiral_S obj = new Spiral_S();

        int i, n, layers;
        n = s.nextInt();
        obj.arr = new int[n][n];
        obj.count = 0;
        obj.order = n;

        layers = n / 2;


        //fill input array
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                obj.arr[i][j] = s.nextInt();
            }
        }

        for (i = 0; i < layers; i++) {
            obj.peelLayer(i, n--);
        }

        //print the center most element of odd ordered array
        if (obj.count == (obj.order * obj.order - 1) && ((obj.order & 1) != 0))
            System.out.println(obj.arr[n - 1][n - 1]);
    }
}