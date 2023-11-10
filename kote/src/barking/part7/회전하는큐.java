package barking.part7;

import java.io.*;
import java.util.*;

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int total = 0;
        for(int i = 0; i < M; i++) {
            int target_idx = dq.indexOf(Integer.parseInt(st2.nextToken()));
            int half_idx;

            if(dq.size() % 2 == 0) {
                half_idx = dq.size() / 2 -1;
            } else {
                half_idx = dq.size() / 2;
            }

            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                   dq.offerLast(dq.pollFirst());
                   total++;
                }
            } else {
                for(int j = 0; j < dq.size() - target_idx; j++) {
                    dq.offerFirst(dq.pollLast());
                    total++;
                }
            }

            dq.pollFirst();
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}
