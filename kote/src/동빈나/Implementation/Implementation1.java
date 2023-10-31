package 동빈나.Implementation;

import java.io.*;
import java.util.*;

public class Implementation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] plans = br.readLine().split(" ");

        // L, R, U, D
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        int x = 1, y = 1;

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            int nx = -1, ny = -1;
            for(int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if(nx < 1 || ny < 1 || nx > N || ny > N) continue;

            x = nx;
            y = ny;
        }

        bw.write(String.valueOf(x) + " " + String.valueOf(y));
        bw.flush();
        bw.close();
    }
}
