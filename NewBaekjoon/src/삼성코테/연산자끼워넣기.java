package 삼성코테;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
    public static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static int N;
    public static int[] numbers;
    public static int[] operation = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int total) {
        if(depth == N-1) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return ;
        }

        for(int i = 0; i < 4; i++) {
            if(operation[i] == 0) {continue;}

            operation[i]--;
            if(i == 0) {
                dfs(depth+1, total + numbers[depth+1]);
            }
            else if(i == 1) {
                dfs(depth+1, total - numbers[depth+1]);
            }
            else if(i == 2) {
                dfs(depth+1, total * numbers[depth+1]);
            }
            else {
                dfs(depth+1, total / numbers[depth+1]);
            }
            operation[i]++;
        }
    }
}
/**
 * 최대 최소 구하기
 * + : 0
 * - : 1
 * * : 2
 * / : 3
 */