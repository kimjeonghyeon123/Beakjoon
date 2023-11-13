package barking.part8;

import java.io.*;
import java.util.*;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean isPop = false;
        int total = 0;
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                isPop = false;
                continue;
            }
            stack.pop();
            if(isPop) {total++;}
            else {total += stack.size();}
            isPop = true;
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}
