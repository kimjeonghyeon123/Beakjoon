package test2;

/**
 * 0번 스위치 키고
 * 나올 때까지 dfs 해볼까?
 * 이전에 누른 스위치 빼고 누른 경우
 */

import java.io.*;
import java.util.*;

public class 전구와스위치 {

    public static int min = Integer.MAX_VALUE;
    public static int N;
    public static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new int[N];
        String s1 = br.readLine();
        for(int i = 0; i < N; i++) {
            a[i] = s1.charAt(i) - '0';
        }
        b = new int[N];
        String s2 = br.readLine();
        for(int i = 0; i < N; i++) {
            b[i] = s2.charAt(i) - '0';
        }
    }

    public static void dfs(int past, int cnt) {

    }
}
