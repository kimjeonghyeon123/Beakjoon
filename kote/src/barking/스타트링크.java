package barking;

import java.io.*;
import java.util.*;

public class 스타트링크 {

    private static int F, S, G;
    private static int[] graph;
    private static int[] dt = new int[2];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        G = Integer.parseInt(st.nextToken()) - 1;
        dt[0] = Integer.parseInt(st.nextToken());
        dt[1] = -Integer.parseInt(st.nextToken());

        graph = new int[F];
        graph[S] = 1;
        q.offer(S);
        while(!q.isEmpty()) {
            int t = q.poll();
            if(t == G) {
                break;
            }

            for(int i = 0; i < 2; i++) {
                int nt = t + dt[i];
                if (nt < 0 || nt >= F) {
                    continue;
                }
                if (graph[nt] == 0) {
                    graph[nt] = graph[t] + 1;
                    q.offer(nt);
                }
            }
        }

        if(graph[G] == 0) {
            bw.write("use the stairs");
        }
        else {
            bw.write(String.valueOf(graph[G]-1));
        }
        bw.flush();
        bw.close();
    }
}
