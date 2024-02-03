package 코테;

import java.io.*;
import java.util.*;

public class 봄버맨 {
    public static class Bomb {
        int x, y;
        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int R, C, N;
    public static Bomb[][] graph;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new Bomb[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                if(str.charAt(j) == 'O') {
                    graph[i][j] = new Bomb(i, j);
                }
            }
        }

        Queue<Bomb> q = new LinkedList<>();
        for(int time = 0; time < N; time++) {
            // 빈 곳에 설치하기
            if(time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (graph[i][j] == null) {
                            graph[i][j] = new Bomb(i, j);
                        }
                        else {
                            q.offer(new Bomb(i, j));
                        }
                    }
                }
            }
            // 폭탄 터뜨리기
            else {
                while(!q.isEmpty()) {
                    Bomb bomb = q.poll();

                    for(int i = 0 ; i < 4; i++) {
                        int nx = bomb.x + dx[i];
                        int ny = bomb.y + dy[i];

                        if(nx < 0 || nx >= R || ny < 0 || ny >= C) {continue;}
                        graph[nx][ny] = null;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] == null) {sb.append(".");}
                else {sb.append("O");}
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
