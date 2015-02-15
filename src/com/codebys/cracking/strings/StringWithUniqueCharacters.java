package com.codebys.cracking.strings;

/**
 * Implement an algorithm to determine if a string has all unique characters 
 * What if you can not use additional data structures?
 * 
 * @author juanpablof@gmail.com
 */
public class StringWithUniqueCharacters {
	
	public static boolean checkUniqueChars(String testString) {
	
		// ASCII is a 8-bit character supporting 256 characters
		// Initially this array has all values initialized to FALSE
		boolean[] uniqueChars = new boolean[256];
		
		for(int i = 0; i < testString.length(); i++){
			char singleChar = testString.charAt(i);
			if(uniqueChars[singleChar])
				return false;	
			else
				uniqueChars[singleChar] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String val = "abcdefghijlmnop";
		System.out.println(String.format("String %s - uniqueness guarantee %s", val, StringWithUniqueCharacters.checkUniqueChars(val)+""));
	}
}
