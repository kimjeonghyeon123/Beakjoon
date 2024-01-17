package test2;

/**
 * 도시 N개
 * 길이 있을수도 없을수도 있음 - 다익스트라
 * 여행 일정이 주어졌을 때 경로가 가능한 것인지 알아보자
 *
 * 1에서 2갈 수 있는지 2에서 3갈 수 있는지
 */

import java.io.*;
import java.util.*;

public class 여행가자 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(i == j) {
                    graph[i][j] = 1;
                }
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(graph[i][k] == 1 && graph[k][i] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean cango = true;
        for(int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(graph[start][now] == 0) {
                cango = false;
                break;
            }
        }

        if(cango) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
