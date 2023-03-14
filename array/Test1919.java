package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.ListIterator;
import java.util.Stack;

//public class Test1919 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = Integer.parseInt(br.readLine());
//		for(int i=0;i<n;i++) {
//			String str = br.readLine();
//			LinkedList<Character> list = new LinkedList<Character>();
//			ListIterator<Character> iter = list.listIterator();
//			
//			for(int j=0;j<str.length();j++) {
//				switch (str.charAt(j)){
//					case '<':
//						if(iter.hasPrevious())
//							iter.previous();
//						break;
//					case '>':
//						if(iter.hasNext())
//							iter.next();
//						break;
//					case '-':
//						if(iter.hasPrevious()) {
//							iter.previous();
//							iter.remove();
//						}
//						break;
//					default :
//						iter.add(str.charAt(j));
//						break;
//				}
//			}
//			
//			StringBuilder sb = new StringBuilder();
//			for(char chr : list) {
//				sb.append(chr);
//			}
//			System.out.println(sb.toString());
//		}
//	}
//}

public class Test1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			Stack<String> left = new Stack<>();
			Stack<String> right = new Stack<>();
			
			for(int j=0;j<str.length();j++) {
				switch (str.charAt(j)){
					case '<':
						if(!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case '>':
						if(!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case '-':
						if(!left.isEmpty()) {
							left.pop();
						}
						break;
					default :
						left.push(String.valueOf(str.charAt(j)));
						break;
				}
			}
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

