package 코테공부.최단경로알고리즘;

/**
 * 1번 ~ N번 회사 - 특정 회사끼리 연결
 * A는 1번 회사에 위치함
 * X번 회사에 방문해 물건 판매
 * K번 회사에서 소개팅
 * 1 -> K -> X
 * 가장 빠른 경로 골라
 */

import java.io.*;
import java.util.*;

public class 미래도시 {

    public static final int INF = (int) 1e9;
    public static int N, M, X, K;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < N; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken()) - 1;

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int distance = graph[0][K] + graph[K][X];
        if(distance >= INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(distance);
        }
    }
}
/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
 */