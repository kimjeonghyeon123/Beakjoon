package barking.part10;

/**
 * 삼각형이 나선 모형으로 놓여 있음
 * 첫 정삼각형 : 변의 길이 1
 *
 */

import java.io.*;
import java.util.*;

public class 파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        if(max <= 2) {max = 3;}
        long[] d = new long[max+1];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for(int i = 4; i <= max; i++) {
            d[i] = d[i-2] + d[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            sb.append(d[arr[i]]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
