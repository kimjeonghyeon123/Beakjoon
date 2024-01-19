package test4;

/**
 * 총 25명
 * 5 X 5
 *
 * 이다솜파
 * 임도연파
 *
 * 7명의 여학생
 * 7명은 서로 가로 세로로 인접
 * 이다솜파로만 구성될 필요는 없다
 * 이다솜파가 적어도 4명 이상이 되어야 함
 */

import java.io.*;
import java.util.*;

public class 소문난칠공주 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static char[][] graph = new char[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                visited[i][j] = true;
                if(graph[i][j] == 'S') {
                    dfs(i,j,1,0);
                }
                else {
                    dfs(i,j,0,1);
                }
                visited[i][j] = false;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int scnt, int ycnt) {
        if(ycnt >= 4) {
            return;
        }
        if(scnt + ycnt == 7) {
            if(cango(x, y)) {
                cnt++;
            }
            return;
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(graph[i][j] == 'S') {
                        dfs(i,j,scnt+1,ycnt);
                    }
                    else {
                        dfs(i,j,scnt,ycnt+1);
                    }
                    visited[i][j] = false;
                }
            }
        }
    }

    public static boolean cango(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[5][5];
        q.offer(new Node(x, y));
        check[x][y] = true;

        int result = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            result++;

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {continue;}
                if(visited[nx][ny] && !check[nx][ny]) {
                    check[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return result==7;
    }
}
