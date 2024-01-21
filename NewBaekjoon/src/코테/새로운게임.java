package 코테;

/**
 * N*N 체스판
 * 말의 개수 K개
 * 흰색, 빨간색, 파란색
 * 말 1~K개
 * 1번말부터 순서대로 이동
 *
 * 1) 흰색 칸
 *      말 위에 놓음
 * 2) 빨간 칸
 *      말 순서를 바꿔서 놓음
 * 3) 파란 칸
 *      말의 이동 방향을 바꿔서 한 칸
 *      이동하려는 칸이 파란색이면 방향만 바꾸고 가만히 있음
 */

import java.io.*;
import java.util.*;

public class 새로운게임 {
    public static class Horse {
        int x, y, dx, dy;
        public Horse(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }
    }
    public static int N, K;
    public static int[][] graph;
    public static Deque<Integer>[][] chess;
    public static Horse[] horses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        chess = new Deque[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                chess[i][j] = new LinkedList<>();
            }
        }

        horses = new Horse[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            switch(d) {
                case 1:
                    horses[i] = new Horse(x, y, 0, 1);
                    break;
                case 2:
                    horses[i] = new Horse(x, y, 0, -1);
                    break;
                case 3:
                    horses[i] = new Horse(x, y, -1, 0);
                    break;
                case 4:
                    horses[i] = new Horse(x, y, 1, 0);
                    break;
            }
            chess[x][y].offerLast(i);
        }

        int t = 0;
        while(t < 1000) {
            t++;
            for (int i = 0; i < K; i++) {
                // 원래위치
                int x = horses[i].x;
                int y = horses[i].y;

                //1번위치가 아니면 넘어감
                if (i != chess[x][y].peekFirst()) {continue;}

                // 이동위치
                int nx = x + horses[i].dx;
                int ny = y + horses[i].dy;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 2) {
                    horses[i].dx = -horses[i].dx;
                    horses[i].dy = -horses[i].dy;
                    nx = x + horses[i].dx;
                    ny = y + horses[i].dy;
                }

                //파란색이거나 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 2) {continue;}

                //흰색일 경우
                if (graph[nx][ny] == 0) {
                    while (!chess[x][y].isEmpty()) {
                        int horsenum = chess[x][y].pollFirst();
                        chess[nx][ny].offerLast(horsenum);
                        horses[horsenum].x = nx;
                        horses[horsenum].y = ny;
                    }
                }
                else if (graph[nx][ny] == 1) {
                    while (!chess[x][y].isEmpty()) {
                        int horsenum = chess[x][y].pollLast();
                        chess[nx][ny].offerLast(horsenum);
                        horses[horsenum].x = nx;
                        horses[horsenum].y = ny;
                    }
                }

                if(chess[nx][ny].size() >= 4) {
                    System.out.println(t);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
