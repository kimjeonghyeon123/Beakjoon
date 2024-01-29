package 삼성코테;

import java.io.*;
import java.util.*;

public class 인구이동 {
    public static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, L, R;
    public static int[][] graph;
    public static int[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int cnt = 1;
        while(true) {
            visited = new int[N][N];
            cnt = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = cnt;
                        dfs(i, j, cnt);
                        cnt++;
                    }
                }
            }

            find(cnt);
            result++;
        }
    }

    public static void dfs(int x, int y, int cnt) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
            int cha = Math.abs(graph[nx][ny] - graph[x][y]);
            if(visited[nx][ny] == 0 && L <= cha && cha <= R) {
                visited[nx][ny] = cnt;
                dfs(nx, ny, cnt);
            }
        }
    }

    public static void find(int cnt) {
        Stack<Node> stack = new Stack<>();
        for(int k = 1; k < cnt; k++) {
            int sum = 0;
            int size = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j] == i) {
                        sum += graph[i][j];
                        size++;
                        stack.push(new Node(i, j));
                    }
                }
            }

            while(!stack.isEmpty()) {
                Node node = stack.pop();
                graph[node.x][node.y] = sum / size;
            }
        }
    }
}
/**
 * N*N
 *
 * 인접하는 두 나라의 인구 차이가 L <= x <= R 이면 이동 가능
 * 모두 열렸다면 이동 시작
 * 각 칸의 인구수는 연합 인구수/칸의 개수가 됨
 *
 */