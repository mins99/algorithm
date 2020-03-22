package baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		
		for(int i=0; i<a; i++) {
			String str = in.readLine();
			int count = 0;
			boolean check = true;
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					count++;
				} else {
					if(count == 0) {
						check = false;
						continue;
					} else {
						count--;
					}
				}
			}
			
			if(count == 0 && check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}