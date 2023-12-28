package barking.part10;

/**
 * - ps 카드
 *  1. 아이디, 얼굴
 *  2. 카드 팩으로만 구매 가능 1~N개
 *  3. 카드의 개수가 적은 팩도 가격이 비싸면 높은 등급이 있을 것이다 미신
 *  4. 카드 n개를 사기 위한 금액의 최대값
 *
 *  카드 팩의 가격 1
 *  p[i] : i 개 들어있는 팩의 가격
 *  d[1] : max(p[1])
 *  d[2] : max(p[1] + p[1], p[2])
 *  d[3] : max(p[1] + p[1] + p[1], p[1] + p[2], p[3])
 *  d[4] : max(d[3], d[2] + p[2], d[1] + p[3], p[4])
 *  d[i] : max(d[i-1] + p[1], d[i-2] + p[2], d[i-3] + p[3], ..., d[1] + p[i-1], p[i])
 */

import java.io.*;
import java.util.*;

public class 카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }

        System.out.println(d[N]);
    }
}
