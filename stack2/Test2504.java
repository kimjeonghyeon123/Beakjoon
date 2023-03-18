package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Test2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter   bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s  = new Stack<>();
		
		String str = br.readLine();
		

		int     total = 1;
		boolean err   = false;
		boolean isPop = false;
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			switch (c) {
				case '(' :
					s.push('(');
					isPop = false;
					break;
				case '[' :
					s.push('[');
					isPop = false;
					break;
				case ')' :
					if(!s.isEmpty() && s.peek() == '(') {
						s.pop();
						isPop = true;
					}
					else {
						err = true;
					}
					break;
				case ']' :
					if(!s.isEmpty() && s.peek() == '[') {
						s.pop();
						isPop = true;
					}
					else {
						err = true;
					}
					break;
			}
			if(err == true) break;
		}
		
		if(err == true) bw.write("0");
		else 		   bw.write(total + "\n");
		
		bw.flush();
	}
}
