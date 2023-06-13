package list;

import java.io.*;

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String str = Integer.toString(A * B * C);
		
		for(char c = '0'; c <= '9'; c++) {
			int count = 0;
			for(int j = 0; j < str.length(); j++) {
				if(c == str.charAt(j)) {
					count++;
				}
			}
			System.out.println(count);
		}
		
		bw.flush();
		
	}
	
}
