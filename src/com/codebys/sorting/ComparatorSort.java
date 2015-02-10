package com.codebys.sorting;

import java.util.Comparator;

public class ComparatorSort {
	
	
	public static void sort(Object[] a, Comparator<Object> comparator){
		
		int N = a.length;
		
		for( int i = 0; i < N; i++){
			int min = i;
			for(int j=i+1;j<N;j++){
				if(less(comparator,a[j], a[min]))
					min = j;
				exch(a,i,min);
			}
		}
	}
	
	private static boolean less(Comparator<Object> comparator, Object v, Object w){
		return comparator.compare(v, w) < 0;
	}
	
	private static void exch(Object[] a, int i, int j){
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	

}
