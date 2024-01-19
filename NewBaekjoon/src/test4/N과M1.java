package test4;

/**
 * N과 M이 주어졌을 때
 * 길이가 M인 수열을 모두 구하는 프로그램
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *
 */

import java.io.*;
import java.util.*;

public class N과M1 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, 1, String.valueOf(i) + " ");
            visited[i] = false;
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int x, int cnt, String s) {
        arr[cnt-1] = x;
        if(cnt == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1, s + String.valueOf(i) + " ");
                visited[i] = false;
            }
        }
    }
}
