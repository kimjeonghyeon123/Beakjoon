package baekjoon.deque;

import java.util.Deque;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> d = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=1;i <= N;i++) {
			d.offerLast(i);
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int tcount = 0;
		int count = 0;
		int k = 0;
		
		while(st2.hasMoreTokens()) {
			int t = Integer.parseInt(st2.nextToken());
			
			if     (count <= -d.size())  count += d.size();
			else if(count >=  d.size())  count -= d.size();
			
			k = t + count;
			
			if(k <= 0)            k +=  d.size();
			else if(k > d.size()) k += -d.size();
			
			if(k-1 < d.size()-k+1) {
				while(t != d.peekFirst()) {
					d.offerLast(d.pollFirst());
					tcount++;
					count--;
				}
			}
			else {
				while(t != d.peekFirst()) {
					d.offerFirst(d.pollLast());
					tcount++;
					count++;
				}
			}
			d.pollFirst();
			count--;
		}
		
		bw.write(String.valueOf(tcount));
		bw.flush();
	}
}
