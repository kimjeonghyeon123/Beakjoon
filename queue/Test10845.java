package baekjoon.queue;

import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class Test10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<N;i++) {
			String s = sc.nextLine();
			String[] str = s.split(" ");
			switch(str[0]) {
				case "push":
					queue.offer(Integer.parseInt(str[1]));
					break;
				case "pop":
					if(queue.isEmpty()) System.out.println(-1);
					else System.out.println(queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					if(queue.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				case "front":
					if(queue.isEmpty()) System.out.println(-1);
					else System.out.println(queue.peek());
					break;
				case "back":
					if(queue.isEmpty()) System.out.println(-1);
					else {
						Iterator<Integer> iter = queue.iterator();
						int t=-1;
						while(iter.hasNext()) {
							t = iter.next();
						}
						System.out.println(t);
					}
					break;
 			}
		}
		sc.close();
	}
}
