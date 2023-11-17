package barking.part9;

import java.io.*;
import java.util.*;

public class 나이트의이동 {

    private static int K;
    private static int N;
    private static int R;
    private static int C;
    private static int[][] graph;
    private static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int t = bfs(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
            sb.append(t).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int sx, int sy, int fx, int fy) {
        graph = new int[N][N];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            if(x == fx && y == fy) {
                return graph[x][y];
            }
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return -1;
    }
}
