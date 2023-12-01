package 코테공부.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 금광 {

    public static int N, M;
    public static int[][] graph;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1 3 3 2
         * 2 1 4 1
         * 0 6 4 7
         *
         * dp[i][j] : i행 j열까지의 최대 값
         * dp[i][j] = max(d[i-1][j-1], d[i][j-1], d[i+1][j-1]) + graph[i][j];
         */

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            dp = new int[N][M];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(maxGold());
        }
    }

    //dp[i][j] = max(d[i-1][j-1], d[i][j-1], d[i+1][j-1]) + graph[i][j];
    public static int maxGold() {

        for(int i = 0; i < N; i++) {
            dp[i][0] = graph[i][0];
        }

        for(int j = 1; j < M; j++) {
            for(int i = 0; i < N; i++) {
                if(i-1 < 0 && i + 1 < N) {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j-1]) + graph[i][j];
                }
                else if (i-1 >= 0 && i + 1 >= N) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]) + graph[i][j];
                }
                else {
                    dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1]) + graph[i][j];
                }
            }
        }

        int max = dp[0][M-1];
        for(int i = 0; i < N; i++) {
            if(max < dp[i][M-1]) {
                max = dp[i][M-1];
            }
        }
        return max;
    }

    public static int max(int a, int b, int c) {
        if(a >= b) {
            if(a >= c) {return a;}
            else {return c;}
        }
        else {
            if(b >= c) {return b;}
            else {return c;}
        }
    }
}

/**
 * a b c
 * a > b
 * a c
 */
