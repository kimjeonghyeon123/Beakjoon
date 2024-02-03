package 코테;

import java.io.*;
import java.util.*;

public class 소가길을건너간이유 {
    public static class Cow {
        int x, y;
        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, K, R;
    public static boolean[][] visited;
    public static Cow[] cows;
    public static ArrayList<Cow>[][] bridges;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        bridges = new ArrayList[N][N];
        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < N; j++) {
                bridges[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            bridges[r1][c1].add(new Cow(r2, c2));
            bridges[r2][c2].add(new Cow(r1, c1));
        }

        cows = new Cow[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            cows[i] = new Cow(x, y);
        }

        int sum = 0;
        for(int i = 0; i < K-1; i++) {
            sum += bfs(i);
        }
        System.out.println(sum);
    }

    public static int bfs(int start) {
        Queue<Cow> q = new LinkedList<>();
        visited = new boolean[N][N];

        int x = cows[start].x;
        int y = cows[start].y;
        q.offer(new Cow(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Cow now = q.poll();
            x = now.x;
            y = now.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 벗어나거나 방문한 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {continue;}

                // 현재 위치에 다리가 없는 경우 그대로 이동
                if(bridges[x][y].size() == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Cow(nx, ny));
                    continue;
                }

                // 현재 위치에 다리가 있는 경우
                // 다음 갈 위치에 다리가 있는 경우
                boolean hasBridge = false;
                for(Cow next : bridges[x][y]) {
                    if(next.x == nx && next.y == ny) {
                        hasBridge = true;
                        break;
                    }
                }

                if(hasBridge) {continue;}

                visited[nx][ny] = true;
                q.offer(new Cow(nx, ny));
            }
        }

        int cnt = 0;
        for(int i = start+1; i < K; i++) {
            if(!visited[cows[i].x][cows[i].y]) {
                cnt++;
            }
        }

        return cnt;
    }
}
/**
 * N * N
 * 소 K 마리
 *
 * 다리가 주어짐
 * 다리를 건너야 만날 수 있는 소 쌍이 몇개인가?
 *
 * 1 1 1 1 1
 * 1 1 1 2 2
 *
 * x, y  nx ny 둘다 true인 경우 다리를 건넘
 */