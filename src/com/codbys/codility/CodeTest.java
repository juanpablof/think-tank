package com.codbys.codility;

public class CodeTest {
	
	int solution(int[] A, int X) {
	    
		int N = A.length;
	    
		if (N == 0) {
	        return -1;
	    }
	    int l = 0;
	    int r = N - 1;
	    while (l < r) {
	        int m = (l + r) / 2;
	        if (A[m] >= X) {
	            r = m;
	        } else {
	            l = m + 1;
	        }
	    }
	    if (A[l] == X) {
	        return l;
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		//                  0 1 2 3 4 5 6 7
		int[] A = new int[]{1,5,9};
		CodeTest test = new CodeTest();
		System.out.println(test.solution(A, 5));
	}
}
