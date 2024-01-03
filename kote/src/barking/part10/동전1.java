package barking.part10;

/**
 * n가지 동전
 * 동전을 적당히 사용해 k원
 * 경우의 수 구하기
 *
 * a * coins[0] + b * coins[1] + ... + c * coins[n-1] = k
 *
 * d[n] : n원을 만드는 경우의 수;
 * d[i] = d[i-coin[0]] + d[i-coin[1]] + ... + d[i-coin[n-1]]
 *
 */

import java.io.*;
import java.util.*;

public class 동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] d = new int[k+1];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        d[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                if(j >= coin[i]) {
                    d[j] += d[j-coin[i]];
                }
            }
        }

        System.out.println(d[k]);
    }
}
