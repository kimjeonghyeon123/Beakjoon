package test4;

/**
 * N X N 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 *
 * N이 주어졌을 때 N개의 퀸을 놓는 방법의 수를 구해라
 *
 *
 * 퀸의 이동 방법?
 * 대각선 이동
 * 앞뒤로 이동
 *
 *
 *
 */

import java.io.*;
import java.util.*;

public class NQueen {

    public static int[] arr;
    public static int N;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(cnt);
    }

    public static void nQueen(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        // arr[i] = i열  arr[i]행
        // depth는 열
        // 이전 열까지 검사하는 거야
        for(int i = 0; i < N; i++) {
            arr[depth] = i;
            if(Possibility(depth)) {
                nQueen(depth+1);
            }
        }
    }

    public static boolean Possibility(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
