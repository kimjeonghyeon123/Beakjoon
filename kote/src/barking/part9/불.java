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
        if(t == -1) {
            bw.write("IMPOSSIBLE");
        }
        else {
            bw.write(String.valueOf(t));
        }
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        int size = 0;
        while(!jq.isEmpty()) {
            size = jq.size();
            for(int i = 0; i < size; i++) {
                Node node = jq.poll();
                int x = node.getX();
                int y = node.getY();
                if(graph[x][y] == -2) {
                    continue;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        return graph[x][y];
                    }
                    if(graph[nx][ny] == -1 || graph[nx][ny] == -2) {
                        continue;
                    }
                    if(graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        jq.offer(new Node(nx, ny));
                    }
                }
            }

            size = fq.size();
            for(int i = 0; i < size; i++) {
                Node node = fq.poll();
                int x = node.getX();
                int y = node.getY();

                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }
                    if(graph[nx][ny] == -1 || graph[nx][ny] == -2) {
                        continue;
                    }
                    graph[nx][ny] = -2;
                    fq.offer(new Node(nx, ny));
                }
            }
        }

        return -1;
    }
}
