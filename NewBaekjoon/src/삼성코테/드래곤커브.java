package 삼성코테;

import java.io.*;
import java.util.*;

public class 드래곤커브 {
    public static int[][] graph = new int[101][101];
    // 동 북 서 남 왼쪽 : 1 오른쪽 :-1
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static int[] dir = {0, 1, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            switch (generation) {
                case 0:
                    generation = 1;
                    break;
                case 1:
                    generation = 2;
                    break;
                case 2:
                    generation = 4;
                    break;
                case 3:
                    generation = 8;
                    break;
            }

            graph[x][y] = 1;
            for(int i = 0; i < generation; i++) {
                d += dir[i];
                if(d == -1) {d = 3;}
                else if(d == 4) {d = 0;}
                x += dx[d];
                y += dy[d];
                graph[x][y] = 1;
            }


            System.out.println("0 1 2 3 4");
            for(int i = 0; i <= 4; i++) {
                for(int j = 0; j <= 4; j++) {
                    System.out.print(i + " " + graph[j][i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
/**
 * graph[x][y] = 열
 * x축 오른쪽방향 x축 증가
 * y축 아래방향
 *
 * 0세대 : 길이가 1인 선분
 * 1세대 : 0세대 시작점에서 끝점을 기준으로 시계방향으로 90도 회전
 * 2세대 :
 *
 * 0세대의 끝점 : (x0, y0)
 * 0세대의 시작점이 i세대의 끝점이 됨 :
 *
 *
 */
