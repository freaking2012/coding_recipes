/**
 * 
 */
package com.coding.recipes.dp;

/**
 * @author m.mishra
 * @created_on 09-Jun-2018
 * Takes input a integer n and returns nth fibonacci number
 * 
 * Input
 * 4
 * 7
 * Output
 * 3
 * 13
 */
public class Fibonacci {

	public static void main(String[] args) {
		
		int n = 7;
		System.out.println("Top Down Approach");
		System.out.println(fibtopDown(n));
		System.out.println("Bottom Up Approach");
		System.out.println(fibBottomUp(n));
	}

	/**
	 * @param n
	 * @return
	 */
	private static int fibBottomUp(int n) {
		int a[] = new int[n+1];
		a[0] = 0;
		a[1] = 1;
		for(int i=2;i<=n;i++) {
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}

	/**
	 * @param n
	 * @return
	 */
	private static int fibtopDown(int n) {
		
		int a[] = new int[n+1];
		return fibMemoization(n,a);
	}

	/**
	 * @param n
	 * @param a
	 * @return
	 */
	private static int fibMemoization(int n, int[] a) {
		
		if(n==0 || n==1) {
			a[n] = n;
			return a[n];
		}
		if(a[n] > 0)
			return a[n];
		a[n] = fibMemoization(n-1,a) + fibMemoization(n-2,a);
		return a[n];
	}
	
	
}
