package com.codebys.cracking.arrays;

import java.util.Random;

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
		int N = 5;
		int matrix[][] = new int[N][N];
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int val = random.nextInt(N);
				matrix[i][j] = val;
			}
		}
		printMatrix(matrix);
		rotateMatrix(matrix,5);
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
