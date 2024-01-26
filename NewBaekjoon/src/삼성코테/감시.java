package 삼성코테;

import java.io.*;
import java.util.*;

public class 감시 {
    public static class Node {
        int x, y, dir;
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static ArrayList<Node> cctvlist = new ArrayList<>();
    public static boolean[][] cansee;
    public static int max = Integer.MIN_VALUE;
    // 북동남서
    public static boolean[] checkdirection = new boolean[4];
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

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
                    cansee[i][j] = true;
                }
                if(graph[i][j] == 6) {
                    cansee[i][j] = true;
                }
            }
        }

        dfs(0);
        System.out.println(max);
    }

    //북동남서
    public static void dfs(int depth) {
        if(depth == cctvlist.size()) {
            sum();
            return;
        }

        Node cctv = cctvlist.get(depth);
        boolean[][] cpyCansee = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            cpyCansee[i] = cansee[i].clone();
        }

        switch (cctv.dir) {
            case 1:
                for(int i = 0; i < 4; i++) {
                    check(cctv.x, cctv.y, i);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++) {
                    check(cctv.x, cctv.y, i);
                    check(cctv.x, cctv.y, i+2);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 3:
                for(int i = 0; i < 4; i++) {
                    check(cctv.x, cctv.y, i);
                    check(cctv.x, cctv.y, (i+1)%4);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    check(cctv.x, cctv.y, i);
                    check(cctv.x, cctv.y, (i+1)%4);
                    check(cctv.x, cctv.y, (i+2)%4);
                    dfs(depth+1);
                    for(int k = 0; k < N; k++) {
                        cansee[k] = cpyCansee[k].clone();
                    }
                }
                break;
            case 5:
                for(int i = 0; i < 4; i++) {
                    check(cctv.x, cctv.y, i);
                }
                dfs(depth+1);
                for(int k = 0; k < N; k++) {
                    cansee[k] = cpyCansee[k].clone();
                }
                break;
        }

    }

    public static void check(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while(graph[nx][ny] != 6 && 0 <= nx && nx < N && 0 <= ny && ny < M) {
            nx += dx[dir];
            ny += dy[dir];
            cansee[nx][ny] = true;
        }
    }

    public static void sum() {
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!cansee[i][j]) {
                    result++;
                }
            }
        }
        max = Math.max(max, result);
    }
}
/**
 * 사각 지대의 최소크기 구하기
 * 1일 때
 * 1 cctv
 * 2 cctv
 * 3 cctv
 *
 * 1 cctv 왼쪽 검사
 * 2 cctv 왼쪽 검사 오른쪽검사
 * 3 cctv 위쪽 검사 오른쪽검사
 *
 */