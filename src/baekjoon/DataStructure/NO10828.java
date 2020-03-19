package baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        
		String arr[] = new String[a];
		int index = 0;	// 스택의 현재 위치 계산
		
		String str = "";

		for(int i=0; i<a; i++) {
			str = in.readLine();
			
			switch(str.substring(0,2)) {
				case "pu" :
					arr[index++] = str.split(" ")[1];
					break;
				
				case "po" :
					if(index <= 0)
						System.out.println("-1");
					else 
						System.out.println(arr[--index]);
					break;
				
				case "si" :
						System.out.println(index);
					break;
				
				case "em" :
					if(index <= 0)
						System.out.println("1");
					else
						System.out.println("0");
					break;
				
				case "to" :
					if(index <= 0)
						System.out.println("-1");
					else
						System.out.println(arr[index-1]);
					break;
			}
		}
	}
}
