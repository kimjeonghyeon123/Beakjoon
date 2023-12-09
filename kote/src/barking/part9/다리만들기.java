package barking.part9;

/**
 * 섬 잇는데 가장 짧은 다리의 길이를 구해라
 * 1) dfs로 섬 몇개인지 구하면서 visited = true, 섬마다 번호 표시함
 * 2) bfs로 각 위치에서 다른 섬으로 가는 최소 거리 구함
 * 3) 그 중 가장 작은 것 구함
 */

import java.io.*;
import java.util.*;

class Island {
    int x, y, cnt;

    public Island(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getCnt() {return cnt;}
}
public class 다리만들기 {

    public static final int INF = (int) 1e9;
    public static int N;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int landNum = 2;
    public static int result = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    makeName(i, j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] >= 2) {
                    visited = new boolean[N][N];
                    shortest(i, j);
                }
            }
        }
        System.out.println(result);
    }

    public static void makeName(int x, int y) {
        Queue<Island> q = new LinkedList<>();

        q.offer(new Island(x, y, 0));
        visited[x][y] = true;
        graph[x][y] = landNum;

        while(!q.isEmpty()) {
            Island island = q.poll();
            x = island.getX();
            y = island.getY();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new Island(nx, ny, 0));
                    graph[nx][ny] = landNum;
                    visited[nx][ny] = true;
                }
            }
        }
        landNum++;
    }

    public static void shortest(int x, int y) {
        Queue<Island> q = new LinkedList<>();
        q.offer(new Island(x, y, 0));
        int current = graph[x][y];

        while(!q.isEmpty()) {
            Island island = q.poll();
            x = island.getX();
            y = island.getY();
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                if(graph[nx][ny] == current || visited[nx][ny]) {continue;}
                visited[nx][ny] = true;
                if(graph[nx][ny] == 0) {
                    q.offer(new Island(nx, ny, island.getCnt()+1));
                }
                else {
                    result = Math.min(result, island.getCnt());
                }
            }
        }
    }
}
