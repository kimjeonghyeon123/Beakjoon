package baekjoon.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		Deque<Integer> d = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			d.offerLast(i);
		}
		
		int move = 0;
		int totalmove = 0;
		while(st2.hasMoreTokens()) {
			int t = Integer.parseInt(st2.nextToken());
			
			int k = t + move;
			
			if(k - 1 < d.size() - k + 1) {
				while(d.peekFirst() != t) {
					d.offerLast(d.pollFirst());
					move--;
					totalmove++;
				}
			}
			else {
				while(d.peekFirst() != t) {
					d.offerFirst(d.pollLast());
					move++;
					totalmove++;
				}
			}
			
			d.pollFirst();
			move--;
		}
		
		bw.write(totalmove);
		bw.flush();
	}
}
