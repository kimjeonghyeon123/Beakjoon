package barking.part11;

/**
 * N*M 미로
 * 벽은 평소에 이동 불가
 * AOJ를 사용해 부술 수 있음
 * (1,1)에서 (N,M)으로 가려면 최소 몇개의 벽을 부숴야 하는가?
 * d[1][N][0] d[1][N][1] d[1][N][2] ~~
 */

import java.io.*;
import java.util.*;

class NodeP implements Comparable<NodeP> {
    int x,y, cnt;
    public NodeP(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(NodeP o) {
        if(cnt < o.cnt) {
            return -1;
        }
        return 1;
    }
}
public class 알고스팟 {
    public static int N, M;
    public static char[][] graph;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[M][N];

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<NodeP> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];
        pq.offer(new NodeP(0,0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            NodeP node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if(x == M-1 && y == N-1) {
                return cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {continue;}
                if (graph[nx][ny] == '0') {
                    if(!visited[nx][ny]) {
                        pq.offer(new NodeP(nx, ny, cnt));
                        visited[nx][ny] = true;
                    }
                }
                else {
                    if(!visited[nx][ny]) {
                        pq.offer(new NodeP(nx, ny, cnt+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return 0;
    }
}
