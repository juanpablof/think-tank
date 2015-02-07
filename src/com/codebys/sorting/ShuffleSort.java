package com.codebys.sorting;

import java.util.Random;

/**
 * Deck of cards - re-arrange a deck of card in random order.
 * 
 * How to? 
 * 1) Generate a random real number for each array.
 * 2) Sort the array.
 * 
 * Shuffle sort: produces a uniformly random permutation 
 * of the input array, providing no duplicate values.
 * 
 * @author Juan Pablo Francisconi (juanpablof@gmail.com)
 */
public class ShuffleSort extends BaseSort{

	public static void shuffle(Comparable<?>[] a){
		
		Random random = new Random();
		
		int N = a.length;
		
		// How to re-arrange the array in linear time? Every time
		// we pick an number between 1 and i an swap values.
		for(int i=0; i < N; i++){
			int r = random.nextInt(i+1);
			System.out.println(r);
			exch(a,i,r);
		}
		
		
		// Knuth shuffling algorithm produces a 
		// uniformly random permutation of the input array in linear time.
		for (int i = 0; i < N; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		Integer a[] = new Integer[]{2,4,8,1,3,9,10,16,5};
		ShuffleSort.shuffle(a);
	}
}
