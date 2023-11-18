package barking.part9;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    private static int N;
    private static int[][] graph;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] != 0) {
                    list.add(dfs(i, j) + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        Collections.sort(list);
        for(int i : list) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dfs(int x, int y) {
        graph[x][y] = 0;
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if(graph[nx][ny] == 0) {
                continue;
            }

            count += dfs(nx, ny) + 1;
        }

        return count;
    }
}
