package barking.part10;

/**
 * 포도주 시식 규칙
 * 1. 잔을 선택하면 다 마시고 원래 위치에 놓아야 함
 * 2. 연속으로 3잔 못 마심
 *
 * 1~n 개의 포도주를 최대한 많이 마시려고 함
 * 각 잔에 다른 양이 들어 있음
 *
 * arr 배열에 포도주 담음
 * d[i] : i번째까지 마신 포도주 최대 양
 * d[i] = max(arr[i-1] + d[i-3] + arr[i], d[i-2] + arr[i], d[i-1])
 *
 * 0 0   0
 * 0   0 0
 *   0 0
 */

import java.io.*;
import java.util.*;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d;
        if(n == 1) {
            d = new int[1];
            d[0] = arr[0];
        }
        else if(n == 2) {
            d = new int[2];
            d[0] = arr[0];
            d[1] = arr[0] + arr[1];
        }
        else {
            d = new int[n];
            d[0] = arr[0];
            d[1] = arr[0] + arr[1];
            d[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
            d[2] = Math.max(d[2], d[1]);
        }


        for(int i = 3; i < n; i++) {
            d[i] = Math.max(arr[i-1] + d[i-3], d[i-2]) + arr[i];
            d[i] = Math.max(d[i], d[i-1]);
        }

        System.out.println(d[n-1]);
    }
}
