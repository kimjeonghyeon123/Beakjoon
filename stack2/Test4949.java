package baekjoon.stack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Test4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character>  s  = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean err = false;
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			
			err = false;
			for(int i=0;i<str.length();i++) {
				switch (str.charAt(i)) {
					case '(':
						s.push('(');
						break;
					case '[':
						s.push('[');
						break;
					case ')':
						if(!s.isEmpty() && s.peek() == '(') {
							s.pop();
							break;
						}
						else {
							err = true;
							break;
						}
					case ']':
						if(!s.isEmpty() && s.peek() == '[') {
							s.pop();
							break;
						}
						else {
							err = true;
							break;
						}
				}
				if(err) break;
			}
			if(err || !s.isEmpty()) sb.append("no\n");
			else    sb.append("yes\n");
			s.clear();
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
