package test2;

/**
 * 수빈 점 N
 * 동생 점 K
 *
 * 1) x -> x+1    1
 * 2) x -> x-1    1
 * 3) x -> 2*x    0
 *
 * dfs(x+1) 1
 * dfs(x-1) 1
 * dfs(2*x) 0
 *
 * 5 17
 *
 */

import java.io.*;
import java.util.*;

public class 숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX = 100001;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] d = new int[MAX];
        Arrays.fill(d, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        d[N] = 0;

        while(true) {
            int now = q.poll();

            if(now == K) {
                break;
            }
            int next = now * 2;
            if(next < MAX && d[next] > d[now]) {
                q.offer(next);
                d[next] = d[now];
            }
            next = now + 1;
            if(next < MAX && d[next] > d[now] + 1) {
                q.offer(next);
                d[next] = d[now] + 1;
            }
            next = now - 1;
            if(0 <= next && d[next] > d[now] + 1) {
                q.offer(next);
                d[next] = d[now] + 1;
            }
        }
        System.out.println(d[K]);
    }
}
