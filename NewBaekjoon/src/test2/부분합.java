package test2;

/**
 * 10000이하의 자연수 N짜리 수열
 * 연속된 수들의 부분합 중 S 이상이 되는 것중 가장 짧은 것의 길이를 구하라
 *
 * d[i] d[i+1] d[i+2] ... >= S min Math.min(min, S);
 *
 */

import java.io.*;
import java.util.*;

public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= N && end <= N) {
            // 합이 S보다 크면 end - start
            if(total >= S && min > end- start) {
                min = end - start;
            }

            // 합이 작으면 end에 1더해
            if(total < S) {
                total += arr[end];
                end++;
            }
            // 합이 더 크면 start에 1더해
            else {
                total -= arr[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }
    }
}
