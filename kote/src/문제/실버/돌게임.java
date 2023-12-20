package 문제.실버;

/**
 * 두 명이 하는 겜
 * 돌 N개
 * 1개 또는 3개 가져감
 * 마지막에 돌 가져가는 사람이 이김
 * 상근이가 먼저 시작
 */

import java.io.*;
import java.util.*;

public class 돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] d;
        if(N <= 3) {
            d = new boolean[4];
        }
        else {
            d = new boolean[N+1];
        }

        d[1] = true;
        d[2] = false;
        d[3] = true;

        for(int i = 4; i <= N; i++) {
            if(!d[i-1] || !d[i-3]) {
                d[i] = true;
            }
        }

        if(d[N]) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }
}
