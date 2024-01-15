package test2;

/**
 * 산성 용액 : 1 ~ 1,000,000,000
 * 알칼리성 용액 : -1,000,000,000 ~ -1
 *
 * 0에 가까운 용액 만들기
 *
 * left      right    sum
 * -99        98
 *
 * 절대값이 누가 더 큼??
 * 99가 크니까 98보다 크고 99보다 작은 값 left++
 *
 * -2     98
 *
 * 절대값이 98이 더 크니까
 * -2가 크면
 *
 *
 */

import java.io.*;
import java.util.*;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        int x = 0, y = N-1;
        while(left < right) {
            int sum = Math.abs(arr[left] + arr[right]);
            if(sum < min) {
                min = sum;
                x = left;
                y = right;
            }

            // 합이 0 이상이면 큰 값을 감소시켜야 값이 더 작아짐
            if(sum >= 0) {right--;}
            // 합이 0 미만이면 작은 값을 증가시켜야 값이 더 커짐
            else {left++;}
        }
        System.out.println(arr[x] + " " + arr[y]);
    }
}
