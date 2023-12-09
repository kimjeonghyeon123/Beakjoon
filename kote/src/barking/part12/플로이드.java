package barking.part12;

/**
 * 도시 n개
 * 버스 m개
 * 모든 도시쌍에 대해서 비용 구하기
 */

import java.io.*;
import java.util.*;

public class 플로이드 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for(int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = Math.min(graph[x][y], z);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) {
                    sb.append("0 ");
                }
                else {
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
