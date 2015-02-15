package com.codebys.fb;

public class FindTheSmallesSubstring {
	
	public static void main(String[] args) {
		
		char[] set = new char[]{'a','b','c'};
		
		boolean[] chars = new boolean[256];
		
		String val = "abbcbcba";
		
		String substring = "";
		
		for (int j = 0; j < val.length(); j++) {
		
			char index = val.charAt(j);
			
			System.out.println("index: "+index);
			
			for (int i = 0; i < set.length; i++) {
				
				if(set[i] == index){
					
					if(chars[index]) {
						
						chars = new boolean[256];
					
						chars[index] = true;
						
						String newSubstring = "";
						
						for(int k = substring.length() -1; k >=0; k--){
							
							if(substring.charAt(k) != index){
								
								chars[k] = true;
								
								newSubstring += index;
							}else 
								break;
							
							
						}
						
						substring = newSubstring + index;
						
					}else { 
						
						chars[index] = true;
						
						substring += index;
					}
					
					System.out.println("Substring: "+substring);
					
					if(substring.length() == 3){
						
						System.out.println(String.format("result: %s",substring));
						
						return;
					}
					
					break;
				}
			}
		}
	}
}
