package barking.part5;

import java.io.*;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int start = 1;
        boolean err = false;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (start <= num) {
                stack.push(start);
                sb.append("+\n");
                start++;
            }
            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                err = true;
            }

            if(err) {
                break;
            }
        }

        if(err) {
            bw.write("NO\n");
        }
        else {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
