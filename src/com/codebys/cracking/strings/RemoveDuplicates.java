package com.codebys.cracking.strings;

/**
 * Design an algorithm and write code to remove the duplicate characters 
 * in a string without using any additional buffer NOTE: One or two additional 
 * variables are fine. An extra copy of the array is not.
 * 
 * @author juanpablof@gmail.com
 */
public class RemoveDuplicates {

	public static String removeDuplicates(String str){
		
		boolean[] chars = new boolean[256];
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);
			if(!chars[val]){
				chars[val] = true;
				result += val;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String test = "ABCDAEFBGHIJGGKLMKS";
		System.out.println(String.format("Remove Duplicates -> String %s - New String %s",test,RemoveDuplicates.removeDuplicates(test)));
	}
}
