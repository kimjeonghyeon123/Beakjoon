package barking.part9;

/**
 * 미로 탈출 -> bfs
 * 사람과 불은 동시에 출발함
 *
 */

import java.io.*;
import java.util.*;

class Node2 {
    private int x;
    private int y;
    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
}
public class 불3 {

    public static int R, C;
    public static int[][] graph;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static Queue<Node2> jq = new LinkedList<>();
    public static Queue<Node2> fq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                switch (str.charAt(j)) {
                    case '#':
                        graph[i][j] = -1;
                        break;
                    case '.':
                        graph[i][j] = 0;
                        break;
                    case 'J':
                        graph[i][j] = 1;
                        jq.offer(new Node2(i, j));
                        break;
                    case 'F':
                        graph[i][j] = -2;
                        fq.offer(new Node2(i, j));
                        break;
                }
            }
        }

        int t = bfs();
        if(t == -1) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(t);
        }
    }

    // 시작하는 노드가 다 불에 타 있으면 죽은거임
    public static int bfs() {

        int size = 0;
        while(!jq.isEmpty()) {
            size = jq.size();
            for(int i = 0; i < size; i++) {
                Node2 node = jq.poll();
                int x = node.getX();
                int y = node.getY();

                if(graph[x][y] == -2) {continue;}

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
                        jq.offer(new Node2(nx, ny));
                    }
                }
            }

            size = fq.size();
            for(int i = 0; i < size; i++) {
                Node2 node = fq.poll();
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
                    fq.offer(new Node2(nx, ny));
                }
            }
        }

        return -1;
    }
}
