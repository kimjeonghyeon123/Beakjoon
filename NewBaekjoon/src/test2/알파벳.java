package test2;

/**
 * 세로 R칸 가로 C칸
 *
 * (1,1)에는 말이 놓여있음
 *
 * 새로 이동한 칸에 적혀있는 알파벳은 지금까지 지나온 모든 칸에 적혀이쓴 알파벳과 달라야 한다.
 */

import java.io.*;
import java.util.*;

public class 알파벳 {

    public static int max = Integer.MIN_VALUE;
    public static int R, C;
    public static char[][] graph;
    public static boolean visited[] = new boolean[26];
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        visited[graph[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        boolean canMove = false;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) {continue;}
            if(!visited[graph[nx][ny] - 'A']) {
                visited[graph[nx][ny] - 'A'] = true;
                dfs(nx, ny, cnt+1);
                visited[graph[nx][ny] - 'A'] = false;
                canMove = true;
            }
        }
        if(!canMove) {
            max = Math.max(max, cnt);
        }
    }
}
