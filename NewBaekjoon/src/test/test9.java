package test; /**
 * N X M
 * int[][] graph = new int[N][M];
 * 적어도 두 변 이상이 접한 것은 1시간 안에 녹음
 *
 * 치즈로 둘러쌓여 있는 공간은 공기로 치지 않음
 * 치즈가 모두 녹는데 걸리는 시간
 *
 * 1) 공기 0, 치즈 1로 표시
 * 2) [0][0]에서 dfs로 바깥 공기인 곳 0인 곳을 2로 표시
 * 3) 안쪽 공기인 곳, 즉 2가 아닌 공기들을 3으로 표시
 * 공기 퍼뜨리기
 *
 */

import java.io.*;
import java.util.*;

public class test9 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static boolean[][] freshair;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while(true) {
            // 공기 퍼뜨리기
            freshair = new boolean[N][M];
            if(fresh()) {
                break;
            }

            // 치즈 녹이기
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    // 치즈일 경우
                    if (graph[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            // 신선한 공기일 경우
                            if (freshair[nx][ny]) {cnt++;}
                            if (cnt == 2) {
                                graph[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            result++;
        }
        System.out.println(result);
    }

    public static boolean fresh() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        freshair[0][0] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                // 0이면서 방문 안한곳
                if(graph[nx][ny] == 0 && !freshair[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    freshair[nx][ny] = true;
                }
            }
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if(graph[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
