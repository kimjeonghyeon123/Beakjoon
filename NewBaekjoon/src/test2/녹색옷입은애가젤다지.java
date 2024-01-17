package test2;

/**
 * N*N (0,0)칸에 있음
 * [N-1][N-1]까지 가야함
 * 각 칸마다 도둑루피가 있는데 최소금액
 *
 * 모든 경로 다 확인해야 함
 * dfs
 * visited
 */

import java.io.*;
import java.util.*;

public class 녹색옷입은애가젤다지 {

    public static class Node implements Comparable<Node> {
        int x, y, distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            if(distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    public static final int INF = Integer.MAX_VALUE;
    public static int N;
    public static int[][] graph;
    public static int[][] d;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {break;}

            graph = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(T).append(": ").append(bfs()).append("\n");
            T++;
        }
        System.out.println(sb.toString());
    }

    public static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, graph[0][0]));
        d = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
        }
        d[0][0] = graph[0][0];

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int nowX = node.x;
            int nowY = node.y;
            int dist = node.distance;

            if(d[nowX][nowY] < dist) {continue;}

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {continue;}
                //다음 노드까지의 비용
                int cost = d[nowX][nowY] + graph[nextX][nextY];
                if(cost < d[nextX][nextY]) {
                    d[nextX][nextY] = cost;
                    pq.offer(new Node(nextX, nextY, cost));
                }
            }
        }
        return d[N-1][N-1];
    }
}
