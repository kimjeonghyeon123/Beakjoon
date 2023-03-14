package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test17298 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[N];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}
		
		for(int i=0;i<N;i++) {
			if(s.peek() > arr[i])
				s.push(arr[i]);
			while(s.peek() < arr[i]) {
				s.pop();
				s.push(arr[i]);
			}
		}
	}
}
