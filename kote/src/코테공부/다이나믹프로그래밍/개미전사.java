package 코테공부.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미전사 {

    public static int N;
    public static int[] arr;
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = arr[0];
        d[1] = (arr[0] > arr[1]) ? arr[0] : arr[1];
        for(int i = 2; i < N; i++) {
            d[i] = (d[i-1] > d[i-2]) ? d[i-1] : d[i-2] + arr[i];
        }

        System.out.println(d[N-1]);
    }
}
