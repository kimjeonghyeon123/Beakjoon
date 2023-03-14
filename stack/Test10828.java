package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] sarr = new String[N];
		for(int i=0;i<N;i++) {
			sarr[i] = br.readLine();
		}
		
		Stack<String> s = new Stack<>();
		for(int i=0;i<N;i++) {
			String[] arr = sarr[i].split(" ");
			if(arr[0].equals("push")) 
				s.push(arr[1]);
			else if(arr[0].equals("pop")) 
				if(s.isEmpty()) System.out.println(-1);
				else            System.out.println(s.pop());
			else if(arr[0].equals("top")) 
				if(s.isEmpty()) System.out.println(-1);
				else            System.out.println(s.peek());
			else if(arr[0].equals("size"))
				System.out.println(s.size());
			else if(arr[0].equals("empty")) 
				if(s.isEmpty()) System.out.println(1);
				else		    System.out.println(0);
		}
	}
}
