package 삼성코테;

import java.io.*;
import java.util.*;

public class 원판돌리기 {
    public static int N, M, T;
    public static int[][] graph;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int num = 1;
            if(d == 0) {
                while(x * num <= N) {
                    for(int i = 0; i < k; i++)
                        normal_clock(x*num);
                    num++;
                }
            }
            else {
                while(x * num <= N) {
                    for(int i = 0; i < k; i++)
                        reverse_clock(x*num);
                    num++;
                }
            }

            boolean isdelete = false;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(graph[i][j] != 0 && delete_num(i, j, graph[i][j])) {
                        isdelete = true;
                    }
                }
            }

            if(isdelete) {continue;}

            int numcnt = 0;
            int sum = 0;
            for(int row = 1; row <= N; row++) {
                for(int col = 1; col <= M; col++) {
                    if(graph[row][col] != 0) {
                        numcnt++;
                        sum += graph[row][col];
                    }
                }
            }
            double avg = (double)sum / numcnt;

            for(int row = 1; row <= N; row++) {
                for(int col = 1; col <= M; col++) {
                    if(graph[row][col] == 0) {continue;}
                    if(avg < graph[row][col]) {
                        graph[row][col]--;
                    }
                    else if(avg > graph[row][col]) {
                        graph[row][col]++;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += Arrays.stream(graph[i]).sum();
        }
        System.out.println(sum);
    }

    public static boolean delete_num(int x, int y, int num) {
        boolean isExist = false;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || nx > N) {continue;}
            if(ny == M+1) {ny = 1;}
            if(ny == 0) {ny = M;}
            if(num == graph[nx][ny]) {
                graph[x][y] = 0;
                graph[nx][ny] = 0;
                delete_num(nx, ny, num);
                isExist = true;
            }
        }

        return isExist;
    }

    public static void normal_clock(int row) {
        int temp = graph[row][M];
        for(int col = M; col >= 2; col--) {
            graph[row][col] = graph[row][col-1];
        }
        graph[row][1] = temp;
    }

    public static void reverse_clock(int row) {
        int temp = graph[row][1];
        for(int col = 1; col <= M-1; col++) {
            graph[row][col] = graph[row][col+1];
        }
        graph[row][M] = temp;
    }
}
/**
 * 반지름 1,2 ~N
 * (i, j) : i번째 원판에 있는 j번째 수의 위치
 *
 * 같은 위치에 있는 것끼리 인접함
 * xi의 배수인 원판 회전 di 바얗ㅇ을 k칸 회전 시킴
 *  0 dms 시계 1은 반시계
 */