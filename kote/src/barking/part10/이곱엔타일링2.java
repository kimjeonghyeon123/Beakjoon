package barking.part10;

import java.io.*;
import java.util.*;

/**
 * 2*n 직사각형
 * 1*2, 2*1, 2*2 채우는 경우
 * d[N] = d[N-1] + 2*d[N-2]
 */
public class 이곱엔타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] d;
        if(N==1) {d = new int[3];}
        else {d = new int[N+1];}
        d[1] = 1;
        d[2] = 3;
        for(int i = 3; i <= N; i++) {
            d[i] = (d[i-1] + 2 * d[i-2]) % 10007;
        }
        System.out.println(d[N]);
    }
}
