package 삼성코테;

import java.io.*;
import java.util.*;

public class 감시 {
    public static class Node {
        int x, y, cctvtype;
        public Node(int x, int y, int cctvtype) {
            this.x = x;
            this.y = y;
            this.cctvtype = cctvtype;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static boolean[][] cansee;
    public static ArrayList<Node> cctvlist = new ArrayList<>();
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        cansee = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] != 0 && graph[i][j] != 6) {
                    cctvlist.add(new Node(i, j, graph[i][j]));
                }
                else if(graph[i][j] == 6) {
                    cansee[i][j] = true;
                }
            }
        }

        dfs(0);

        System.out.println(min);
    }

    public static void dfs(int depth) {
        if(depth == cctvlist.size()) {
            findsagak();
            return;
        }

        Node cctv = cctvlist.get(depth);
        int x = cctv.x;
        int y = cctv.y;
        int cctvtype = cctv.cctvtype;

        boolean[][] cpyCansee = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            cpyCansee[i] = cansee[i].clone();
        }

        switch (cctvtype) {
            case 1:
                for(int i = 0; i < 4; i++) {
                    watchcctv(x, y, i);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++) {
                    watchcctv(x, y, i);
                    watchcctv(x, y, i+2);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 3:
                for(int i = 0; i < 4; i++) {
                    watchcctv(x, y, i);
                    watchcctv(x, y, (i+1)%4);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    watchcctv(x, y, i);
                    watchcctv(x, y, (i+1)%4);
                    watchcctv(x, y, (i+2)%4);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 5:
                for(int i = 0; i < 4; i++) {
                    watchcctv(x, y, i);
                }
                dfs(depth+1);
                for(int k = 0; k < N; k++) {
                    cansee[k] = cpyCansee[k].clone();
                }
                break;
        }
    }

    public static void watchcctv(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while(0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] != 6) {
            cansee[nx][ny] = true;
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    public static void findsagak() {
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!cansee[i][j]) {
                    result++;
                }
            }
        }
        min = Math.min(min, result);
    }
}
