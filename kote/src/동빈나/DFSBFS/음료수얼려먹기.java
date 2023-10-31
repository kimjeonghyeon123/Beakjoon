package 동빈나.DFSBFS;

import java.io.*;
import java.util.*;

public class 음료수얼려먹기 {

    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                if(arr[j] == "0"){
                    visited[i][j+1] = false;
                }
                else {
                    visited[i][j+1] = true;
                }

            }
        }

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        bw.flush();
        bw.close();
    }
}
