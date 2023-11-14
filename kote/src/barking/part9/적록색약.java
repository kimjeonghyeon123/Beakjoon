package barking.part9;

import java.io.*;
import java.util.*;

public class 적록색약 {

    private static int N;
    private static char[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());


        graph = new char[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int result1 = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    result1++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N][N];
        int result2 = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    result2++;
                }
            }
        }

        bw.write(String.format("%d %d\n", result1, result2));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char c = graph[x][y];
        for(int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= N) {
                continue;
            }
            if(!visited[new_x][new_y] && graph[new_x][new_y] == c) {
                dfs(new_x, new_y);
            }
        }
    }
}
