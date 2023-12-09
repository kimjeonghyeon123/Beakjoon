package barking.part9;

/**
 * 빙산 녹음
 * 자연수는 빙산 높이
 * 0은 바다
 * 1년동안 바닷물 접한 면의 수만큼 녹음
 * 2 덩어리로 분리되는데 걸리는 년 구하기
 */

import java.io.*;
import java.util.*;

class Ice {
    private int x, y;
    public Ice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
}
public class 빙산 {

    public static int N, M;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            int cnt = separateNum();
            if(cnt == 0) {
                year = 0;
                break;
            }
            if(cnt >= 2) {break;}
            melting();
            year++;
        }
        System.out.println(year);
    }

    public static int separateNum() {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
            if(graph[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void melting() {
        Queue<Ice> q = new LinkedList<>();

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] != 0) {
                    q.offer(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Ice ice = q.poll();
            int x = ice.getX();
            int y = ice.getY();
            int seaNum = 0;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(!visited[nx][ny] && graph[nx][ny] == 0) {
                    seaNum++;
                }
            }

            if(graph[x][y] - seaNum < 0) {
                graph[x][y] = 0;
            }
            else {
                graph[x][y] -= seaNum;
            }
        }
    }
}
