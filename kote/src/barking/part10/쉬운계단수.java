package barking.part10;

/**
 * 45656
 * 인접한 수가 1차이
 * 길이가 N인 총 계단 수
 * d[i][j] : i자리 자릿값 j
 *
 */

import java.io.*;
import java.util.*;

public class 쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N + 1][10];

        for(int i = 1; i < 10; i++) {
            d[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j==0) {
                    d[i][0] = d[i-1][1];
                }
                else if(j==9) {
                    d[i][9] = d[i-1][8];
                }
                else {
                    d[i][j] = d[i-1][j-1] + d[i-1][j+1];
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += d[N][i];
        }
        System.out.println(sum);
    }
}
