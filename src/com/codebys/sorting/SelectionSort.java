package com.codebys.sorting;


/**
 * In iteration i, find index min of smallest remaining entry.
 * Swap a[i] and a[min].
 * 
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 *
 */
public class SelectionSort extends BaseSort {

	/**
	 * Method: Find the smallest "min", we swap that with i 
	 * and increment i. 
	 * 
	 * Algorithm: scans from left to right.
	 * 
	 * Invariants: Entries on the left of the pointer (i) fixed and in
	 * ascending order. No entry to the right of the pointer (i) is smaller than
	 * any entry to the left of the pointer (i).
	 */
	public static void sort(Comparable<Integer>[] a){
		
		// Array max size
		int N = a.length;
		
		for(int i = 0; i < N; i++){
			
			// Get the minimum value
			int min = i;
			
			// Iterate the array with another pointer
			// starting from the pointer + 1
			for(int j=i+1;j<N;j++){
				
				// Check if the value is less than the 
				// minimum selected
				if(less(a[j], a[min]))
				
					//exchange the minimum value
					min = j;
				
				// exchange value (if i = min nothing will change)
				// otherwise you'll swap values.
				exch(a,i,min);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(a[i]);
		
		}
	}
	
	// Test
	public static void main(String[] args) {
		Integer a[] = new Integer[]{2,4,8,1,3,9,10,16,5};
		SelectionSort.sort(a);
	}
}
