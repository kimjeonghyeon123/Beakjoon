package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test10808 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		for(int i=97;i<123;i++) {
			int count=0;
			for(int j=0;j<str.length();j++) {
				if(i == str.charAt(j))
					count++;
			}
			if(i==122) {
				System.out.println(count);
				break;
			}
			System.out.print(count + " ");
		}
	} 
}
