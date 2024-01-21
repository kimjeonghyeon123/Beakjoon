package 코테;

/**
 * 무튜브 : 1~N
 * 유사도
 * N-1개의 동영상
 * 동영상 V를 보고 있을 때, 유사도가 K이상인 동영상 추천해줌
 *
 * (1,2) : 3
 * (2,3) : 2
 * =
 * (1,3) : 2
 * for(int i = 0; i < N; i++) {
 *     for(int j = 0; j < N; j++) {
 *         if(i==j) continue;
 *         graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][i]
 *
 *     }
 * }
 */

import java.io.*;
import java.util.*;

public class MooTube {
    public static class Node {
        int indx, distance;
        public Node(int indx, int distance) {
            this.indx = indx;
            this.distance = distance;
        }
    }
    public static int N, Q;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p][q] = r;
            graph[q][p] = r;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    graph[i][j] = Math.min(graph[i][j], Math.min(graph[i][k], graph[k][j]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(j == v) continue;
                if(graph[v][j] >= k) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
