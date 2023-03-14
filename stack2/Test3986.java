package baekjoon.stack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;

public class Test3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character>  s  = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(!s.isEmpty() && s.peek() == str.charAt(j)) s.pop();
				else 										  s.push(str.charAt(j));
			}
			if(s.isEmpty()) count++;
			s.clear();
		}
		bw.write(count + "\n");
		bw.flush();
	}
}
