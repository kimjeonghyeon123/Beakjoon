package 코테공부.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {

    public static int N, M;
    public static int[][] graph;

    public static boolean dfs(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        if(graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dfs(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
