package com.coding.recipes.miscellaneous;

import java.util.Scanner;

/*
Author: Manu Mishra
Created On: 29-Jun-2017
This program takes a number n, and prints a n X n grid in sprial form
For ex: n = 3
1 2 3
8 9 4
7 6 5

*/
public class Spiral_M {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = s.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				int res = valueAtPos(i,j,n);
				if(res<10)
					System.out.print(res+"  ");
				else
					System.out.print(res+" ");
			}
			System.out.println();
		}
		
	}

	private static int valueAtPos(int i, int j,int n) {

		int topLeftIndex = min(min(i,n+1-i),min(j,n+1-j));
		int topLeftValue  = 4*(topLeftIndex-1)*(n-(topLeftIndex-1))+1;
		int increment;
		int elementsInEachRow = n-2*(topLeftIndex-1);
		int lastIndex = n - (topLeftIndex-1);
		
		if(topLeftIndex == i||topLeftIndex == (n+1-i))
		{
			if(topLeftIndex == i)		//Top Row
				increment = j-topLeftIndex;
			else						//Bottom Row
				increment =  2*elementsInEachRow-2+ (lastIndex-j);
			
		}
		else
		{
			if(topLeftIndex == j)			//LeftColumn
				increment = 3*elementsInEachRow - 3 + lastIndex-i;
			else							//RightColumn
				increment = elementsInEachRow-1 +  (i-topLeftIndex);
		}
			
			
		
		return increment+topLeftValue;
	}

	private static int min(int j, int i) {
		return i<j?i:j;
	}
}
