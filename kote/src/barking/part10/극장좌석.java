package barking.part10;

/**
 * 극장 좌석
 * - 한 줄 1~N
 * - i 좌석이면 i-1, i+1 좌석도 가능
 *
 * VIP
 * - i 좌석이면 i에만 앉아야 함
 *
 * VIP회원들의 좌석 번호가 주어졌을 때 경우의 수를 구해라
 *
 * 1 2 3 4 5 6 7 8 9
 * 1 2 3 4 5
 * 1 2 3 5 4
 * 1 2 4 3 5
 * 1 3 2 4 5
 * 1 3 2 5 4
 * 2 1 3 4 5
 * 2 1 3 5 4
 * 2 1 4 3 5
 *
 *
 * d[1] : 1칸 일 때 경우의 수 : 1
 * d[2] : 2칸 일 때 경우의 수 : 2
 * d[3] : 3칸 일 때 경우의 수 : 3
 * d[4] : 4칸 일 때 경우의 수 : 5
 * d[5] : 5칸 일 때 경우의 수 : 8
 *
 * 몇 칸으로 나눠지는 지 구한 후
 * 몇 개 씩 나눠지는 지 구해
 *
 * 1 2 3
 *
 */

import java.io.*;
import java.util.*;

public class 극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N+1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= N; i++) {
            d[i] = d[i-1] + d[i-2];
        }


        int M = Integer.parseInt(br.readLine());
        int before = 0;
        int result = 1;
        if(M==0) {
            result *= d[N];
        }
        for(int i = 0; i < M; i++) {
            int after = Integer.parseInt(br.readLine());
            result *= d[after - before - 1];
            before = after;
            if (i == M - 1) {
                result *= d[N - before];
            }
        }

        System.out.println(result);
    }
}
