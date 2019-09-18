// https://www.acmicpc.net/problem/1546

package baekjoon.NO1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		double[] arr = new double[n];
		double sum = 0;
		double max = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Double.parseDouble(input[i]);
			sum += arr[i];
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(sum / max * 100 / n);
	}

}
