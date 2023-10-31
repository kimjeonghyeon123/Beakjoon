package 동빈나.Implementation;

import java.io.*;
import java.util.*;

public class Implementation3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

        int nx, ny;
        String[] arr = br.readLine().split("");
        int x = arr[1].charAt(0) - '1' + 1;
        int y = arr[0].charAt(0) - 'a' + 1;

        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
