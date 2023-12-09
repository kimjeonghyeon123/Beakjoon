package barking.part9;
/*
    수빈 N
    동생 K
    수빈 -> x+1 or x-1 or 2*x
    bfs
    1    5
    2 4 5
    +하는 방법보다 *2하는 법이 더 좋음
*/

import java.io.*;
import java.util.*;

public class 숨바꼭질3 {

    public static final int MAX = 100001;
    public static int N, K;
    public static int[] graph = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(graph, MAX);
        q.offer(N);
        graph[N] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == K) {break;}

            int next = now + 1;
            if(next < MAX && graph[next] > graph[now] + 1) {
                q.offer(next);
                graph[next] = graph[now] + 1;
            }
            next = now - 1;
            if(next >= 0 && next < MAX && graph[next] > graph[now] + 1) {
                q.offer(next);
                graph[next] = graph[now] + 1;
            }
            next = now * 2;
            if(next < MAX && graph[next] > graph[now]) {
                q.offer(next);
                graph[next] = graph[now];
            }
        }
        System.out.println(graph[K]);
    }
}