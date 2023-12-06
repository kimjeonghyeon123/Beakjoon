package 코테공부.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

/**
 * 가장 긴 증가하는 부분 수열
 * LIS(Longest Increasing Subsequence)
 * D[i] : array[i]를 마지막 원소로 가지는 부분 수열의 길이
 * 점화식
 * 모든 0<=j<i에 대하여, D[i] = max(D[i], D[j] + 1) if array[j] < array[i]
 */


/**
 * 병사 n명
 * 각 병사는 전투력 보유
 * 전투력 높은 병사가 앞에 오도록 내림차순으로 배치
 * 특정한 위치에 있는 병사를 열외시키는 방법 이용
 * 남아있는 병사의 수 최대
 */
public class 병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //d[i] : arr[i]를 마지막 원소로 하는 배열의 길이
        // 0<=j<i, d[i] = max(d[i], d[j]+1) if arr[j] > arr[i]

        int[] d = new int[N];
        d[0] = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
        }

        System.out.println(N - Arrays.stream(d).max().getAsInt());


    }
}
