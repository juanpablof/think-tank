package com.codebys.sorting;

public abstract class BaseSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static boolean less(Comparable v,  Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	protected static void exch(Comparable<?>[] a, int i, int j)
	{
		Comparable<?> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	protected static boolean isSorted(Comparable<?>[] a){
		for (int i = 0; i < a.length - 1; i++) {
			if(!less(a[i], a[i+1]))
					return false;
		}
		return true;
	}

}
