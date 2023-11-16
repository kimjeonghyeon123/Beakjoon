package barking.part9;

import java.io.*;
import java.util.*;

class HMN {
    private int h;
    private int m;
    private int n;

    public HMN(int h, int m, int n) {
        this.h = h;
        this.m = m;
        this.n = n;
    }
    public int getH() {return h;}
    public int getM() {return m;}
    public int getN() {return n;}
}

public class 토마토2 {

    private static int M, N, H;
    private static int[][][] graph;
    private static int[] dh = {-1, 1, 0, 0, 0, 0};
    private static int[] dm = {0, 0, -1, 1, 0, 0};
    private static int[] dn = {0, 0, 0, 0, -1, 1};
    private static Queue<HMN> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][M][N];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                String[] str = br.readLine().split(" ");
                for(int k = 0; k < N; k++) {
                    graph[i][j][k] = Integer.parseInt(str[k]);
                    if(Integer.parseInt(str[k]) == 1) {
                        q.offer(new HMN(i, j, k));
                    }
                }
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        while(!q.isEmpty()) {
            HMN node = q.poll();
            int old_h = node.getH();
            int old_m = node.getM();
            int old_n = node.getN();

            for(int i = 0; i < 6; i++) {
                int new_h = old_h + dh[i];
                int new_m = old_m + dm[i];
                int new_n = old_n + dn[i];

                if(new_h < 0 || new_h >= H || new_m < 0 || new_m >= M || new_n < 0 || new_n >= N) {
                    continue;
                }

                if(graph[new_h][new_m][new_n] == -1) {continue;}
                if(graph[new_h][new_m][new_n] != 0 && graph[old_h][old_m][old_n] + 1 >= graph[new_h][new_m][new_n]) {continue;}

                graph[new_h][new_m][new_n] = graph[old_h][old_m][old_n] + 1;
                q.offer(new HMN(new_h, new_m, new_n));
            }
        }

        int max = 0;
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(graph[i][j][k] == 0) {
                        return -1;
                    }
                    if(max < graph[i][j][k]) {
                        max = graph[i][j][k];
                    }
                }
            }
        }
        return max - 1;
    }
}
