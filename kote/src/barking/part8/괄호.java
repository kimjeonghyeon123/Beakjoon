package barking.part8;

import java.io.*;
import java.util.*;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            if(VPS(br.readLine()))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean VPS(String str) {

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {

            if(c == '(') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty())
                return false;

            stack.pop();
        }
        return stack.isEmpty();
    }
}
