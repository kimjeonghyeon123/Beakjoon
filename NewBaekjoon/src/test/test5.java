package test; /**
 * R*C
 * 첫번째 열은 근처 빵집의 가스관
 * 마지막 열은 원웅의의 빵집
 *
 * 건물이 있으면 파이프를 놓을 수 없음
 * 첫째열에서 시작 마지막 열에서 끝남
 * 오른쪽 오른쪽 위 대각선 아래 대각선 가능
 *
 * 여러 개 설치
 * 각 칸을 지나는 파이프는 하나
 *
 * 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수
 *
 * int[] dx = {-1,0,1};
 * int[] dy = {1,1,1};
 */

import java.io.*;
import java.util.*;

public class test5 {

    public static int result = 0;
    public static boolean isfind;
    public static int R, C;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            isfind = false;
            dfs(i, 0);
        }
        System.out.println(result);
    }

    /**
     * 이동할 때
     * 방문했으면 끝
     * 방문안했으면
     */
    public static void dfs(int x, int y) {

        if(isfind) {return;}

        visited[x][y] = true;
        if(y == C-1) {
            isfind = true;
            result++;
            return;
        }

        for(int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if(nx < 0 || nx >= R) {continue;}
            if(graph[nx][ny] == '.' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
