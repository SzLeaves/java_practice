package com.itranswarp.learnjava;

import java.util.Scanner;

/**
 * 输入上次考试成绩（int）和本次考试成绩（int），然后输出成绩提高的百分比，保留两位小数位（例如，21.75%）
 */
public class Main {

	public static void main(String[] args) {
		int prev, score;
		double percent;

		Scanner input = new Scanner(System.in);
		System.out.print("输入第一次的成绩:");
		prev = input.nextInt();
		System.out.print("输入第二次的成绩:");
		score = input.nextInt();
		input.close();

		// 注意对整数强制转型
		percent = (double)(score - prev) / prev * 100;
		System.out.printf("成绩提高了%.2f%%", percent);
	}

}
