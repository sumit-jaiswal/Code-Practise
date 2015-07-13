package com.google.codejam2010.question2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	final static int MAX_CREDIT = 1000;

	public static void main(String[] args) throws Exception {
		String baseDir = "src/main/java/com/google/codejam2010/question2/";
		String inputFile = baseDir + "input.in";
		String outputFile = baseDir + "output.in";

		Scanner sc = new Scanner(new File(inputFile));
		PrintWriter writer = new PrintWriter(outputFile);
		int tests = sc.nextInt();
		System.out.println("tests: " + tests);

		int[] store = new int[MAX_CREDIT + 1];

		for (int test = 1; test <= tests; test++) {

			int credit = sc.nextInt();
			int items = sc.nextInt();

			int pos1 = 0, pos2 = 0;
			int creditMiddle = (credit % 2 == 0) ? credit / 2 : 0;
			Arrays.fill(store, 0, credit + 1, 0);
			for (int item = 1; item <= items; item++) {
				int value = sc.nextInt();
				if (pos1 == 0 && value < credit) {
					if (value == creditMiddle) { // Two elements can have the
													// same price only if they
													// cost half the credit
						if (store[value] > 0) {
							pos1 = store[value];
							pos2 = item;
						} else {
							store[value] = item;
						}
						continue;
					}
					store[value] = item;
					int complement = credit - value;
					if (store[complement] > 0) {
						pos1 = item;
						pos2 = store[complement];
						if (pos1 > pos2) {
							pos1 = pos2;
							pos2 = item;
						}

					}
				}
			}

			writer.println("Case #" + test + ": " + pos1 + " " + pos2);
			System.out.println("Test #" + test + " credit: " + credit
					+ ", items: " + items + ", pos1: " + pos1 + ", pos2: "
					+ pos2);
		}
		writer.close();
	}
}
