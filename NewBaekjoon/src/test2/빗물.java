package test2;

/**
 * 비가 오면 블록 사이에 빗물이 고임
 * 고이는 빗물의 총량
 *
 *       ㅁ   ㅁ  ㅁ
 * ㅁ    ㅁ ㅁㅁㅁ
 * ㅁ ㅁ ㅁ ㅁㅁㅁ
 *
 * 자기보다 작거나 같은 것에 맞춰
 * d[0] - d[2] = 2;
 *
 */

import java.io.*;
import java.util.*;

public class 빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] d = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 1; i < W-1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(d[j], left);
            }
            for(int j = i+1; j < W; j++) {
                right = Math.max(d[j], right);
            }

            if(d[i] < left && d[i] < right) {
                result += Math.min(left, right) - d[i];
            }
        }
        System.out.println(result);
    }
}
