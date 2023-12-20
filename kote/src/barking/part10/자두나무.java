package barking.part10;

/**
 * 자두 나무 아래에 있어야 됨
 * d[i][j] : i초, k번 움직여서 (K % 2 + 1)나무에 있을 때 가장 많이 얻을 수 있는 자두
 *
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

        d[1][0] = (arr[0] == 1) ? 1 : 0;
        d[1][1] = (arr[0] == 2) ? 1 : 0;
    }
}
