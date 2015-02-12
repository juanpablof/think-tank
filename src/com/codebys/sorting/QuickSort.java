package com.codebys.sorting;
/**
 * 1) Shuffle the array.
 * 2) Partition so that, for some j:
 *  	- entry a[j] is in place
 *  	- no larger entry to the left of j
 *  	- no smaller entry to the right of j
 * 3) Sort each piece recursively
 * 
 * Difference with Merge Sort: it does the recursion after it does the work
 * when Merge Sort does it before.
 * 
 * One of the biggest advantages from Quick Sort over Merge Sort is that it doesn't
 * take any extra space. It gets the sort done in place.
 * 
 * Best case: N log N
 * Worst case: 1/2 NxN (quadratic)
 * 
 * Average case: compares 39% more than merge sort but faster than merges sort in practice
 * because of less data movement. 
 * 
 * Random shuffle is guaranteeing that the worse case is not going to happen. Worse case happens
 * when the array is sorted because the partitioning doesn't really do something and the number
 * of compares increases. 
 * 
 * It's not stable: maybe using extra space.
 * 
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 */
public class QuickSort extends BaseSort {

	public static void sort(Comparable<?>[] a){
		ShuffleSort.shuffle(a); //shuffle needed for performance guarantee.
		sort(a,0,a.length -1);
	}
	
	private static void sort(Comparable<?>[] a, int lo, int hi){
		
		// Improvement 1: user insertion sort (faster than recursion) for small 
		// sub-arrays (20% faster with CUTOFFs = 10).
		//
		// if(hi <= lo + CUTOFF -1){
		// 		Insertion.sort(a,lo,hi);
		//      return;
		//  }
		
		// Improvement 2: try to estimate the partition element to be near the middle 
		// rather than arbitrarily using the first element. Improves the running time around
		// 10% probably.
		//
		// int m = mediaOf3(a, lo, lo + (hi - lo)/2, hi);
		// swap(a, lo, m);
		
		if(hi <= lo) return;
		int mid = partition(a, lo, hi);
		sort(a, lo, mid-1);
		sort(a, mid+1, hi);
	}
	
	
	/**
	 * 
	 * Phase 1: Repeat until i and j pointers cross.
	 *  - Scan i from left to right so long as (a[i] < a[lo])
	 *  - Scan j from right to left so long as (a[j] > a[lo])
	 *  - Exchange a[i] with a[j]
	 * 
	 * Phase 2: When pointers cross
	 *  - Exchange a[lo] with a[j]
	 *  
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(Comparable<?>[] a,int lo, int hi){
		
		int i = lo;
		int j = hi + 1;
		
		while(true){
			
			while(less(a[++i],a[lo])){
				if(i == hi) break;
			}
			
			while(less(a[lo],a[--j])){
				if(j == lo) break;
			}
			
			if(i >= j) break;
			exch(a,i,j);
		}
		
		exch(a,lo,j);
		return j;
		
	}
}
