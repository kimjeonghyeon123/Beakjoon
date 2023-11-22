package 코테공부.그리디;

import java.io.*;
import java.util.*;

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int remain = 0, count = 0;
        while(true) {
            // N이 K로 나누어 떨어질 때까지 빼기
            remain = N % K;
            count += remain;
            N -= remain;

            if(N < K) break;

            count++;
            N /= K;
        }

        // N보다 K가 클 때 나왔으므로
        // N에서 1까지 차이를 더해줌
        // ex) 3 5 -> n = 3, 1까지의 차이는 2
        count += (N-1);
        System.out.println(count);
    }
}
