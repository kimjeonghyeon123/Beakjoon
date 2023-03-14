package baekjoon.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Test10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> d = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push_front":
					d.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					d.offerLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(d.isEmpty()) {
						sb.append("-1\n");
						break;
					}
					else {
						sb.append(d.pollFirst() + "\n");
						break;
					}
				case "pop_back":
					if(d.isEmpty()) {
						sb.append("-1\n");
						break;
					}
					else {
						sb.append(d.pollLast() + "\n");
						break;
					}
				case "size":
					sb.append(d.size() + "\n");
					break;
				case "empty":
					if(d.isEmpty()) {
						sb.append("1\n");
						break;
					}
					else {
						sb.append("0\n");
						break;
					}
				case "front":
					if(d.isEmpty()) {
						sb.append("-1\n");
						break;
					}
					else {
						sb.append(d.peekFirst() + "\n");
						break;
					}
				case "back":
					if(d.isEmpty()) {
						sb.append("-1\n");
						break;
					}
					else {
						sb.append(d.peekLast() + "\n");
						break;
					}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
