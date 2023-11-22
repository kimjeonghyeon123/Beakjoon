package 코테공부.그리디;

import java.io.*;
import java.util.*;

public class 곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int result = S.charAt(0) - '0';
        int num = 0;
        for(int i = 1; i < S.length(); i++) {
            num = S.charAt(i) - '0';

            if(result <= 1 || num <= 1) {
                result += num;
                continue;
            }

            result *= num;
        }

        System.out.println(result);
    }
}
