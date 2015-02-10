package com.codebys.sorting;

/**
 * Pass through array, merging sub-arrays of size 1.
 * Repeat for sub-arrays of size 2, 4, 8, 16, ...
 * No recursion needed!
 *  
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 */
public class BottomUpMergeSort extends BaseSort {
	
	private static Comparable<?>[] aux;
	
	public static void sort(Comparable<?>[] a){
		
		int N = a.length;
		aux = new Comparable<?>[N];
		
		for(int sz = 1; sz < N; sz = sz+sz){
			for(int lo = 0; lo < N-sz; lo+=sz+sz)
				merge(a,aux,lo,lo+sz,Math.min(lo+sz+sz-1,N-1));
		}
	}
	
	private static void merge(Comparable<?>[] a, Comparable<?>[] aux, int lo, int mid, int hi){
		System.out.println(String.format("--> merge %d %d %d",lo,mid,hi));
		assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
		
		for (int k = lo; k <= hi; k++) {
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

