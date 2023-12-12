package barking.part10;
/**
 * 계단수:
 * 인접한 모든 자리의 차이가 1
 * 1 : 9개
 * 2 : 0일땐 안셈, 9일때 안셈
 * 3 :
 *
 * d[i][j]는 i자리 j일때 경우의 수
 * d[i][j] = d[i-1][j-1] + d[i-1][j+1]
 */

import java.io.*;
import java.util.*;

public class 쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][10];

        for(int j = 1; j < 10; j++) {
            d[1][j] = 1L;
        }

        for(int i = 2; i < N+1; i++) {
            d[i][0] = d[i-1][1];
            d[i][9] = d[i-1][8];
            for(int j = 1; j <= 8; j++) {
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % 1000000000;
            }
        }

        System.out.println(Arrays.stream(d[N]).sum()%1000000000);
    }
}
