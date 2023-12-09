package barking.part9;

/**
 * 원숭이 말 되고 싶음
 * 원숭이 K 번만 말처럼 움직이고 그 외에는 한칸씩 가능
 * 0,0 n-1, m-1 까지
 */

import java.io.*;
import java.util.*;

class Horse {
    int x, y, cnt, len;

    public Horse(int x, int y, int cnt, int len) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.len = len;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }

    public int getLen() {
        return len;
    }
}
public class 말이되고픈원숭이 {

    public static int K, W, H;
    public static int[][] graph;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] h_dx = {-2, -2, 2, 2, -1, -1, 1, 1};
    public static int[] h_dy = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        graph = new int[W][H];
        visited = new boolean[W][H][K+1];
        for(int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < H; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Horse> q = new LinkedList<>();
        q.offer(new Horse(0, 0, 0, 0));
        visited[0][0][0] = true;
        int t = -1;
        while(!q.isEmpty()) {
            Horse horse = q.poll();
            int x = horse.getX();
            int y = horse.getY();
            int cnt = horse.getCnt();
            int len = horse.getLen();

            if(x == W-1 && y == H-1) {
                t = len;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= W || ny < 0 || ny >= H) {continue;}
                if(graph[nx][ny] == 1 || visited[nx][ny][cnt]) {continue;}
                q.offer(new Horse(nx, ny, cnt, len+1));
                visited[nx][ny][cnt] = true;
            }

            if(cnt < K) {
                for(int i = 0; i < 8; i++) {
                    int nx = x + h_dx[i];
                    int ny = y + h_dy[i];

                    if(nx < 0 || nx >= W || ny < 0 || ny >= H) {continue;}
                    if(graph[nx][ny] == 1 || visited[nx][ny][cnt+1]) {continue;}
                    q.offer(new Horse(nx, ny, cnt+1, len+1));
                    visited[nx][ny][cnt+1] = true;
                }
            }
        }
        System.out.println(t);
    }
}
