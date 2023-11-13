package barking.part8;

import java.io.*;
import java.util.*;

public class 괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int total = 0;
        int temp = 1;
        boolean isPop = false;
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                numStack.push(2);
            }
            else if(c == '[') {
                stack.push(c);
                numStack.push(3);
            }
            else {
                if (c == ')') {

                }
            }
        }
        bw.flush();
        bw.close();
    }
}
