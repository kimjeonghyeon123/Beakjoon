package 동빈나;

import java.io.*;
import java.util.*;

public class Greedy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        while(N != 1) {
            if (N % K == 0) {
                N /= K;
                count++;
            } else {
                int a = N % K;
                N -= a;
                count += a;
            }
            int a = N % K;
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
