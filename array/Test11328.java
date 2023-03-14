package baekjoon.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test11328 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		N *= 2;
		String[] arr = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.next();
		}
		
		for(int i=0;i<N;i += 2) {	
			char[] arr1 = arr[i].toCharArray();
			char[] arr2 = arr[i+1].toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			if(String.valueOf(arr1).equals(String.valueOf(arr2))) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
		}
		sc.close();
	}
}
