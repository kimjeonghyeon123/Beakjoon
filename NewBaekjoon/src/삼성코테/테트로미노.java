package 삼성코테;

import java.io.*;
import java.util.*;

public class 테트로미노 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int max = 0;
    public static int N, M;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static Node[] nodes = new Node[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                nodes[0] = new Node(i, j);
                dfs(1, graph[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < depth; i++) {
            for(int j = 0; j < 4; j++) {
                int nx = nodes[i].x + dx[j];
                int ny = nodes[i].y + dy[j];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    nodes[depth] = new Node(nx, ny);
                    dfs(depth+1, sum + graph[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}