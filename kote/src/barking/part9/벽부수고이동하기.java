package barking.part9;

/**
 * N * M 행렬
 * 0은 이동 가능, 1은 이동 불가능
 * 벽 한개까지 부수고 이동 가능
 *
 * 0 0 0 1 0 1
 * 0 0 0 1 0 1
 * 0 1 1 0 0 0
 * 0 0 0 0 1 0
 *
 * 1을 만나면 부시고 이동해보자 broken = true
 * 0을 만나면 그냥 이동하자
 *
 */

import java.io.*;
import java.util.*;

class Node5 {
    private int x, y, cnt;
    private boolean destroyed;

    public Node5(int x, int y, int cnt, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroyed = destroyed;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getCnt() {return cnt;}
    public boolean isDestroyed() {return destroyed;}
}
public class 벽부수고이동하기 {

    public static int N, M;
    public static char[][] graph;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node5> q = new LinkedList<>();
        q.offer(new Node5(0, 0, 1, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node5 node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int cnt = node.getCnt();

            if(x == N-1 && y == M-1) {return cnt;}
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(graph[nx][ny] == '0') {
                    if(!node.isDestroyed() && !visited[nx][ny][0]) {
                        q.offer(new Node5(nx, ny, cnt+1, false));
                        visited[nx][ny][0] = true;
                    }
                    else if(node.isDestroyed() && !visited[nx][ny][1]) {
                        q.offer(new Node5(nx, ny, cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else if(graph[nx][ny] == '1') {
                    if(!node.isDestroyed()) {
                        q.offer(new Node5(nx, ny, cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
