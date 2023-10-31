package 동빈나.DFSBFS;

import java.io.*;
import java.util.*;

public class 최대공약수계싼 {

    public static int GCD(int A, int B) {
        if (A % B != 0)
            return GCD(B, A % B);
        else
            return B;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(GCD(192, 162)));

        bw.flush();
        bw.close();
    }
}
