package baekjoon.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NO10818_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<a; i++)
			arr.add(sc.nextInt());
		
		int max = arr.stream().max(Integer::compare).orElse(-1);
		int min = arr.stream().min(Integer::compare).orElse(-1);

		System.out.println(min + " " + max);
	}

}
