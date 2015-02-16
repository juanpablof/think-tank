package com.codebys.cracking.strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 * 
 * @author juanpablof
 */
public class ReplaceString {
	
	public static String replaceEmptySpaces(String string){
		String result = "";
		for (int i = 0; i < string.length(); i++) {
			char val = string.charAt(i);
			if(val == ' ') result += "%20";
			else result += val;
		}
		return result;
	}

	public static void main(String[] args) {
		String test = "abc de eeee";
		System.out.println(String.format("String %s - Replaced String %s",test,ReplaceString.replaceEmptySpaces(test)));
	}
}
