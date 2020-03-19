package baekjoon.IO;

import java.util.Scanner;

public class NO1924_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int day = b;
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int i=0; i<a-1; i++)
			day += month[i];
		
		System.out.println(week[day%7]);
	}
}
