/**********************************************************************
Filename: HashingTable.java
Version: 1.0
Author:	Martin Choy
Student No:	040835431
Course Name/Number:	CST8130 Data Structures 
Lab Sect:	303
Assignment name: Hybrid 5
Due Date: 11:59pm, Monday 18 December 2017
Submission Date: December 17, 2017 10:40PM
Professor: ANU THOMAS
Purpose of Assignment: :  To explore different potential hash algorithms
(transforming a 6-digit number to a 2-digit number to be used as the index of 
 an array of size 100)
*********************************************************************/
import java.util.Scanner;
public class HashingTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[100];
		for (int i = 0; i < 100; i++) {
			numbers[i] = 0;
		}
		int num = 0;
		int lastTwo = 0;
		int middleTwo = 0;
		int lastSum = 0;
		
		System.out.println("Number\t\tlast two digits\t\tmiddle two digits\t\t  last digits of sum");

		for (num = 145623; num <= 145723; num++) {
			lastTwo = last(num);
			middleTwo = middle(num);
			lastSum = sum(num);

			if (numbers[lastTwo] == 0) {
				numbers[lastTwo] = num;
			} else {
				boolean done = false;

				for (int j = lastTwo + 1; j < 100; j++) {
					if (numbers[j] == 0) {
						done = true;
						numbers[j] = num;
						break;
					}
				}
				if (!done) {
					System.out.println("Number cannot be placed!");
				}
			}
			System.out.printf("%6d\t  %8d \t  %16d \t\t%20d \n", num, lastTwo, middleTwo, lastSum);
		}
	}
	public static int last(int value) {
		return value % 100;
	}
	public static int middle(int value) {
		int middleTwo = 0;
		middleTwo = value % 10000 / 100;
		return middleTwo;
	}

	public static int sum(int total) {
		int sum = 0;
		while (total != 0) {
			sum += total % 10;
			total /= 10;
		}
		return sum;
	}
}
