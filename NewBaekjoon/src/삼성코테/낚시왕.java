package 삼성코테;

import java.io.*;
import java.util.*;

public class 낚시왕 {
    public static class Shark {
        int r,c,s,d,z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    public static int R, C, M;
    public static Shark[][] map;
    public static int answer = 0;
    //상 -> 좌 -> 하 -> 우
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(d == 1) {
                d = 0;
            }
            else if(d == 4) {
                d = 1;
            }

            map[r-1][c-1] = new Shark(r-1,c-1,s,d,z);
        }

        for(int col = 0; col < C; col++) {
            //낚시왕 이동
            for(int row = 0; row < R; row++) {
                if(map[row][col] != null) {
                    answer += map[row][col].z;
                    map[row][col] = null;
                    break;
                }
            }

            // 상어 이동
            Queue<Shark> queue = new LinkedList<>();
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(map[i][j] != null) {
                        queue.offer(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                    }
                }
            }

            map = new Shark[R][C];

            while(!queue.isEmpty()) {
                Shark sm = queue.poll();

                int speed = sm.s;

                //상 하
                if(sm.d == 0 || sm.d == 2)
                    speed %= (R - 1) * 2;
                //좌 우
                else if(sm.d == 1 || sm.d == 3) {
                    speed %= (C - 1) * 2;
                }

                for(int s = 0; s < speed; s++) {
                    int newR = sm.r + dx[sm.d];
                    int newC = sm.c + dy[sm.d];

                    if(newR < 0 || newR >= R || newC < 0 || newC >= C) {
                        sm.r -= dx[sm.d];
                        sm.c -= dy[sm.d];
                        sm.d = (sm.d + 2) % 4;
                        continue;
                    }

                    sm.r = newR;
                    sm.c = newC;
                }
                if(map[sm.r][sm.c] == null || map[sm.r][sm.c].z < sm.z) {
                    map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
                }
            }
        }
        System.out.println(answer);
    }
}
/**
 * R * C
 * 1. 낚시왕 오른쪽으로 한 칸 이동
 * 2. 낚시왕이 있는 열의 상어 중 땅과 가장 가까운 상어 잡기
 * 3. 상어 이동
 */