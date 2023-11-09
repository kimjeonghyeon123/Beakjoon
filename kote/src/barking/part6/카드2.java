package barking.part6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while(q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }

        bw.write(q.poll() + "\n");
        bw.flush();
        bw.close();
    }
}
