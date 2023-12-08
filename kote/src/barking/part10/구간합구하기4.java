package barking.part10;

import java.io.*;
import java.util.*;

/**
 * N개의 수 : i부터 j까지 합
 * d[N] : N까지의 합
 * d[end] = (d[end] - d[start-1])
 */
public class 구간합구하기4 {

    public static int[] arr;
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        d = new int[N];

        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            d[i] = sum;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0) {
                sb.append(d[end]).append("\n");
            }
            else {
                sb.append(d[end] - d[start-1]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
