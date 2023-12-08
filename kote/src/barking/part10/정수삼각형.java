package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 수의 합이 최대가 되는 경로 구하기
 * 바로 밑, 오른쪽 밑 만 가능
 * d[i][j] : i, j 위치까지의 최대값
 * d[i][j] = max(d[i+1][j], d[i+1][j+1]) + arr[i][j]
 */
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];
        int[][] d = new int[N][];
        for(int i = 0; i < N; i++) {
            arr[i] = new int[i+1];
            d[i] = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            d[N-1][i] = arr[N-1][i];
        }

        for(int i = N-2; i >= 0; i--) {
            for(int j = 0; j < i+1; j++) {
                d[i][j] = Math.max(d[i+1][j], d[i+1][j+1]) + arr[i][j];
            }
        }

        System.out.println(d[0][0]);
    }
}
