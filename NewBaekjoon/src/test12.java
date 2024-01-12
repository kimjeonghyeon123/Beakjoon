/**
 * R X C
 *
 * 1. 아두이노를 8가지 방향으로 이동하거나 그대로 놔둠
 * 2. 미친 아두이노가 있느 칸으로 이동하면 게임 끝 졌어
 * 3. 미친 아두이노는 종수와 가까워지는 방향으로 한 칸 이동 [r1 - r2] + [r1-r2] 가 가장 작은 방향
 * 4. 2개 이상의 미친 아두이노가 같은 칸에 있는 경우 폭발함
 *
 */

import java.io.*;
import java.util.*;

public class test12 {

    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int R, C;
    public static char[][] graph;
    public static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
    public static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
    public static boolean[][] exploded;

    public static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        exploded = new boolean[R][C];

        Node jongsu = null;
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;
                if(c == 'I') {
                    jongsu = new Node(i, j);
                }
                else if(c == 'R') {
                    q.offer(new Node(i, j));
                }
            }
        }
        String cmd = br.readLine();

        for(int t = 0; t < cmd.length(); t++) {
            int move = cmd.charAt(t) - '0';
            jongsu.x += dx[move];
            jongsu.y += dy[move];

            int size = q.size();
            for(int k = 0; k < size; k++) {
                Node crazy = q.poll();
                if(exploded[crazy.x][crazy.y]) {
                    graph[crazy.x][crazy.y] = '.';
                    continue;
                }

                int min = Integer.MAX_VALUE;
                int tempx = 0;
                int tempy = 0;
                for(int i = 1; i <= 9; i++) {
                    if(i == 5) {continue;}
                    int nx = crazy.x + dx[i];
                    int ny = crazy.y + dy[i];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {continue;}
                    if(min > Math.abs(jongsu.x - nx) + Math.abs(jongsu.y - ny)) {
                        min = Math.abs(jongsu.x - nx) + Math.abs(jongsu.y - ny);
                        tempx = nx;
                        tempy = ny;
                    }
                }

                graph[crazy.x][crazy.y] = '.';
                if(graph[tempx][tempy] == '.' && !exploded[tempx][tempy]) {
                    graph[tempx][tempy] = 'R';
                    q.offer(new Node(tempx, tempy));
                }
                else if(graph[tempx][tempy] == 'R' && !exploded[tempx][tempy]) {
                    exploded[tempx][tempy] = true;
                }
            }


        }
    }
}
