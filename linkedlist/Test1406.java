package baekjoon.linkedlist;
/*
 * LinkedList는 ArrayList보다 자료의 추가, 삭제가 빠르다.
 * for-each문을 이용하는 것이 조회할 때 훨씬 빠르다.
 * for-each문이 내부적으로 iterator를 사용하기 때문이다.
 * ListIterator<Character> iter = list.listIterator();
 * ListIterator를 이용해 연결리스트를 커서를 사용해 조회할 수 있도록 한다.
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str    = br.readLine();
		int    M      = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<Character>();
		
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i=0;i<M;i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			switch(c) {
				case 'L':
					if(iter.hasPrevious())
						iter.previous();
					break;
				case 'D':
					if(iter.hasNext())
						iter.next();
					break;
				case 'B':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case 'P':
					char t = command.charAt(2);
					iter.add(t);
					break;
				default:
					break;
			}
		}
		
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}
