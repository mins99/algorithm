package baekjoon.IO;

import java.util.Calendar;
import java.util.Scanner;

public class NO1924_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		Calendar c = Calendar.getInstance();
		c.set(2007, a-1, b);
		int day_of_week = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(week[day_of_week-1]);
	}
}
