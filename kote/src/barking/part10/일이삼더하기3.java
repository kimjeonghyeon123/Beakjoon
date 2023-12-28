package barking.part10;

/**
 * 1 = 1
 * 2 = 1+1, 2
 * 3 = 1+1+1, 2+1, 1+2, 3
 * 4 = 1+1+1+1, 2+1+1, 1+2+1, 3+1, 1+1+2, 2+2, 1+3
 * 5=  1+1+1+1+1, 2+1+1+1, 1+2+1+1, 3+1+1, 1+1+2+1, 2+2+1, 1+3+1, 1+1+1+2, 2+1+2
 *
 * d[i] = d[i-1] + d[i-2] + d[i-3]
 */

import java.io.*;
import java.util.*;

public class 일이삼더하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        long[] d;
        if(max < 3) {
            d = new long[4];
        }
        else {
            d = new long[max+1];
        }

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int i = 4; i <= max; i++) {
            d[i] = (d[i-1] + d[i-2] + d[i-3]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            sb.append(d[arr[i]]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
