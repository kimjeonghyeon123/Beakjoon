package barking.part9;

import java.io.*;
import java.util.*;

public class 영역구하기 {

    private static int M;
    private static int N;
    private static int K;
    private static int[][] graph;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        int x = 0, y = 0, nx = 0, ny = 0;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());

            for(int j = y; j < ny; j++) {
                for(int k = x; k < nx; k++) {
                    graph[j][k] = -1;
                }
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int t = dfs(i, j);
                if(t != 0) {
                    list.add(t);
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        Collections.sort(list);
        for(int i : list) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dfs(int x, int y) {
        if(x < 0 || x >= M || y < 0 || y >= N) {
            return 0;
        }
        if(graph[x][y] == -1) {
            return 0;
        }
        graph[x][y] = -1;

        return dfs(x+1, y) + dfs(x-1, y) + dfs(x, y+1) + dfs(x, y-1) + 1;
    }
}
