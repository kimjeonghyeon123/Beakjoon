package barking.part10;

/**
 * 자두 나무 아래에 있어야 됨
 * d[i][j] : i초, k번 움직여서 (K % 2 + 1)나무에 있을 때 가장 많이 얻을 수 있는 자두
 * j가 짝수면 1번 나무에 있음
 * j가 홀수면 2번 나무에 있음
 * d[0][0] : 0초 일 때, 0번 움직였을 때 자두 개수 : if(arr[0] == j%2+1) 1
 * d[1][0] : 1초 일 때, 0번 움직였을 때 자두 개수 : if(arr[1] == j%2+1) d[0][0] + 1
 * d[1][1] : 1초 일 때, 1번 움직였을 때 자두 개수 : if(arr[1] == j%2+1) max(d[0][0], d[0][1]) + 1
 * d[2][0] : 2초 일 때, 0번 움직였을 때 자두 개수 : if(arr[2] == j%2+1) d[1][0] + 1
 * d[2][1] : 2초 일 때, 0번 움직였을 때 자두 개수 : if(arr[2] == j%2+1) max(d[1][0], d[1][1]) + 1
 * d[2][2] : 2초 일 때, 0번 움직였을 때 자두 개수 : if(arr[2] == j%2+1) max(d[1][1], d[1][2]) + 1
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

        d[0][0] = (arr[0] == 1) ? 1 : 0;

        for(int i = 1; i <= T; i++) {
            int move = i;
            if(move > W) {
                move = W;
            }
            for(int j = 0; j <= move; j++) {
                if(arr[i] == j % 2 + 1) {
                    if(j==0) {
                        d[i][j] = d[i-1][j] + 1;
                    }
                    else {
                        d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + 1;
                    }
                }
                else {
                    if(j==0) {
                        d[i][j] = d[i-1][j];
                    }
                    else {
                        d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(d[T]).max().getAsInt());
    }
}
