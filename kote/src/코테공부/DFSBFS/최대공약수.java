package 코테공부.DFSBFS;

import java.io.*;
import java.util.*;

public class 최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(GCD(A, B));
    }

    private static int GCD(int A, int B) {
        if(A % B == 0) {
            return B;
        }

        return GCD(B, A % B);
    }
}
