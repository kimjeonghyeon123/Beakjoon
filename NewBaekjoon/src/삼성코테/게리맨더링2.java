package 삼성코테;

import java.io.*;
import java.util.*;

public class 게리맨더링2 {
    public static int N;
    public static int[][] A, graph;
    public static int totalNum = 0;
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 인구수
        A = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                totalNum += A[i][j];
            }
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 > N) continue;
                        if (y - d1 <= 0 || y + d2 > N) continue;

                        find(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void find(int x, int y, int d1, int d2) {
        int[] arr = new int[5];

        graph = new int[N+1][N+1];
        for(int i = 0; i <= d1; i++)
            graph[x + i][y - i] = 5;
        for(int i = 0; i <= d2; i++)
            graph[x+i][y+i] = 5;
        for(int i = 0; i <= d2; i++)
            graph[x+d1+i][y-d1+i] = 5;
        for(int i = 0; i <= d1; i++)
            graph[x+d2+i][y+d2-i] = 5;

        for(int i = 1; i < x+d1; i++) {
            for(int j = 1; j <= y; j++) {
                if(graph[i][j] == 5) {break;}
                arr[0] += A[i][j];
            }
        }
        for(int i = 1; i <= x+d2; i++) {
            for(int j = N; j > y ;j--) {
                if(graph[i][j] == 5) {break;}
                arr[1] += A[i][j];
            }
        }
        for(int i = x + d1; i <= N; i++) {
            for(int j = 1; j < y-d1+d2; j++) {
                if(graph[i][j] == 5) {break;}
                arr[2] += A[i][j];
            }
        }
        for(int i = x+d2+1; i <= N; i++) {
            for(int j = N; j >= y-d1+d2 ;j--) {
                if(graph[i][j] == 5) {break;}
                arr[3] += A[i][j];
            }
        }

        arr[4] = totalNum - Arrays.stream(arr).sum();

        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < 5; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        result = Math.min(result, max - min);
    }
}
/**
 * 5개의 선거구로 나눠야 됨
 * 각 구역은 다섯 선거구 중 하나에 포함되어야 함
 * A <-> B
 * 꼭짓점 좌표를 정해
 * (x, y), d1, d2
 *
 */