package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 배열 : n개
 * 연속된 수의 합이 제일 큰 거
 * d[i] : i까지의 최대합
 * d[i] = max(d[i], d[
 */
public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            d[i] =  Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n; i++) {
            d[i] = Math.max(d[i-1] + d[i], d[i]);
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
