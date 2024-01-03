package barking.part10;

/**
 * 오름차순을 이루는 수
 * 인접한 수가 같아도 오름차순
 *
 * 길이가 N인 오르막수 개수
 * 시작이 0이어도 됨
 *
 * d[1][0] d[1][1] ... d[1][9]
 * d[2][0] -> d[1][0], d[2][1] d[1][1] d[1][0]
 */

import java.io.*;
import java.util.*;

public class 오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] d = new int[N+1][10];

        Arrays.fill(d[1], 1);

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    d[i][j] += d[i-1][k];
                    d[i][j] %= 10007;
                }
            }
        }

        System.out.println(Arrays.stream(d[N]).sum() % 10007);
    }
}
