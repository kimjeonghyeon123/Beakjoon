package barking.part8;

import java.io.*;
import java.util.*;

public class 좋은단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            cnt += isGood(br.readLine());
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static int isGood(String str) {
        Stack<Character> stack = new Stack<>();

        boolean err = false;
        int len = str.length();

        for(int i = 0; i < len; i++) {

            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }

            if(len - i < stack.size() + 1) {
                return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
