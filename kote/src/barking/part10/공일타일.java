package barking.part10;

/**
 * 타일 0 또는 1
 * 1 또는 00 타일
 * 길이가 N인 모든 2진 수열을 만들 수 없게 됨
 * n = 1 : 1
 * n = 2 : 00, 11
 * n = 3 : 001, 111, 100
 * n = 4 : 0011, 1111, 1001, 0000, 1100
 * n = 5 : 00111, 11111, 10011, 00001, 11001, 00100, 11100, 10000
 *
 * d[n] : n일 때 경우의 수
 * d[n] = d[n-1] + d[n-2]
 */

import java.io.*;
import java.util.*;

public class 공일타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d;
        if(N == 1) {
            d = new int[3];
        }
        else {
            d = new int[N+1];
        }

        d[1] = 1;
        d[2] = 2;

        for(int i = 3; i <= N; i++) {
            d[i] = (d[i-1] + d[i-2]) % 15746;
        }

        System.out.println(d[N]);
    }
}
