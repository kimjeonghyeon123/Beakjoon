package 동빈나;

import java.io.*;
import java.util.*;

public class Greedy3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        long result = S.charAt(0) - '0';
        for(int i = 1; i < S.length(); i++) {
            int num = S.charAt(i) - '0';
            if(num <= 1 || result <= 1) {
                result += num;
            }
            else {
                result *= num;
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
