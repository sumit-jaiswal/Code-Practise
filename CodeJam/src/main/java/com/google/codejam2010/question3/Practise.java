package com.google.codejam2010.question3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * https://code.google.com/codejam/contest/dashboard?c=351101#s=p2
 * 
 * Problem C. T9 Spelling 
 * 
 * Completed - By Sumit Jaiswal
 * @author sumijaiswal
 *
 */
public class Practise {
	public static void main(String[] args) throws Exception {
		String baseDir = "src/main/java/com/google/codejam2010/question3/";
		String inputType = "small";
		String inputFile = baseDir + inputType + "-input.in";
		String outputFile = baseDir + inputType + "-output.in";
		
		solve(inputFile,outputFile);
		
		inputType = "large";
		inputFile = baseDir + inputType + "-input.in";
		outputFile = baseDir + inputType + "-output.in";
		
		solve(inputFile,outputFile);
	}
	
	public static void solve(String inputFile,String outputFile) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				inputFile)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
				outputFile)));
		try {
			int N = Integer.parseInt(reader.readLine());
			Map<String, String> map = new HashMap<String, String>();
			map.put("a", "2");
			map.put("b", "22");
			map.put("c", "222");

			map.put("d", "3");
			map.put("e", "33");
			map.put("f", "333");

			map.put("g", "4");
			map.put("h", "44");
			map.put("i", "444");

			map.put("j", "5");
			map.put("k", "55");
			map.put("l", "555");

			map.put("m", "6");
			map.put("n", "66");
			map.put("o", "666");

			map.put("p", "7");
			map.put("q", "77");
			map.put("r", "777");
			map.put("s", "7777");

			map.put("t", "8");
			map.put("u", "88");
			map.put("v", "888");

			map.put("w", "9");
			map.put("x", "99");
			map.put("y", "999");
			map.put("z", "9999");

			map.put(" ", "0");

			for (int i = 1; i <= N; i++) {
				String line = reader.readLine();
				char[] characters = line.toCharArray();
				char previous = '#';
				String output = "";
				for (int j = 0; j < characters.length; j++) {
					if (previous != '#' && findRepeat(previous, characters[j])) {
						output += " ";// Pause
					}
					output += map.get(characters[j] + "");
					previous = characters[j];
				}
				System.out.println("Case #" + i + ": " + output);
				writer.write("Case #" + i + ": " + output + "\n");
			}
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}

	private static boolean findRepeat(char previous, char characters) {
		boolean result = false;
		String occurances[] = { "abc", "def", "gih", "jkl", "mno", "pqrs",
				"tuv", "wxyz", " " };
		for (int i = 0; i < occurances.length; i++) {
			result = ((occurances[i].indexOf(previous) != -1) && (occurances[i]
					.indexOf(characters) != -1));
			if(result)
				break;
			//System.out.println(occurances[i]+":"+previous+":"+characters+":"+result);
		}
		return result;
	}
}
