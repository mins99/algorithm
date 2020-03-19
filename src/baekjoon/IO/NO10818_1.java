package baekjoon.IO;

import java.util.Scanner;

public class NO10818_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int[] arr = new int[a];

		for(int i=0; i<a; i++)
			arr[i] = sc.nextInt();
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<a; i++) {
			if(max < arr[i])
				max = arr[i];
			
			if(min > arr[i])
				min = arr[i];
		}
		
		System.out.println(min + " " + max);
	}

}
