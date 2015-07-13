package com.random;


/**
 * http://www.geeksforgeeks.org/forums/topic/microsoft-interview-question-for-
 * software-engineerdeveloper-about-arrays-10/ Given an array of integers,
 * {1,0,2,0,3,0,0,4,5,6,7,0,0,0}, you have to create a new array which will be
 * like (1,2,3,4,5,6,7,0,0,0,0,0,0,0}, without using any other temporary array.
 * 
 * @author sumijaiswal
 */
public class Problem3 {
	public static void main(String[] args) {
		int[] input = { 1, 0, 2, 0, 3, 0, 0, 4, 5, 6, 7, 0, 0, 0 };
		sortZeros(input);

	}

	public static int[] rearrangeArray(int[] input) {
		int[] output = new int[input.length];

		return output;
	}

	public static void sortZeros(int[] a) {
		int nzC = 0; // counter to maintain the number of non zero elements.
		for (int i = 0; i < a.length; i++) {
			// if we find a non zero assign it to the appropriate index and
			// increment the counter.
			if (a[i] != 0) {
				a[nzC++] = a[i];
			}
		}

		// fill the remaining array with zeroes.
		for (; nzC < a.length; nzC++) {
			a[nzC] = 0;
		}

		// print the array
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " , ");
		}
	}

}
