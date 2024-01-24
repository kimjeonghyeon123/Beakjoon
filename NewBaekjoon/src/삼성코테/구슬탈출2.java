package 삼성코테;

/**
 * N : 보드의 세로 크기
 * M : 보드의 가로 크기
 * 빨간 구슬 1개, 파란 구슬 1개
 * 보드를 기울이기
 * 빨간 구슬이 빠지면 승리, 파란 구슬이 빠지면 패배
 * 동시에 빠져도 실패
 * 같은 칸에 있을 수 없음
 */

import java.io.*;
import java.util.*;

public class 구슬탈출2 {
    public static int N, M;
    public static int[][] map;
    public static boolean[][][][] checked;
    public static int min = Integer.MAX_VALUE;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checked = new boolean[N][M][N][M];

        int rx = 0, ry = 0;
        int bx = 0, by = 0;
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                // R : 47, B: 31, O : 44, #: 0, . : 11
                int num = line[j].charAt(0)-'0'+13;
                map[i][j] = num;
                if(num == 47) {
                    rx =i; ry=j;
                }
                else if(num == 31) {
                    bx= i; by=j;
                }
            }
        }

        bfs(rx, ry, bx, by, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void bfs(int rx, int ry, int bx, int by, int cnt) {
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{rx, ry, bx, by, cnt});
        checked[rx][ry][bx][by] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int pCnt = pos[4];

            if(pCnt >= 10) {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nRx = pos[0];
                int nRy = pos[1];
                int nBx = pos[2];
                int nBy = pos[3];

                // 빨간 구슬 굴리기
                // 벽이 나올때까지 굴려
                while(map[nRx+dx[i]][nRy+dy[i]] != 0) {
                    nRx += dx[i];
                    nRy += dy[i];
                    // 구멍 만나면 멈춰
                    if(map[nRx][nRy] == 44) break;
                }

                // 파란 구슬 굴리기
                // 벽이 나올때까지 굴려
                while(map[nBx+dx[i]][nBy+dy[i]] != 0) {
                    nBx += dx[i];
                    nBy += dy[i];
                    // 구멍 만나면 멈춰
                    if(map[nBx][nBy] == 44) break;
                }

                // 파란 구슬이 구멍에 들어갔을 때
                if(map[nBx][nBy] == 44) continue;

                // 빨간 구슬이 구멍에 들어갔을 때
                if(map[nRx][nRy] == 44) {
                    min = Math.min(min, pCnt+1);
                    return;
                }

                // 빨간 파랑 서로 만났을 때
                if(nRx == nBx && nRy == nBy) {
                    //빨간 구슬이 이동한 거리, 파란 구슬이 이동한 거리
                    int red_move = Math.abs(nRx-pos[0]) + Math.abs(nRy-pos[1]);
                    int blue_move = Math.abs(nBx-pos[2]) + Math.abs(nBy-pos[3]);

                    // 파란 공이 더 빨리 도착한 경우
                    if(red_move > blue_move) {
                        nRx -= dx[i];
                        nRy -= dy[i];
                    }else { // 빨간 공이 더 빨리 도착한 경우
                        nBx -= dx[i];
                        nBy -= dy[i];
                    }
                }

                if(!checked[nRx][nRy][nBx][nBy]) {
                    checked[nRx][nRy][nBx][nBy] = true;
                    q.offer(new int[]{nRx, nRy, nBx, nBy, pCnt+1});
                }
            }
        }
    }
}
