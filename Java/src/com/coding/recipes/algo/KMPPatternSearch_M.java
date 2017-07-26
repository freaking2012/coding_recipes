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
		//Filling prefixSuffixArray, it contains the length of prefixSuffix till the current index in pattern
		//prefixSuffix means current substring has chars as prefix which are same as chars as suffix.
		//If substring is abcdab then prefixSuffix length at location b will be 2 since ab is prefix and also suffix 
		fillPrefixSuffixArray(prefixSuffixArray,pattern);	
		for(int i=0,j=0;i<str.length();i++)
		{
			if(str.charAt(i)!=pattern.charAt(j))
			{
				if(j!=0)
				{
					j = prefixSuffixArray[j-1];i--; //Go to the position specified by previous index in fillPrefixSuffixArray
				}
			}
			else
			{
				j++;
			}
			if(j==pattern.length())
			{
				System.out.println("Found pattern at index: "+(i-pattern.length()+1));
				j -= pattern.length()-1;	//After pattern is found, set pattern index, j to 0
				i -= pattern.length()-2; //After pattern is found, set index of original string,i to second character of 
										// pattern found, because that may be is the starting of yet another pattern.
			}
		}
		
	}

	private static void fillPrefixSuffixArray(int[] prefixSuffixArray,
			String pattern) {

		prefixSuffixArray[0]=0;
			for(int j=0,i=1;i<pattern.length();)
			{
				
				//if chars at i and j are same then set value at index i as j+1
				if(pattern.charAt(j)==pattern.charAt(i))
				{
					prefixSuffixArray[i] = j+1;
					i++;j++;
				}
				else
				{
					if(j==0) //If j is at or has reached 0, then value at index i would be 0, means no suffixPrefix was found till this position 
					{
						prefixSuffixArray[i]=0;
						i++;
					}
					else
					{
						j = prefixSuffixArray[j-1]; //Move counter j to value in the j-1 index of prefixSuffixArray
					}
				}
			}
	}
}
