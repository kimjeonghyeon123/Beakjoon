package barking.part10;

/**
 * d[n] = d[n-1]+d[n-2]
 */

import java.io.*;
import java.util.*;

public class 피보나치수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n+1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
