package 동빈나.DFSBFS;

import java.io.*;
import java.util.*;

public class Dfsbfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //스택
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("after pop stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());

        System.out.println();

        //큐
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("queue = " + queue);
        queue.poll();
        System.out.println("after poll queue = " + queue);
        System.out.println("queue.peek() = " + queue.peek());

        bw.flush();
        bw.close();
    }
}
