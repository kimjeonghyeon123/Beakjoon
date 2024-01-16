package test2;

/**
 * 1~N 층 엘리베이터
 * K 자리의 수가 보임
 * 7개 표시등 중의 일부에 불이 들어오면서 표현됨
 *
 * 최소 1개에서 촤대 P개까지 반전
 * 반전 : 켜진 부분은 끄고 꺼진 부분은 키고
 * 반전 이후에 올바른 숫자가 보이면 1~N으로 바꿈
 *
 * X층에 멈춰있을 때 호석이가 반전시킬 LED를 고를 수 있는 경우의 수를 계산해보자?
 */

import java.io.*;
import java.util.*;

public class 빌런호석 {
    public static int[][] display = {
            {1,1,1,0,1,1,1},
            {0,0,1,0,0,1,0},
            {1,0,1,1,1,0,1},
            {1,0,1,1,0,1,1},
            {0,1,1,1,0,1,0},
            {1,1,0,1,1,1,1},
            {1,0,1,0,0,1,0},
            {1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1}
    };
    public static int N, K, P, X;
    public static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] x_digit = num_to_digit(X);
        check(0, x_digit);
        System.out.println(count);
    }

    public static void check(int num, int[] x_digit) {
        for(int i  = 1; i <= N; i++) {
            if(i == X) continue;
            if(can_reverse(i, x_digit)) count++;
        }
    }

    public static boolean can_reverse(int target, int[] x_digit) {
        int[] target_digit = num_to_digit(target);

        int diff_count = 0;
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < 7; j++) {
                if(display[x_digit[i]][j] != display[target_digit[i]][j]) {
                    diff_count++;
                    if(diff_count > P) return false;
                }
            }
        }
        return true;
    }

    public static int[] num_to_digit(int x) {
        int[] result = new int[K];
        for(int i = K-1; i >= 0; i--) {
            result[i] = X % 10;
            X /= 10;
        }
        return result;
    }
}
