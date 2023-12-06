package 코테공부.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(maxGold(n, m, arr)).append("\n");
        }

        System.out.println(sb.toString());
    }

    //d[i][j] : j열 i행일 때 최대인 수
    //d[i][j] = max(d[i-1][j-1], d[i][j-1], d[i+1][j-1]) + arr[i][j]
    public static int maxGold(int n, int m, int[][] arr) {
        int[][] d = new int[n][m];
        for(int i = 0; i < n; i++) {
            d[i][0] = arr[i][0];
        }

        for(int j = 1; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(i == 0) {
                    d[i][j] = Math.max(d[i][j-1], d[i+1][j-1]) + arr[i][j];
                }
                else if(i == n-1) {
                    d[i][j] = Math.max(d[i-1][j-1], d[i][j-1]) + arr[i][j];
                }
                else {
                    d[i][j] = maxNum(d[i-1][j-1], d[i][j-1], d[i+1][j-1]) + arr[i][j];
                }
            }
        }

        int max = d[0][m-1];
        for(int i = 1; i < n; i++) {
            if(max < d[i][m-1]) {
                max = d[i][m-1];
            }
        }

        return max;
    }

    public static int maxNum(int a, int b, int c) {
        if(a >= b) {
            if(a >= c) return a;
            else return c;
        }
        else {
            if(b >= c) return b;
            else return c;
        }
    }
}

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */