package 문제.브론즈;

import java.io.*;
import java.util.*;

public class 벌집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        int count = 1;
        int range = 2;

        if(N==1) {
            System.out.println(1);
        }
        else {
            while(range <= N) {
                range = range + (6*count); // 다음 범위의 최솟값
                count++;
            }
            System.out.println(count);
        }
    }
}
