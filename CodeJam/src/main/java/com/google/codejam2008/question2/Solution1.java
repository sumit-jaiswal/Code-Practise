package com.google.codejam2008.question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://code.google.com/codejam/contest/32013/dashboard#s=p1
 * @author sumijaiswal
 *
 */
public class Solution1 {

	private static int N = -1;
	private static int searchEnginesCount = -1;
	private static int queriesCount = -1;
	private static String[] searchEngines = null;
	private static String[] queries = null;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		// Start solving the problem.
		String baseDir = "src/main/java/com/google/codejam2008/question1/";
		String inputType="large";
		String inputFile = baseDir + inputType +"-input.in";
		String outputFile = baseDir + inputType +"-output.in";
		
		solveProblem(inputFile,outputFile);
		
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.printf("Time in milliseconds: %d", timeTaken);
	}

	private static void solveProblem(String inputFile,String outputFile) throws IOException {
		// Scan the input file.
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		PrintStream ps = new PrintStream(outputFile);
		try {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			for (int c = 0; c < N; c++) {
				// Take input search engines.
				searchEnginesCount = Integer.parseInt(br.readLine());
				searchEngines = new String[searchEnginesCount];
				for (int i = 0; i < searchEnginesCount; i++) {
					searchEngines[i] = br.readLine();
				}
				// Take input all the queries.
				queriesCount = Integer.parseInt(br.readLine());
				queries = new String[queriesCount];
				for (int i = 0; i < queriesCount; i++) {
					queries[i] = br.readLine();
				}
				// Reset the count. count - number of engine switches.
				count = 0;
				// Process the inputs to get answer.
				solve(searchEngines, queries, 0, queriesCount);
				System.out.printf("Case #%d: %d%n", (c+1), count);
				ps.printf("Case #%d: %d%n", (c+1), count);
				ps.flush();
			}
		} finally {
			br.close();
			ps.flush();
			ps.close();
		}
	}

	private static void solve(String[] searchEngines2, String[] queries2,
			int start, int end) {
		// This method will recursively solve this problem.
		if (queries2.length == 0 || start == end)
			return;
		HashMap<String, Integer> engine_occurence = new HashMap<String, Integer>();
		// Store -1 as the value of each search engine.
		for (int i = 0; i < searchEngines2.length; i++) {
			engine_occurence.put(searchEngines2[i], -1);
		}
		// Find the search engines in Queries with maximum index of first
		// occurrence.
		for (int i = 0; i < searchEngines2.length; i++) {
			for (int j = start; j < end; j++) {
				if (engine_occurence.get(searchEngines2[i]) != -1)
					break;
				if (searchEngines2[i].contentEquals(queries2[j])) {
					engine_occurence.put(searchEngines2[i], j);
					break;
				}
			}
		}
		// Find the searchEninge with maximum index of first occurrence.
		boolean isExclusive = false;
		int maxIndex = -1;
		Iterator it = engine_occurence.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			String engine = (String) pairs.getKey();
			int value = (Integer) pairs.getValue();
			if (value == -1) {
				// No need to switch even for one time.
				isExclusive = true;
				break;
			}
			if (value > maxIndex)
				maxIndex = value;
			// it.remove();
		}
		// Recursively pass remaining queries to the Solve method.
		if (isExclusive) {
			return;
		} else {
			count++;
			solve(searchEngines2, queries2, maxIndex, end);
		}
	}

}
