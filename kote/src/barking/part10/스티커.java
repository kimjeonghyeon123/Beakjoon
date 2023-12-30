package barking.part10;

/**
 * 문방구에서 스티커 2n개 구입
 * 2행 n열 배치
 * 스티커 한장을 떼면 위아래양옆 다 사용불가능
 * 점수의 합이 최대가 되게 스티커를 떼어냄
 *
 * d[i][j] : i행 j열 땠을 때 최대값
 * 대각선을 떼거나 한 칸 건너면
 *
 * [0][0] [0][1] [0][2]
 * [1][0] [1][1] [1][2]
 *
 * d[0][0] = arr[0][0]
 * d[1][0] = arr[1][0]
 * d[0][1] = arr[1][0] + arr[0][1]
 * d[1][1] = arr[0][0] + arr[1][1]
 *
 * d[0][2] = Math.max(d[1][1], d[0][0], d[1][0]) + arr[0][2]
 * d[0][j] = max3(d[1][j-1], d[0][j-2], d[1][j-2]) + arr[0][j];
 * d[1][j] = max3(d[0][j-1], d[1][j-2], d[0][j-2]) + arr[1][j];
 */

import java.io.*;
import java.util.*;

public class 스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr;
            int[][] d;
            if(n == 1) {
                arr = new int[2][2];
                d = new int[2][2];
            }
            else {
                arr = new int[2][n];
                d = new int[2][n];
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            d[0][0] = arr[0][0];
            d[1][0] = arr[1][0];
            d[0][1] = arr[1][0] + arr[0][1];
            d[1][1] = arr[0][0] + arr[1][1];

            for(int j = 2; j < n; j++) {
                d[0][j] = max3(d[1][j-1], d[0][j-2], d[1][j-2]) + arr[0][j];
                d[1][j] = max3(d[0][j-1], d[1][j-2], d[0][j-2]) + arr[1][j];
            }

            sb.append(Math.max(d[0][n-1], d[1][n-1])).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }
}
