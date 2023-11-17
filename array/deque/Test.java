package baekjoon.deque;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
	
		Deque<Integer> d = new LinkedList<>();
		
		d.offerFirst(1);
		d.offerFirst(2);
		d.offerFirst(3);
		d.offerFirst(4);
		
		System.out.println(d.peekFirst());
	}
}
