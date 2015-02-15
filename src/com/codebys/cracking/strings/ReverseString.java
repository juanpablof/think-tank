package com.codebys.cracking.strings;

/**
 * Write code to reverse a C-Style String (C-String means that “abcd” is represented 
 * as five characters, including the null character )
 * 
 * @author juanpablof
 */
public class ReverseString {
	
	public static String reverse(String string) {
		String result = "";
		for (int i = string.length() -1; i >= 0; i--) {
			char val = string.charAt(i);
			result+=val;
		}
		return result;
	}

	public static void main(String[] args) {
		String test = "abcd";
		System.out.println(String.format("String %s - Reversed String %s",test,ReverseString.reverse(test)));
	}
}
