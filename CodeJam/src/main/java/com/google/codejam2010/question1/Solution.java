package com.google.codejam2010.question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) {
		String baseDir = "src/main/java/com/google/codejam2010/question1/";
		String inputFile = baseDir + "input.in";
		String outputFile = baseDir + "output.in";
		try {
			BufferedReader read = new BufferedReader(new FileReader(
					inputFile));
			BufferedWriter write = new BufferedWriter(new FileWriter(
					outputFile));
			int N = Integer.valueOf(read.readLine());

			for (int i = 0; i < N; i++) {
				String sentence, revSentence = "";
				sentence = read.readLine();
				String[] wordArr = sentence.split(" ");

				for (int k = wordArr.length - 1; k >= 0; k--) {
					revSentence += wordArr[k];
					if (k != 0) {
						revSentence += " ";
					}

				}
				write.write("Case #" + (i + 1) + ": " + revSentence + "\n");
				write.flush();
			}
			read.close();
			write.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
