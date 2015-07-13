package com.meetup;

public class TrailingZeros {
	public static void main(String[] args) {
		System.out.println(countZeros(12010100, 0));
	}
	
	public static int countZeros(int number,int count){
		if(number < 10)
			return -1;
		if(number % 10 == 0){
			return countZeros(number/10, ++count);
		}
		return count;
	}
}