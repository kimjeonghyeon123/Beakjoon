package baekjoon.linkedlist;

import java.util.*;

public class Test5397 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] sarr = new String[n];
		
		for(int i=0;i<n;i++)
			sarr[i] = sc.next();
		
		ArrayList<Character> carr;
		for(int i=0;i<n;i++) {
			int cursor = 0;
			carr = new ArrayList<>();
			for(int j=0;j<sarr[i].length();j++) {
				switch(carr.get(j)) {
					case '<':
						if(cursor == 0) break;
						cursor--;
						break;
					case '>':
						if(cursor == carr.size()) break;
						cursor++;
						break;
					case '-':
						if(cursor == 0) break;
						carr.remove(i);
						cursor--;
						break;
					default :
						carr.add(sarr[i].charAt(j));
						cursor++;
						break;
				}
			}
			for(int j=0;j<carr.size();j++) {
				System.out.print(carr.get(j));
			}
			System.out.println();
		}
		
		sc.close();
	}
}
