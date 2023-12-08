package barking.part10;

/**
 * 오늘부터 N+1번째 되는 날 퇴사
 * N일 동안 최대한 많은 상담
 * 하루에 하나씩 서로 다른 사람의 상담을 잡아놓음
 * 상담을 완료하는데 걸리는 기간 Ti와 상담했을 때 받을 수있는 금액 Pi
 *
 */

import java.io.*;
import java.util.*;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N+2];
        d[N+1] = 0;
        if(T[N] == 1) {
            d[N] = P[N];
        }

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
