package 코테공부.DFSBFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

public class 미로탈출 {

    public static int N, M;
    public static int[][] graph;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        int count = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            count++;
            System.out.println(count + " : " + x + ", " + y);
//            if(x == N-1 && y == M-1) {
//                break;
//            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    continue;
                }

                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }

        }

        return graph[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
