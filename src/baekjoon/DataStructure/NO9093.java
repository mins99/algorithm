package baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int a = Integer.parseInt(in.readLine());
		
		String str = "";
		for(int i=0; i<a; i++) {
			str = in.readLine();
			
			String[] arr = str.split(" ");
			for(int j=0; j<arr.length; j++) {
				StringBuffer buf = new StringBuffer(arr[j]);
				System.out.print(buf.reverse() + " ");
			}
			System.out.println();
		}
	}
}
