package 코테공부.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // a[i] = i를 1로 만들기 위한 최소 연산 횟수
        // a[i] = min(a[i-1], a[i/2], a[i/3], a[i/5]) + 1
        int[] d = new int[X+1];

        for(int i = 2; i < X+1; i++) {
            d[i] = d[i-1] + 1;
            if(i % 2 == 0) {
                d[i] = (d[i] < d[i/2] + 1) ? d[i] : d[i/2] + 1;
            }
            if(i % 3 == 0) {
                d[i] = (d[i] < d[i/3] + 1) ? d[i] : d[i/3] + 1;
            }
            if(i % 5 == 0) {
                d[i] = (d[i] < d[i/5] + 1) ? d[i] : d[i/5] + 1;
            }
        }

        System.out.println(d[X]);
    }
}
