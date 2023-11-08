package barking.part5;

import java.io.*;
import java.util.*;

class Top {
    public int order;
    public int height;
    public int result;
}

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Top[] arr = new Top[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new Top();
            arr[i].order = i + 1;
            arr[i].height = Integer.parseInt(st.nextToken());
        }

        Stack<Top> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                arr[i].result = 0;
            }
            else if(stack.peek().height > arr[i].height) {
                arr[i].result = stack.peek().order;
                stack.push(arr[i]);
            }
            else if(stack.peek().height < arr[i].height) {
                while(!stack.isEmpty()) {
                    if(stack.peek().height > arr[i].height) {
                        break;
                    }
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    arr[i].result = 0;
                }
                else {
                    arr[i].result = stack.peek().order;
                }
                stack.push(arr[i]);
            }
        }

        for(Top top : arr) {
            bw.write(String.valueOf(top.result) + " ");
        }
        bw.flush();
        bw.close();
    }
}
