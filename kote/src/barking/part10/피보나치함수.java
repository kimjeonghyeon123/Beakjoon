package barking.part10;

import java.io.*;
import java.util.*;

public class 피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        if(max == 0) {max = 1;}
        int[][] d = new int[max+1][2];
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;
        for(int i = 2; i <= max; i++) {
            for(int j = 0; j < 2; j++) {
                d[i][j] = d[i - 1][j] + d[i - 2][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(d[arr[i]][0]).append(" ").append(d[arr[i]][1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
