package com.google.codejam2009.question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * https://code.google.com/codejam/contest/90101/dashboard#s=p0
 * Problem A. Alien Language
 * 
 * @author sumijaiswal
 *
 */
public class Practise {

	public static void main(String[] args) throws Exception {
		String baseDir = "src/main/java/com/google/codejam2009/question1/";
		String inputType = "small";
		String inputFile = baseDir + inputType + "-input.in";
		String outputFile = baseDir + inputType + "-output.in";

		solve(inputFile, outputFile);

		inputType = "large";
		inputFile = baseDir + inputType + "-input.in";
		outputFile = baseDir + inputType + "-output.in";

		solve(inputFile, outputFile);
	}

	public static void solve(String inputFile,String outputFile) throws Exception {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(new File(inputFile)));
			writer = new BufferedWriter(new FileWriter(new File(outputFile)));
			int noOfTestCases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= noOfTestCases; i++) {
				String line = reader.readLine();
				String words[] = line.split(" ");
				writer.write("Case #" + i + ": ");
				for (int j = words.length - 1; j >= 0; j--) {
					writer.write(words[j] + " ");
				}
				writer.write("\n");
			}
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}
}
