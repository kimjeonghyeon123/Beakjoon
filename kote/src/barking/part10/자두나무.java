package barking.part10;

/**
 * 자두가 떨어질 때까지 기다림
 * 바닥에 떨어지면 못먹음
 * 매초마다 두 나무 중 하나에서 떨어짐
 * 아래에 있으면 먹을 수 있음
 * T초동안 최대 W번만 움직이고 싶음
 * 자두가 받을 수 있는 자두의 개수
 * d[i][j] : i초일때 j번움직여서 받은 최대 개수
 * d[i][j] = max(d[i-1][j] + arr[j], d[i-1][j-1] + arr[j])
 */

import java.io.*;
import java.util.*;

public class 자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T+1];
        for(int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] d = new int[T+1][W+1];
        if(arr[0] == 1) {
            d[1][0]++;
        }
        else {
            d[1][1]++;
        }
        for(int i = 2; i <= T; i++) {
            for(int j = 0; j <= i; j++) {
                if(j > W) {break;}
                if(j % 2 + 1 == arr[i]) {
                    d[i][j] = Math.max(d[i][j], d[i-1][j]) + 1;
                    if(j != 0) {
                        d[i][j] = Math.max(d[i][j], d[i - 1][j - 1]) + 1;
                    }
                }
                else {
                    d[i][j] = Math.max(d[i][j], d[i-1][j]);
                    if(j != 0) {
                        d[i][j] = Math.max(d[i][j], d[i-1][j-1]);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(d[T]).max().getAsInt());
    }
}
