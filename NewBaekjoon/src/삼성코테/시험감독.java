package 삼성코테;

/**
 * N개 시험장
 * i번 시험장 : Ai명
 * 총감독관 부감독과
 * 총감독관 : B명
 * 부감독관 : C명
 * 시험장 하나에 총감독과 1명, 부감독관 여러명
 * 감독관 수의 최솟값
 *
 */

import java.io.*;
import java.util.*;

public class 시험감독 {
    public static int N;
    public static int[] people;
    public static int B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long total = 0;
        for(int i = 0; i < N; i++) {
            int rest = people[i] - B;
            total++;

            // 남은 인원이 없으면 넘어감
            if(rest <= 0) {continue;}

            // 남은 사람이
            if(rest % C == 0) {total += (rest / C);}
            else {total += (rest / C) + 1;}
        }
        System.out.println(total);
    }
}
