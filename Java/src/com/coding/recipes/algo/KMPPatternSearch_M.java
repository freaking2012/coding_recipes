package com.coding.recipes.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Searches for a pattern in the given string
Input
AABAACAADAABAABA
AABA

Output
Found pattern at index: 0
Found pattern at index: 9
Found pattern at index: 12
*/
public class KMPPatternSearch_M {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();
		printPatternInStr(str, pattern);
	}

	private static void printPatternInStr(String str, String pattern) {
		int prefixSuffixArray[] = new int[pattern.length()];
		fillPrefixSuffixArray(prefixSuffixArray,pattern);
		for(int i=0,j=0;i<str.length();i++)
		{
			if(str.charAt(i)!=pattern.charAt(j))
			{
				if(j!=0)
				{
					j = prefixSuffixArray[j-1];i--;
				}
			}
			else
			{
				j++;
			}
			if(j==pattern.length())
			{
				System.out.println("Found pattern at index: "+(i-pattern.length()+1));
				j -= pattern.length()-1;
				i -= pattern.length()-2;
			}
		}
		
	}

	private static void fillPrefixSuffixArray(int[] prefixSuffixArray,
			String pattern) {

		prefixSuffixArray[0]=0;
			for(int j=0,i=1;i<pattern.length();)
			{
				if(pattern.charAt(j)==pattern.charAt(i))
				{
					prefixSuffixArray[i] = j+1;
					i++;j++;
				}
				else
				{
					if(j==0)
					{
						prefixSuffixArray[i]=0;
						i++;
					}
					else
					{
						j = prefixSuffixArray[j-1];
					}
				}
			}
	}
}
