package baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NO1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int a = Integer.parseInt(in.readLine());
		List<Integer> b = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		boolean flag = true;
		
		for(int i=0; i<a; i++) {
			b.add(Integer.parseInt(in.readLine()));
		}
		
		int index = 1;
		int pivot = 0;
		int curVal = b.get(pivot);
		int top = 0;

		while(true) {
			if(stack.isEmpty()) {
				stack.push(index++);
				str.append("+\n");
				continue;
			}
			else
				top = stack.peek();
			
			if(top < curVal) {
				stack.push(index++);
				str.append("+\n");
			} else if (top == curVal) {
				stack.pop();
				str.append("-\n");

				if(pivot+1 == a)
					break;
				
				curVal = b.get(++pivot);
			} else {
				System.out.println("NO");
				flag = false;
				break;
			}
		}
		
		if(flag) 
			System.out.println(str);
	}
}
