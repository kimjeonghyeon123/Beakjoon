package barking.part5;

import java.io.*;
import java.util.*;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {stack.pop();}
            else         {stack.push(num);}
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
