package com.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/forums/topic/amazon-interview-question-for-
 * software-engineerdeveloper-about-algorithms-48/ given a string, find out the
 * first non-repeating character.
 * 
 * @author sumijaiswal SOLVED
 */
public class Problem2 {
	public static void main(String[] args) {
		String input = "myNameisSumitJaiswal";
		System.out.println(getFirstOccurance(input));
		System.out.println(getFNRC(input));
		

	}

	public static char getFirstOccurance(String input) {
		Map<String, Integer> count = new HashMap<String, Integer>();

		char[] inputs = input.toCharArray();
		char firstOccurance = ' ';
		/**
		 * 1) Traverse the string and build a character count map which contains
		 * count of each character in the string.
		 */
		for (int i = 0; i < inputs.length; i++) {
			if (count.containsKey(inputs[i] + "")) {
				count.put(inputs[i] + "", count.get(inputs[i] + "") + 1);
			} else
				count.put(inputs[i] + "", 1);
		}
		System.out.println(count);
		/**
		 * 2) Again traverse the string. While traversing if you find a
		 * character who’s count is 1, return that character.
		 */
		for (int i = 0; i < inputs.length; i++) {
			if (count.get(inputs[i] + "") == 1) {
				firstOccurance = inputs[i];
				break;
			}
		}
		System.out.println("First Occurance of non-repeating character:"
				+ firstOccurance);
		return firstOccurance;
	}

	/**
	 * Time Complexity – O(n)
	 * Implementation using Hashtable and Stack
	 * @param text
	 * @return
	 */
	public static char getFNRC(String text) {
		HashSet<Integer> hash = new HashSet<Integer>();
		Stack<Integer> FNRC = new Stack<Integer>();
		for (int i = text.length() - 1; i >= 0; --i) {
			char value = text.charAt(i);
			if (!hash.contains((int)value)) {
				FNRC.push((int)value);
				hash.add((int)value);
			} else {
				if (!FNRC.isEmpty()) {
					if (FNRC.peek().equals((int)value)) {
						FNRC.pop();
					}
				}
			}
		}
		System.out.println(hash);
		System.out.println(FNRC);
		if (!FNRC.isEmpty()) {
			return (char)((int)(FNRC.pop()));
		} else {
			return '\0';
		}
	}
}
