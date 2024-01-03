package barking.part9;

/**
 * N * M 행렬
 * 0은 이동가능 1은 벽
 * (1,1) ~ (N, M) 위치까지 최단거리 이동
 * 벽을 K개 까지 부수고 이동가능
 *
 * 0일 경우 그냥 감
 * 1일 경우 부숨
 */

import java.io.*;
import java.util.*;

class NodeB {
    int x, y, broke, len;
    public NodeB(int x, int y, int broke, int len) {
        this.x = x;
        this.y = y;
        this.broke = broke;
        this.len = len;
    }
}
public class 벽부수고이동하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K+1];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<NodeB> q = new LinkedList<>();
        q.offer(new NodeB(0, 0, 0, 1));

        int reuslt = -1;
        while(!q.isEmpty()) {
            NodeB node = q.poll();
            int x = node.x;
            int y = node.y;
            int broke = node.broke;
            int len = node.len;

            if(x == N-1 && y == M-1) {
                reuslt = len;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(graph[nx][ny] == 0) {
                    if(!visited[nx][ny][broke]) {
                        q.offer(new NodeB(nx, ny, broke, len+1));
                        visited[nx][ny][broke] = true;
                    }
                }
                else {
                    if(broke+1 <= K && !visited[nx][ny][broke+1]) {
                        q.offer(new NodeB(nx, ny, broke+1, len+1));
                        visited[nx][ny][broke+1] = true;
                    }
                }
            }
        }

        System.out.println(reuslt);
    }
}
