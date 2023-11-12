package barking.part8;

import java.io.*;
import java.util.*;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        boolean err;
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            err = false;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '[' || c == '(') {
                    stack.push(c);
                    continue;
                }
                if(c == ']') {
                    if(stack.isEmpty()) {
                        err = true;
                        break;
                    }
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        err = true;
                        break;
                    }
                }
                else if(c == ')') {
                    if(stack.isEmpty()) {
                        err = true;
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        err = true;
                        break;
                    }
                }
            }

            if(err || !stack.isEmpty()) {
                sb.append("no\n");
            }
            else {
                sb.append("yes\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
