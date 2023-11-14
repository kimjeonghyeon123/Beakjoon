package barking.part9;

import java.io.*;
import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
}

public class 불 {

    private static int R, C;
    private static int[][] graph;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static Queue<Node> jq = new LinkedList<>();
    private static Queue<Node> fq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                if(str.charAt(j) == '#') {
                    graph[i][j] = -1;
                }
                else if(str.charAt(j) == '.') {
                    graph[i][j] = 0;
                }
                else if(str.charAt(j) == 'J') {
                    graph[i][j] = 1;
                    jq.offer(new Node(i, j));
                }
                else if(str.charAt(j) == 'F') {
                    graph[i][j] = -2;
                    fq.offer(new Node(i, j));
                }
            }
        }

        int t = bfs();
        if(t == 0) {
            bw.write("IMPOSSIBLE");
        }
        else {
            bw.write(String.valueOf(t));
        }
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        int count = 0;

        while(!jq.isEmpty()) {
            Node jnode = jq.poll();
            int x = jnode.getX();
            int y = jnode.getY();

            if(graph[x][y] == -2) {
                if(jq.isEmpty()) {
                    return 0;
                }
                continue;
            }

            if(x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                if(count < graph[x][y])
                    count = graph[x][y];
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                if(graph[nx][ny] == -1 || graph[nx][ny] == -2) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    jq.offer(new Node(nx, ny));
                }
            }


            Node fnode = fq.poll();
            x = fnode.getX();
            y = fnode.getY();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                if(graph[nx][ny] != -1 && graph[nx][ny] != -2) {
                    graph[nx][ny] = -2;
                    fq.offer(new Node(nx, ny));
                }
            }
        }

        return count;
    }
}
