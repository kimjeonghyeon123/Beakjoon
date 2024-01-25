package 삼성코테;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
    public static class Node{
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static boolean[][] cleaned;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static Node robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        robot = new Node(x ,y, d);

        graph = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cleaned[i][j]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void clean() {
        while(true) {
            int x = robot.x;
            int y = robot.y;
            int d = robot.d;

            // 청소 안했으면 청소하기
            if(!cleaned[x][y]) {cleaned[x][y] = true;}

            boolean hasUncleanedRoom = false;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(graph[nx][ny] == 0 && !cleaned[nx][ny]) {
                    hasUncleanedRoom = true;
                    break;
                }
            }

            if(hasUncleanedRoom) {
                robot.d = (d != 0) ? d - 1 : 3;
                int nx = x + dx[robot.d];
                int ny = y + dy[robot.d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(graph[nx][ny] == 0 && !cleaned[nx][ny]) {
                    robot.x = nx;
                    robot.y = ny;
                }
            }
            else {
                int nx = x - dx[d];
                int ny = y - dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || graph[nx][ny] == 1) {
                    break;
                }
                robot.x = nx;
                robot.y = ny;
            }
        }
    }
}
/**
 * 서북동남
 * N*M
 * 1) 현재 칸이 아직 청소안됐으면 청소함
 * 2) 현재칸 주변 4칸 중 청소되지 않은 빈 칸이 없으면
 *      - 바라보는 방향 그대로 유지 후 한칸 휴진
 *          - 뒤쪽 칸이 벽이면 작동 멈춤
 * 3) 청소되지 않은 빈 칸이 있는 경우
 *      - 왼쪽으로 90도 회전
 *      - 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않았으면 한 칸 전진
 */