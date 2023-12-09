package barking;

import java.io.*;
import java.util.*;

class Tomato {
    private int x, y;
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
}
public class 토마토 {

    public static int N, M;
    public static int[][] graph;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                Tomato tomato = q.poll();
                int x = tomato.getX();
                int y = tomato.getY();

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) { continue; }
                    if(graph[nx][ny] == -1 || graph[nx][ny] != 0) { continue; }

                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Tomato(nx, ny));
                }
            }
            count++;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0){
                    return -1;
                }
            }
        }
        return count - 1;
    }
}
