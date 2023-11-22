package 코테공부.구현;

import java.io.*;
import java.util.*;

public class 시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int count = 0;
        for(int h = 0; h <= N; h++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    if(check(h, m, s)) count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check(int h, int m, int s) {
        if(h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }
}
