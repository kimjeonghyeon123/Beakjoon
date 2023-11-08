package barking.part5;

import java.io.*;
import java.util.*;

class Number {
    public int num;
    public int result;

    public Number(int num, int result) {
        this.num = num;
        this.result = result;
    }
}

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Number[] arr = new Number[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = new Number(Integer.parseInt(st.nextToken()), -1);
        }

        Stack<Number> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && stack.peek().num < arr[i].num) {
                stack.peek().result = arr[i].num;
                stack.pop();
            }
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(Number num : arr) {
            sb.append(num.result + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
