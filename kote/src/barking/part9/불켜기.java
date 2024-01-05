package barking.part9;

/**
 * N, N 방
 * 어둠을 무서워하는 암소 베시는 많은 방에 불을 키고
 *
 * 1. 내가 있는 방의 스위치를 눌러서 불을 킨다.
 * 2. 내가 갈 수 있는 방인가 조사
 * 3. 갈 수 있으면 그 방으로 이동 후 불을 킴
 *
 *
 * 1,1 : 1,2,  1,3
 * 1,3 : 1,2,  2,1
 *
 *
 */

import java.io.*;
import java.util.*;

class NodeN {
    int x, y;
    public NodeN(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 불켜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] light_on = new boolean[N][N];
        ArrayList<NodeN>[][] graph = new ArrayList[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int nx = Integer.parseInt(st.nextToken()) - 1;
            int ny = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y].add(new NodeN(nx, ny));
        }

        Queue<NodeN> q = new LinkedList<>();
        q.offer(new NodeN(0, 0));
        light_on[0][0] = true;

        while(!q.isEmpty()) {
            NodeN node = q.poll();
            int x = node.x;
            int y = node.y;

            // 불 키고 갈 수 있으면 큐에 추가
            for (int i = 0; i < graph[x][y].size(); i++) {
                int nx = graph[x][y].get(i).x;
                int ny = graph[x][y].get(i).y;
                light_on[nx][ny] = true;
                if(cango(light_on, nx, ny, N)) {
                    q.offer(new NodeN(nx, ny));
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(light_on[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean cango(boolean[][] light_on, int d_x, int d_y, int N) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<NodeN> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        visited[0][0] = true;
        q.offer(new NodeN(0, 0));

        while(!q.isEmpty()) {
            NodeN node = q.poll();

            int x = node.x;
            int y = node.y;
            if(x == d_x && y == d_y) {
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                if(light_on[nx][ny] && !visited[nx][ny]) {
                    q.offer(new NodeN(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
}
