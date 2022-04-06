package com.itranswarp.learnjava;

/**
 * Sum of integers. 计算前n项自然数的和
 */
public class SumOfInteger {

	public static void main(String[] args) {
		int n = 100;
		// TODO: sum = 1 + 2 + ... + n
		int sum = (1 + n) * n / 2;
		System.out.println(sum);
	}

}
