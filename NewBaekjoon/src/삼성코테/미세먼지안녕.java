package 삼성코테;

import java.io.*;
import java.util.*;

public class 미세먼지안녕 {
    public static class Dust {
        int x, y, w;
        public Dust(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public static int R, C, T;
    public static int cleaner = -1;
    public static int[][] map;
    public static Queue<Dust> dusts;

    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        for(int time = 0; time < T; time++) {
            checkDust();
            spread();
            operate();
        }

        int res = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -1) continue;
                res += map[i][j];
            }
        }
        System.out.println(res);
    }

    public static void checkDust() {
        dusts = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -1 && map[i][j] == 0 && map[i][j] < 5) {continue;}
                dusts.offer(new Dust(i, j, map[i][j]));
            }
        }
    }

    public static void spread() {
        while(!dusts.isEmpty()) {
            Dust now = dusts.poll();

            int amountOfSpread = now.w / 5;
            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {continue;}
                if(map[nx][ny] == -1) {continue;}
                map[nx][ny] += amountOfSpread;
                cnt++;
            }

            map[now.x][now.y] -= amountOfSpread * cnt;
        }
    }

    public static void operate() {
        int top = cleaner;
        int down = cleaner+1;

        for(int i = top-1; i >= 1; i--)
            map[i][0] = map[i-1][0];
        for(int i = 0; i <= C-2; i++)
            map[0][i] = map[0][i+1];
        for(int i = 0; i <= top-1; i++)
            map[i][C-1] = map[i+1][C-1];
        for(int i = C-1; i >= 2; i--)
            map[top][i] = map[top][i-1];
        map[top][1] = 0;

        for(int i = down+1; i <= R-2; i++)
            map[i][0] = map[i+1][0];
        for(int i = 0; i <= C-2; i++)
            map[R-1][i] = map[R-1][i+1];
        for(int i = R-1; i >= down+1; i--)
            map[i][C-1] = map[i-1][C-1];
        for(int i = C-1; i >= 2; i--)
            map[down][i] = map[down][i-1];
        map[down][1] = 0;
    }
}