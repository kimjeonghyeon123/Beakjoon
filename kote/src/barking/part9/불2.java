package barking.part9;

import java.io.*;
import java.util.*;

public class 불2 {

    private static int N, w, h;
    private static int[][] graph;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static Queue<Node> sq;
    private static Queue<Node> fq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringBuilder sb =  new StringBuilder();
        int t = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph = new int[w][h];

            sq = new LinkedList<>();
            fq = new LinkedList<>();

            for(int j = 0; j < w; j++) {
                String str = br.readLine();
                for(int k = 0; k < h; k++) {
                    switch (str.charAt(k)) {
                        case '#':
                            graph[j][k] = -1;
                            break;
                        case '*':
                            graph[j][k] = -2;
                            fq.offer(new Node(j, k));
                            break;
                        case '@':
                            graph[j][k] = 1;
                            sq.offer(new Node(j, k));
                            break;
                        default:
                            graph[j][k] = 0;
                            break;

                    }
                }
            }

            t = bfs();
            if(t == -1) {sb.append("IMPOSSIBLE\n");}
            else {sb.append(t).append("\n");}
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        int size = 0;
        while(!sq.isEmpty()) {
            size = sq.size();

            for(int i = 0; i < size; i++) {
                Node node = sq.poll();

                int x = node.getX();
                int y = node.getY();

                if(graph[x][y] == -2) {
                    continue;
                }

                if(x == 0 || x == w-1 || y == 0 || y == h-1) {
                    return graph[x][y];
                }

                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || nx >= w || ny < 0 || ny >= h) {continue;}
                    if(graph[nx][ny] == -1 || graph[nx][ny] == -2) {continue;}
                    if(graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        sq.offer(new Node(nx, ny));
                    }
                }
            }

            if(sq.isEmpty()) {
                break;
            }

            size = fq.size();
            for(int i = 0; i < size; i++) {
                Node node = fq.poll();

                int x = node.getX();
                int y = node.getY();

                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || nx >= w || ny < 0 || ny >= h) {continue;}

                    if(graph[nx][ny] == -1 || graph[nx][ny] == -2) {continue;}

                    graph[nx][ny] = -2;
                    fq.offer(new Node(nx, ny));
                }
            }
        }

        return -1;
    }
}
