package test4;

/**
 * 5 X 5
 * 이다솜파 : 'S'
 * 임도연파 : 'Y'
 *
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

        dfs(0, 0, 0);
        System.out.println(cnt);
    }

    public static void dfs(int scnt, int ycnt, int start) {
        if(ycnt >= 4) {return;}
        if(scnt + ycnt == 7) {
            if(checkLinked()) {
                cnt++;
            }
            return;
        }
        for(int i = start; i < 25; i++) {
            visited[i / 5][i % 5] = true;
            if(graph[i / 5][i % 5] == 'S') {
                dfs(scnt+1, ycnt, i+1);
            }
            else {
                dfs(scnt, ycnt+1, i+1);
            }
            visited[i / 5][i % 5] = false;
        }
    }

    public static boolean checkLinked() {
        boolean[][] cpyVisited = new boolean[5][5];
        for(int i = 0; i < 5; i++) {
            cpyVisited[i] = visited[i].clone();
        }

        int x = 0, y = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(cpyVisited[i][j]) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        int result = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {continue;}
                if(cpyVisited[nx][ny]) {
                    result++;
                    q.offer(new Node(nx, ny));
                    cpyVisited[nx][ny] = false;
                }
            }
        }

        if(result == 7) {
            return true;
        }
        return false;
    }
}
