package barking.part10;

import java.io.*;
import java.util.*;

/**
 * N+1일 퇴사
 *
 */
public class 퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N+2];
        if(T[N] == 1) {d[N] = 1;}
        for(int i = N-1; i >= 1; i--) {
            int next = i + T[i];
            if(next - 1 > N) {
                d[i] = d[i+1];
                continue;
            }

            d[i] = Math.max(d[next] + P[i], d[i+1]);
        }

        System.out.println(d[1]);
    }
}
