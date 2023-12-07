package barking.part10;

import java.io.*;

public class 계단오르기 {

    public static int[] d;
    public static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        d = new int[N+1];
        stairs = new int[N+1];
        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(N >= 1) {
            d[1] = stairs[1];
        }
        if(N >= 2) {
            d[2] = stairs[1] + stairs[2];
        }
        if(N >= 3) {
            d[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        }
        for (int i = 4; i <= N; i++) {
            d[i] = Math.max(d[i - 2], d[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(d[N]);
    }
}
