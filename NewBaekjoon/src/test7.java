/**
 * 피자 A, B
 * 여러 개의 조각으로 나뉘어져 있음
 *
 */

import java.io.*;
import java.util.*;

public class test7 {
    public static final int INF = Integer.MAX_VALUE;
    public static int m, n, cnt;
    public static int result = 0;
    public static int[] pizzaA;
    public static int[] pizzaB;
    public static boolean[] visitedA;
    public static boolean[] visitedB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizzaA = new int[m];
        visitedA = new boolean[m];
        for(int i = 0; i < m; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
        }

        pizzaB = new int[n];
        visitedB = new boolean[n];
        for(int i = 0; i < n; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(i, j,0);
            }
        }
    }

    public static void dfs(int startA, int startB, int sum) {
        if(sum == cnt) {
            result++;
            return;
        }
        // A 피자에서 피자 고르기
        if(startA == INF)
    }
}
