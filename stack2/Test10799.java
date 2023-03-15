package baekjoon.stack2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Test10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		
		String  str = br.readLine();
		boolean isPop = false;
		int     count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
				isPop = false;
			}
			else {
				stack.pop();
				if(isPop) count++;
				else      count += stack.size();
				isPop = true;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
	}
}
