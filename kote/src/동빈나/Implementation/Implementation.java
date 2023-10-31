package 동빈나.Implementation;

import java.io.*;

public class Implementation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 동, 북, 서, 남
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int x = 2, y = 2;

        int nx, ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = x + dy[i];
        }

        bw.flush();
        bw.close();
    }
}
