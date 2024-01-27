package 삼성코테;

import java.io.*;
import java.util.*;

public class 사다리조작 {
    // N : 세로
    // M : 가로
    public static int N, M, H;
    public static int[][] graph;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[x][y+1] = -1;
        }

        dfs(0);

        System.out.println(min > 3 ? -1 : min);
    }

    public static void dfs(int depth) {
        if(isLinked()) {
            min = Math.min(min, depth);
        }

        if(depth == 3) {return;}

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(graph[i][j] == 0 && graph[i][j+1] == 0) {
                    graph[i][j] = 1;
                    graph[i][j+1] = -1;
                    dfs(depth+1);
                    graph[i][j] = 0;
                    graph[i][j+1] = 0;
                }
            }
        }
    }

    public static boolean isLinked() {
        // i가 사다리 번호
        for(int i = 1; i <= N; i ++) {
            int col = i;
            int row = 1;
            while(row <= H) {
                col += graph[row][col];
                row += 1;
            }
            if(col != i) {
                return false;
            }
        }
        return true;
    }
}
/**
 * N개 세로 선, M개 가로선
 * 인접한 세로 선 사이에 가로선을 놓을 수 있음
 * 세로 선마다 가로선을 놓을 수 있는 위치의 개수는 H
 *
 * 5 5 6
 * 1 1 1번 세로선과 2번 세로선을 1번 점선 위치에서 연결
 * 3 2 2번 세로선과 3번 세로선을 3번 점선 위치에서 연결
 * 2 3 3번 세로선과 4번 세로선을 2번 점선 위치에서 연결
 * 5 1
 * 5 4
 *
 *
 */