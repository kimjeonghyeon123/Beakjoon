package 삼성코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {
    public static class Fireball {
        int r,c,m,s;
        ArrayList<Integer> direction_list = new ArrayList<>();

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            direction_list.add(d);
        }
    }
    public static int N, M, K;
    public static Fireball[][] graph;
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static Queue<Fireball> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new Fireball[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[r][c] = new Fireball(r,c,m,s,d);
        }

        for(int time = 0; time < K; time++) {
            // 파이어볼 찾아서 큐에 담기
            find_fireball();

            // 이동 후 그래프 새로 만들기
            graph = new Fireball[N][N];

            // 파이어볼 이동하기
            move_fireball();

            // 이동 후 4개로 나누기
            divide_fireball();
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == null) {continue;}

                sum += (graph[i][j].m * graph[i][j].direction_list.size());
            }
        }

        System.out.println(sum);
    }

    public static void find_fireball() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == null) {continue;}

                for(int d : graph[i][j].direction_list) {
                    q.offer(new Fireball(i, j, graph[i][j].m, graph[i][j].s, d));
                }
            }
        }
    }

    public static void move_fireball() {
        while(!q.isEmpty()) {
            Fireball fireball = q.poll();
            int x = fireball.r;
            int y = fireball.c;
            int m = fireball.m;
            int s = fireball.s;
            int d = fireball.direction_list.get(0);

            int nx = x + s * dx[d];
            int ny = y + s * dy[d];

            nx = ((nx % N) + N) % N;
            ny = ((ny % N) + N) % N;

            if(graph[nx][ny] == null) {
                graph[nx][ny] = new Fireball(nx, ny, m, s, d);
                continue;
            }

            graph[nx][ny].m += m;
            graph[nx][ny].s += s;
            graph[nx][ny].direction_list.add(d);
        }
    }

    public static void divide_fireball() {
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == null) {continue;}

                int cnt = graph[i][j].direction_list.size();

                if(cnt == 1) {continue;}

                graph[i][j].m /= 5;

                if(graph[i][j].m == 0) {
                    graph[i][j] = null;
                    continue;
                }

                graph[i][j].s /= cnt;

                boolean same = true;
                int rest = graph[i][j].direction_list.get(0) % 2;
                for(int d = 1; d < cnt; d++) {
                    if(rest != graph[i][j].direction_list.get(d) % 2) {
                        same = false;
                        break;
                    }
                }

                graph[i][j].direction_list.clear();
                if(same) {
                    for(int d = 0; d <= 6; d += 2) {
                        graph[i][j].direction_list.add(d);
                    }
                }
                else {
                    for(int d = 1; d <= 7; d += 2) {
                        graph[i][j].direction_list.add(d);
                    }
                }
            }
        }
    }
}
