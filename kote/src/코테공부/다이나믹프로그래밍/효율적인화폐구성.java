package 코테공부.다이나믹프로그래밍;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] d = new int[M+1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = arr[i]; j <= M; j++) {
                if(d[j-arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j-arr[i]] + 1);
                }
            }
        }

        if(d[M] == 10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(d[M]);
        }
    }
}
