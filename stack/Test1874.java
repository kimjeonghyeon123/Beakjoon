package baekjoon.stack;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            n     = Integer.parseInt(br.readLine());
		int            start = 1;
		boolean        err   = false;
		StringBuilder  sb    = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			int t = Integer.parseInt(br.readLine());
			while(start<=t) {
				stack.push(start);
				start++;
				sb.append("+\n");
			}
			if(t == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			}
			else
				err = true;
		}
		if(err) System.out.println("NO");
		else    System.out.println(sb);
	}
}
