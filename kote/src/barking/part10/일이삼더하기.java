package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 정수 n = 1, 2, 3의 합으로 나타내는 방법의 수
 * 1 인 경우의 수
 */
public class 일이삼더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int N = Arrays.stream(arr).max().getAsInt();
        int[] d = new int[N+1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i <= N; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        for(int i = 0; i < T; i++) {
            System.out.println(d[arr[i]]);
        }
    }
}
