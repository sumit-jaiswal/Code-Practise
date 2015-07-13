package com.google.codejam2010.question2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * https://code.google.com/codejam/contest/351101/dashboard#s=p0
 * 
 * Problem A. Store Credit
 * ------------------- COMPLETED ----------------
 * @author sumijaiswal
 *
 */
public class Practise {
	public static void main(String[] args) throws Exception{
		String baseDir = "src/main/java/com/google/codejam2010/question2/";
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
		BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFile)));
		
		try {
			int N = Integer.parseInt(reader.readLine());
			for (int a = 1; a <= N; a++) {
				int C = Integer.parseInt(reader.readLine());
				int I = Integer.parseInt(reader.readLine());
				String itemLine = reader.readLine();
				String[] items = itemLine.split(" ");
				Map<Integer,Integer> map = new HashMap<Integer,Integer>();
				for (int i = 0; i < items.length; i++) {
					map.put(Integer.parseInt(items[i]), i);
				}
				
				for(int i=0;i<items.length;i++){
					
					int firstItem = Integer.parseInt(items[i]);
					
					int secondItem = C - firstItem;
					if(map.containsKey(secondItem) && map.get(secondItem) != i){
						writer.write("Case #"+a+": "+(i+1)+" "+(map.get(secondItem)+1)+"\n");
						System.out.println("Credit:"+C);
						System.out.println("firstItem:"+firstItem +" index:"+i);
						System.out.println("secondItem:"+secondItem+" index:"+map.get(secondItem));
						break;
					}
				}
			}
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}
}
