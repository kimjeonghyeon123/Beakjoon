package barking.part5;

import java.io.*;
import java.util.*;

public class 옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long total = 0;

        for(int i = 1; i <= N; i++) {
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            stack.push(height);

            total += stack.size() - 1;
        }

        bw.write(total + "\n");
        bw.flush();
        bw.close();
    }
}
