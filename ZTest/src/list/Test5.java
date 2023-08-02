package list;

import java.io.*;
import java.util.*;

public class Test5 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)) ;
		
		int N = Integer.parseInt(br.readLine());
		String[] reader = new String[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			if(v == Integer.parseInt(st.nextToken())) {
				count++;
			}
		}
		
		bw.write("" + count);
		bw.flush();
		
	}
	
}
