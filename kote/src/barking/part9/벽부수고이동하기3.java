package barking.part9;

/**
 * N, M 행렬
 * 0 이동, 1 벽
 * 1,1 ~ N,M 최단경로
 * 같은 칸에 머무르는 것도 가능
 *
 * 가장 처음 낮
 * 한 번 이동마다 밤낮이 바뀜
 * 벽은 낮에만 부술 수 있음
 */

import java.io.*;
import java.util.*;

class NodeC {
    int x, y, len, broke;
    public NodeC(int x, int y, int len, int broke) {
        this.x = x;
        this.y = y;
        this.len = len;
        this.broke = broke;
    }
}
public class 벽부수고이동하기3 {
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

        Queue<NodeC> q = new LinkedList<>();
        q.offer(new NodeC(0, 0, 1, 0));
        visited[0][0][0] = true;

        int result = -1;
        while(!q.isEmpty()) {
            NodeC node = q.poll();
            int x = node.x;
            int y = node.y;
            int len = node.len;
            int broke = node.broke;

            if(x == N-1 && y == M-1) {
                result = len;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(graph[nx][ny] == 0) {
                    if(!visited[nx][ny][broke]) {
                        q.offer(new NodeC(nx, ny, len+1, broke));
                        visited[nx][ny][broke] = true;
                    }
                }
                else {
                    if(len % 2 == 1) {
                        if(broke + 1 <= K && !visited[nx][ny][broke+1]) {
                            q.offer(new NodeC(nx, ny, len+1, broke+1));
                            visited[nx][ny][broke+1] = true;
                        }
                    }
                    else {
                        q.offer(new NodeC(x, y, len+1, broke));
                    }
                }
            }
        }

        System.out.println(result);
    }
}
