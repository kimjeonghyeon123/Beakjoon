package barking.part9;

import java.io.*;
import java.util.*;

public class 유기농배추 {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int x, y;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            for(int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st2.nextToken());
                y = Integer.parseInt(st2.nextToken());
                graph[x][y] = 1;
            }

            int result = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(dfs(j, k)) {
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        if(graph[x][y] == 0) {
            return false;
        }

        graph[x][y] = 0;
        dfs(x+1, y);
        dfs(x-1,y);
        dfs(x,y-1);
        dfs(x, y+1);

        return true;
    }
}
