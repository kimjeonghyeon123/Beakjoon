package test2;

/**
 * 도시 N 개
 * 여행 경로 가능한지?
 */

import java.io.*;
import java.util.*;

public class 여행가자 {
    public static int N, M;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
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
                for(int j = 1; j <= N; j++) {
                    if(graph[i][j] == 0 && graph[i][k] == 1 && graph[k][j] ==1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean cango = true;
        for(int i = 1; i < M; i++) {
            int root = Integer.parseInt(st.nextToken());
            if(graph[start][root] == 0) {
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
