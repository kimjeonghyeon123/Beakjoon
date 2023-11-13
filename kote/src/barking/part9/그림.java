package barking.part9;

import java.io.*;
import java.util.*;

public class 그림 {

    static int[][] arr;
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = bfs(i, j);
                if(temp != 0) {
                    result++;
                    if(max < temp) {
                        max = temp;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n").append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {
        if(x < 0 || x >= row ||  y < 0 || y >= col) {
            return 0;
        }
        if(arr[x][y] == 0) {
            return 0;
        }
        arr[x][y] = 0;
        return 1 + bfs(x-1, y) + bfs(x+1, y) + bfs(x, y-1) + bfs(x, y+1);
    }
}
