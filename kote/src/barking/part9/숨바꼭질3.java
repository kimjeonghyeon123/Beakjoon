package barking.part9;
/*
    수빈 N
    동생 K
    수빈 -> x+1 or x-1 or 2*x
    bfs로 방문한 곳 방문 안하면서 가보기
*/

import java.io.*;
import java.util.*;

public class 숨바꼭질3 {

    public static final int MAX = 100001;
    public static int N, K;
    public static int[] graph = new int[MAX];
    public static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;

        while(!q.isEmpty()) {
            int num = q.poll();

            if(num == K) {break;}
            if(num + 1 < MAX && !visited[num+1]) {
                q.offer(num+1);
                graph[num+1] = Math.max(graph[num+1], graph[num] + 1);
                visited[num+1] = true;
            }
            if(num - 1 >= 0 && num - 1 < MAX && !visited[num-1]) {
                q.offer(num-1);
                graph[num-1] = Math.max(graph[num-1], graph[num] + 1);
                visited[num-1] = true;
            }
            if(num * 2 < MAX && !visited[num*2]) {
                q.offer(num*2);
                graph[num*2] = Math.max(graph[num*2], graph[num]);
                visited[num*2] = true;
            }
        }

        System.out.println(graph[K]);
    }
}