package baekjoon.stack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Test2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character>  s  = new Stack<>();
		
		String str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
				case '(':
					s.push('(');
					break;
				case '[':
					s.push('[');
					break;
			}
		}
		
		bw.flush();
	}
}
