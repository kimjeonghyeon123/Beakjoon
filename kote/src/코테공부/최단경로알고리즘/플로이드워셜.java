package 코테공부.최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 모든 경로 구하기 - DP
 * D[ab] = min(D[ab], D[ak] + D[kb])
 * 노드 개수가 500개 이하일 때만 사용해라
 * 다익스트라가 더 좋을 듯
 */
public class 플로이드워셜 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }

        // a에서 b로 가는 비용 c
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        // 플로이드 워셜 알고리즘
        // k : 거쳐가는 노드
        // i : 출발 노드
        // j : 도착 노드
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
