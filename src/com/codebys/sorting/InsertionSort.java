package com.codebys.sorting;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array 
 * (or list) one item at a time. It is much less efficient on large lists than more 
 * advanced algorithms such as quicksort, heapsort, or merge sort.
 * 
 * @author juanpablof@gmail.com
 */
public class InsertionSort extends BaseSort{

	public static void sort(Comparable<?>[] a){
		
		int size = a.length;
		
		for(int i = 0; i < size; i++){
			
			for (int j = i; j > 0; j--) {
				
				if(less(a[j],a[j-1]))
					
					exch(a, j, j-1);
				
				else break;
			}
		}
	}
	
}
