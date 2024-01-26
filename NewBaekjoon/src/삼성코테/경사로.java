package 삼성코테;

import java.io.*;
import java.util.*;

public class 경사로 {
    public static class Node{
        int x, y;
        char c;
        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static int N, L;
    public static int[][] graph;
    public static boolean[][] hasbridge;
    public static Node[][] bridges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        hasbridge = new boolean[N][N];
        bridges = new Node[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                bridges[i][j] = null;
            }
        }
    }

    public static void dfs(int x, int y) {
        //가로
        if(x + L < N && Math.abs(graph[x + L][y] - graph[x][y]) == 1) {
            boolean isSame = true;
            for (int i = 1; i < L; i++) {
                if (graph[x][y] != graph[x + i][y]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                bridges[x][y] = new Node(x+L, y, 'R');
                bridges[x+L][y] = new Node(x, y, 'L');
            }
        }
        if(y + L < N) {

        }
    }

    public static void count() {
        for(int i = 0; i < N; i++) {
            int height = graph[i][0];
            for(int j = 1; j < N; j++) {

            }
        }
    }
}

/**
 * N*N
 * 한 행 또는 한 열을 한쪽 끝에서 끝으로 지나갈 수 있는지
 * 길을 지나가려면 길에 속한 모든 칸의 높이가 모두 같아야 함
 * 높이가 1 차이나는 경우 : 길이가 L인 경사로 설치
 * 길이가 L인 높이가 같은 칸이 있고 그 이후 칸이 1차이여야 함
 * 경사로 있는 곳에 경사로 못 놓음
 *
 * L만큼 더했을 때 되는 곳에 다리를 더해
 * 3 -> 3 그냥 이동
 * 3 -> 4 다리가 있는지 확인
 *
 * 경사로를 표현하는 방법!!
 * (i,j) -> (i+L-1, j)  이렇게 계단이 있을텐데
 * 리스트에서 (i,j)에 경사로가 있는지 확인
 *
 * 다리가 없고 i, i+1, ..., i+L-1 이 같은 높이이고 i+L이 다른 높이 일 때 다리 놓을 수 있음
 *
 */