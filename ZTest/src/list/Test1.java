package list;

import java.io.*;

public class Test1 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		while(st.hasMoreTokens()) {
//			String str = st.nextToken();
//			bw.write(str + "\n");
//		}
		
		String str = br.readLine();
		
		for(int i=97;i<123;i++) {
			int count = 0;
			for(int j=0;j<str.length();j++) {
				if(i == str.charAt(j)) {
					count++;
				}
			}
			if(i==122) {
				System.out.print(count);
			}
			else {
				System.out.print(count + " ");
			}
		}
		
		bw.flush();
		
	}
	
}
