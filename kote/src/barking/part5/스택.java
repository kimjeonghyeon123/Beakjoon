package barking.part5;

import java.io.*;
import java.util.*;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.isEmpty()) { sb.append(stack.pop() + "\n"); }
                    else { sb.append("-1\n"); }
                    break;
                case "size":
                    sb.append(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()) { sb.append("1\n"); }
                    else { sb.append("0\n"); }
                    break;
                case "top":
                    if(!stack.isEmpty()) { sb.append(stack.peek() + "\n"); }
                    else { sb.append("-1\n"); }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
