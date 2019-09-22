// https://www.acmicpc.net/problem/2789

package baekjoon.NO2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 첫 줄

		int n = Integer.parseInt(st.nextToken());		// 띄어쓰기 기준으로 값 구분
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());	// 두 번째 줄
		
		int[] num = new int[n];
		
		for(int i=0; i<n; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		int max = 0;
		
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					int sum = num[i] + num[j] + num[k];
					if(sum > m) {
						break;
					}
					else {
						if(sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
