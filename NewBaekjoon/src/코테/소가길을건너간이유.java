package 코테;

/**
 * N*N 목초지
 * 일부는 길을 건너야 됨
 * K마리 소가 존의 농장에 있음
 *
 * 어떤 소는 길을 건너지 않으면 못 만남
 * 몇 쌍인지?
 * (2,2) <-> (2,3) = INF
 * (3,3) <-> (3,2) = INF
 *
 * 0 1 2
 * 3 4 5
 * 6 7 8
 *
 * (i,j) = i*N + j
 *
 * 4번 <-> 5번
 * 8번 <-> </->
 * 1 더하거나 뺀 경우는 같음
 * N 빼거나 같은 경우는 같음
 */

import java.io.*;
import java.util.*;

public class 소가길을건너간이유 {
    public static int N, K, R;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N*N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < N*N; i++) {
            if(i - 1 >= 0) {
                graph.get(i).add(i-1);
            }
            if(i - N >= 0) {
                graph.get(i).add(i-N);
            }
            if(i + 1 < N*N) {
                graph.get(i).add(i+1);
            }
            if(i + N < N*N) {
                graph.get(i).add(i+N);
            }
        }
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int x = x1 * N + y1;
            int y = x2 * N + y2;
            int size = graph.get(x).size();
            for (int j = 0; j < size; j++) {
                if(y == graph.get(x).get(j)) {
                    graph.get(x).remove(j);
                    break;
                }
            }
            size = graph.get(y).size();
            for (int j = 0; j < size; j++) {
                if(x == graph.get(y).get(j)) {
                    graph.get(y).remove(j);
                    break;
                }
            }
        }

        int[] arr = new int[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[i] = x * N + y;
        }

        int cnt = 0;
        for(int i = 0; i < N-1; i++) {
            dijkstra(arr[i]);
            for(int j = i+1; j < N; j++) {
                if(!visited[arr[j]]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();

        visited = new boolean[N*N];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
