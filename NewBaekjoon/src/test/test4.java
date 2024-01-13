package test; /**
 * 우주 탐사선
 * 모든 행성을 탐사하는데 걸리는 최소 시간 계산
 * 아나호가 탐색할 행성의 개수
 * 아나호가 발사되는 행성의 위치
 * 아나호가 행성 간 이동하는데 걸리는 시간
 * i,j = i에서 j까지 시간
 *
 * i -> 모든 행성
 * 3 0
 * d[0][1] + d[1][2]
 * d[0][2] + d[2][1]
 * 중 최소값
 *
 * 4 0
 * d[0][1] + d[1][2] + d[2][3]
 * d[0][1] + d[1][3] + d[3][2]
 * d[0][2] + d[2][1] + d[1][3]
 * d[0][2] + d[2][3] + d[3][1]
 * d[0][3] + d[3][1] + d[1][2]
 * d[0][3] + d[3][2] + d[2][1]
 */

import java.io.*;
import java.util.*;

public class test4 {

    public static int ans = Integer.MAX_VALUE;
    public static int N, K;
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        visited[K] = true;
        dfs(0, K, 0);

        System.out.println(ans);
    }

    public static void dfs(int level, int start, int sum) {
        if(level == N-1) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(level+1, i, sum + graph[start][i]);
                visited[i] = false;
            }
        }
    }
}