package barking.part10;

/**
 * 수열 A
 * 부분 수열을 가장 길게 만들자
 */

import java.io.*;
import java.util.*;

public class 가장긴증가하는수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N];

        d[0] = 1;
        for(int i = 1; i < N; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    d[i] = Math.max(d[j] + 1, d[i]);
                }
            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
