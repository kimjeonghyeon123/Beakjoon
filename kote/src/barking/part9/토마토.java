package barking.part9;

import java.io.*;
import java.util.*;

public class 토마토 {

    private static int N, M;
    private static int[][] graph;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
                if(graph[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        bw.write(String.valueOf(dfs()));
        bw.flush();
        bw.close();
    }

    private static int dfs() {
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(graph[nx][ny] == -1) {
                    continue;
                }

                if(graph[nx][ny] == 0 /*|| graph[nx][ny] > graph[x][y] + 1*/) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    return -1;
                }
                else if(graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }
        return max-1;
    }
}
