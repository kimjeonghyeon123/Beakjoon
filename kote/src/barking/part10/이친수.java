package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 이친수
 * 1) 0과 1로 이루어진 수
 * 2) 1로 시작
 * 3) 1이 두번 연속으로 나타나지 않음
 */
public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] d;
        if(N==1) {d = new long[3];}
        else {d = new long[N+1];}
        d[1] = 1;
        d[2] = 1;
        for(int i = 3; i <= N; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[N]);
    }
}
