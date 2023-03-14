package baekjoon.stack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;

public class Test9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader    br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter    bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character>  s   = new Stack<>();
		StringBuilder     sb  = new StringBuilder();
		Boolean 	      err = false;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			err = false;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == '(') {
					s.push('(');
				}
				else {
					if(!s.isEmpty()) s.pop();
					else             err = true;
				}
				if(err) break;
			}
			if(err || !s.isEmpty()) sb.append("NO\n");
			else    sb.append("YES\n");
			s.clear();
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
