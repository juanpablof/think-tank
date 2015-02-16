package com.codebys.cracking.strings;

/**
 * Write a method to decide if two strings are anagrams or not
 * Note: An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase.
 * Example: "silent" which can be rearranged to "listen"
 * 
 * - Another way to do it is sorting both arrays and checking the size.
 * 
 * @author juanpablof@gmail.com
 */
public class CheckAnagrams {

	public static boolean check(String string1, String string2){
		
		int[] str1 = new int[256];
		int[] str2 = new int[256];
		
		for (int i = 0; i < string1.length(); i++) {
			char val = string1.charAt(i);
			str1[val] = str1[val] + 1;
		}
		
		for (int i = 0; i < string2.length(); i++) {
			char val = string2.charAt(i);
			if(str1[val] == 0) return false; // String1 doesn't contain this char.
			str2[val] = str2[val] + 1;
		}
		
		int i = 0;
		while(i < 256){
			if(str1[i] != str2[i]) return false; // char counts don't match. 
			++i;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String string1 = "silent";
		String string2 = "listen";
		System.out.println(String.format("String1 %s and String2 %s are anagrams: %s",string1,string2,CheckAnagrams.check(string1,string2)));
	}
	
}
