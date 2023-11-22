package 코테공부.그리디;

import java.io.*;
import java.util.*;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //배수이기 때문에 가능
        int[] coin = {500, 100, 50, 10};
        int remain = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < coin.length; i++) {
            count += remain / coin[i];
            remain %= coin[i];
        }

        System.out.println(count);
    }
}
