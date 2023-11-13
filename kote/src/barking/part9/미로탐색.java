package barking.part9;

import java.io.*;

public class 미로탐색 {

    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int row, col;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        row = Integer.parseInt(strs[0]);
        col = Integer.parseInt(strs[1]);

        for(int i = 0; i < row; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
    }

    static int bfs() {

        return 1;
    }
}
