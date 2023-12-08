package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 수열 A
 * 증가하는 부분 수열 중 가장 합이 큰 것을 구하라
 */
public class 가장큰증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N];
        d[0] = arr[0];
        for(int i = 1; i < N; i++) {
            d[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    d[i] = Math.max(d[j] + arr[i], d[i]);
                }
            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
