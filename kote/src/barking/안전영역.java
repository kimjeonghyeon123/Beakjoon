package barking;

import java.io.*;
import java.util.*;

public class 안전영역 {

    private static int N, max;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        max = 0;
        int t = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                t = Integer.parseInt(st.nextToken());
                graph[i][j] = t;
                if(t > max) {
                    max = t;
                }
            }
        }

        int max_count = 0;
        int count = 0;
        for(int h = max; h >= 0; h--) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && dfs(i, j, h)){
                        count++;
                    };
                }
            }
            if(max_count < count) {
                max_count = count;
            }
        }

        bw.write(String.valueOf(max_count));
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int x, int y, int h) {
        if(graph[x][y] <= h) {
            return false;
        }
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if(graph[nx][ny] <= h || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny, h);
        }

        return true;
    }
}
