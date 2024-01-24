package 삼성코테;

/**
 * N * M 지도
 * 북쪽으로부터 떨어진 거리 r
 * 서쪽으로부터 떨어진 거리 c
 *   0 1 2 3 4 5 6 7 ... M-1
 * 0
 * 1
 * 2
 * 3
 * .
 * .
 * N-1
 *
 * arr = new int[N][M]
 * 위 : 1 동쪽 : 3
 * x,y
 *
 * 이동한 칸이 0이면
 *      주사위 바닥면이 0으로 됨
 *      칸이 주사위에 적혀있던 숫자가 됨
 *
 *
 *
 */

import java.io.*;
import java.util.*;

public class 주사위굴리기 {
    public static int N, M, x, y, K;
    public static int[][] graph;
    public static int[] dice = new int[7];
    public static int[] dx = {0,0,0,-1,1};
    public static int[] dy = {0,1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> cmdList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            cmdList.add(Integer.parseInt(st.nextToken()));
        }

        for(int cmd : cmdList) {
            int nx = x + dx[cmd];
            int ny = y + dy[cmd];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
            rolldice(cmd);
            if(graph[nx][ny] == 0) {
                graph[nx][ny] = dice[6];
            }
            else {
                dice[6] = graph[nx][ny];
                graph[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            System.out.println(dice[1]);
        }
    }

    public static void rolldice(int dir) {
        int temp;
        switch (dir) {
            case 1:
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            case 2:
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            case 3:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            case 4:
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }
    }
    /**
     *   2
     * 4 1 3
     *   5
     *   6
     *   북
     *   1
     *   5
     *   6
     *   2
     *   남
     *   6
     * 4 2 3
     *   1
     *   5
     *   서
     *   2
     * 1 3 6
     *   5
     *   4
     *   동
     *   2
     * 6 4 1
     *   5
     *   3
     *
     *   1 -> 3, 3 -> 6, 6 -> 4, 4 -> 1 그대로
     *
     *   남
     *
     *
     */
}
