package com.itranswarp.learnjava;

import java.util.Scanner;

/**
 * 计算BMI
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Height (m): ");
		double height = scanner.nextDouble();
		System.out.print("Weight (kg): ");
		double weight = scanner.nextDouble();
		scanner.close();
		// FIXME:
		double bmi = weight / (height * height);
		// TODO: 打印BMI值及结果
		if (bmi < 18.5)
			System.out.printf("BMI=%.1f, 过轻", bmi);
		else if (bmi >= 18.5 && bmi <= 25)
			System.out.printf("BMI=%.1f, 正常", bmi);
		else if (bmi > 25 && bmi <= 28)
			System.out.printf("BMI=%.1f, 过重", bmi);
		else if (bmi > 28 && bmi <= 32)
			System.out.printf("BMI=%.1f, 肥胖", bmi);
		else
			System.out.printf("BMI=%.1f, 非常肥胖", bmi);

	}

}
