package com.google.codejam2010.question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	private static String[] numpad = { " ", "", "abc", "def", "ghi", "jkl",
			"mno", "pqrs", "tuv", "wxyz" };

	public static void toggle(char ch, int index) {
		for (int i = 1; i <= numpad[index].indexOf(ch) + 1; i++) {
			System.out.print(index);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String baseDir = "src/main/java/com/google/codejam2010/question3/";
		String inputFile = baseDir + "input.in";
		String outputFile = baseDir + "output.in";
		Scanner sc = new Scanner(new File(inputFile));
		// read number test case
		int round = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= round; i++) {
			System.out.print("Case #" + i + ": ");
			String word = sc.nextLine();

			for (int j = 0; j < word.length(); j++) {
				for (int k = 0; k < numpad.length; k++) {
					int key = numpad[k].indexOf(word.charAt(j));
					if (key != -1) {
						toggle(word.charAt(j), k);
						// next character contain in the same key
						if (j < word.length() - 1
								&& numpad[k].indexOf(word.charAt(j + 1)) != -1)
							System.out.print(numpad[0]);
					}
				}
			}

			// End one iteration
			System.out.println();
		}
	}
}
