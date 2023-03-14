package baekjoon.stack;
//
//import java.util.Scanner;
//
//public class Test2493 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		
//		int[] arr = new int[N];
//		
//		for(int i=0;i<N;i++)
//			arr[i] = sc.nextInt();
//		
//		
//		for(int i=0;i<N;i++) {
//			int t = 0;
//			for(int j=i-1;j>=0;j--) {
//				if(arr[i] < arr[j]) {
//					t = j+1;
//					break;
//				}
//			}
//			if(i==4) {
//				System.out.println(t);
//			}
//			else {
//				System.out.print(t + " ");
//			}
//		}
//		
//		sc.close();
//	}
//}


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Test2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(str[i]);
			
		}
		
		
		Iterator<Integer> iter = s.iterator();
		
	}
}
