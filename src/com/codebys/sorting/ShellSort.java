package com.codebys.sorting;

/**
 * h-sort array for decreasing sequence of values of h
 * 
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 */
public class ShellSort extends BaseSort {
	
	/**
	 * The idea is to move entries more than one position at 
	 * a time by h-sorting the array. It's basically insertion sort
	 * by improved.
	 * 
	 * Worse case: O(N2) - cuadratic
	 * 
	 * Fast unless array size is huge
	 * Tiny, fixed footprint for code
	 * Harware sort prototypes
	 */
	public static void sort(Comparable<?>[] a){
		
		int size = a.length;
		int h = 1;
		
		// why h=3*h-1? So, it's easy to compute.
		while(h < size/3) h = 3*h +1;
		
		// when each sub-array = 1, then
		// the array must be sorted.
		while (h >= 1){
			// we start with i = h and then compare
			// back j-h.
			for(int i = h; i < size; i++)
			{
				for(int j = i; j>= h;j-=h){
					if(less(a[j],a[j-h]))
						exch(a, j, j-h);
				}
				
			}
			// decrement h to create smaller groups (sub-arrays)
			// in order to perform insertion sort. 
			h = h/3;
		}
		
		for (int i = 0; i < size; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Integer a[] = new Integer[]{2,4,8,1,3,9,10,16,5};
		ShellSort.sort(a);
	}

}
