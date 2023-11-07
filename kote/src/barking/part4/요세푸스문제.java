package barking.part4;

import java.io.*;
import java.util.*;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int j = 1; j < N; j++) {
            for(int i = 1; i < K; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll() + ", ");
        }
        sb.append(q.poll() + ">");
        System.out.println(sb.toString());
    }
}
