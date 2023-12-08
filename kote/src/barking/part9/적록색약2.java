package barking.part9;

/**
 * R, G, B 로 나눠짐
 *
 */

import java.io.*;
import java.util.*;

public class 적록색약2 {

    public static int n;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && dfs(i, j)) {
                    result++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append(" ");

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == 'R') {
                    graph[i][j] = 'G';
                }
            }
        }

        result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && dfs(i, j)) {
                    result++;
                }
            }
        }

        sb.append(result);
        System.out.println(sb.toString());
    }

    public static boolean dfs(int x, int y) {
        char c = graph[x][y];
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) {continue;}
            if(!visited[nx][ny] && graph[nx][ny] == c) {
                dfs(nx, ny);
            }
        }
        return true;
    }
}
