package com.codebys.sorting;

/**
 * Abstract class to handle a few mothods shared by the implementation of various sorting algorithms.
 * @date 02/05/2015
 * @author Juan Pasblo Francisconi (juanpablof@gmail.com)
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseSort {
	
	/**
	 * Check whether v is less than w.
	 * @param v
	 * @param w
	 * @return true / false
	 */
	protected static boolean less(Comparable v,  Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * Swap values.
	 * @param a
	 * @param i
	 * @param j
	 */
	protected static void exch(Comparable<?>[] a, int i, int j) {
		Comparable<?> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	/**
	 * Check whether the array is sorted or not.
	 * @param a
	 * @return true / false.
	 */
	protected static boolean isSorted(Comparable<?>[] a){
		for (int i = 0; i < a.length - 1; i++) {
			if(!less(a[i], a[i+1]))
					return false;
		}
		return true;
	}
}
