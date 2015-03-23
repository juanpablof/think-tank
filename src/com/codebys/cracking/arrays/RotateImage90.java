package com.codebys.cracking.arrays;


/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 
 * 4 bytes, write a method to rotate the image by 90 degrees Can you do this in place?
 * 
 * @author juanpablof@gmail.com
 */
public class RotateImage90 {

	public static void rotateMatrix(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top; // right <- saved top }
			}
		}
	}

	public static void main(String[] args) {
		int N = 3;
		
		int matrix[][] = new int[N][N];
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		printMatrix(matrix);
		rotateMatrix(matrix,3);
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		String line = "";
		StringBuffer buffer = new StringBuffer();
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			line = "";
			for (int j = 0; j < N; j++) {
				line += " " + matrix[i][j];
			}
			buffer.append(line);
			buffer.append("\n");
		}
		System.out.println(buffer.toString());
	}

}
