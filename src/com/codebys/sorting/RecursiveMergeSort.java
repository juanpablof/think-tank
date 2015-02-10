package com.codebys.sorting;

/**
 * Divide the array in two halves.
 * Sort recursively each part.
 * Merge both halves.
 * 
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 */
public class RecursiveMergeSort extends BaseSort{

	public static void sort(Comparable<?>[] a) {
		Comparable<?>[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable<?>[] a, Comparable<?>[] aux, int lo, int hi){
		
		if (hi <= lo) return;
		
		// Improvement 1: user insertion sort (faster than recursion) for small 
		// sub-arrays (20% faster with CUTOFFs = 7).
		//
		// if(hi <= lo + CUTOFF -1){
		// 		Insertion.sort(a,lo,hi);
		//      return;
		//  }
		
		System.out.println(String.format("sort %d %d",lo,hi));
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
	
		// Improvement 2: stop if the array is already sorted.
		// if(!less(a[mid+1], a[mid])) return;

		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable<?>[] a, Comparable<?>[] aux, int lo, int mid, int hi){
		System.out.println(String.format("--> merge %d %d %d",lo,mid,hi));
		assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
		
		// Improvement 3: Eliminate the copy to the auxiliary array. Save times (but not space) by
		// swithcing the role of the input and auxiliary array in each recursive call.
		
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
	}
	
		public static void main(String[] args) {
			//Integer a[] = new Integer[]{2,4,8,1,3,9,10,16,5};
			String[] a = new String[]{"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
			RecursiveMergeSort.sort(a);
		}
	}


