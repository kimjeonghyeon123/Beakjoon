package 삼성코테;

import java.io.*;
import java.util.*;

public class 연구소3 {
    public static class Node {
        int x, y, cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static ArrayList<Node> viruslist = new ArrayList<>();
    public static Node[] active_virus;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int min = Integer.MAX_VALUE;
    public static int originEmptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        active_virus = new Node[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 0) {
                    originEmptySpace++;
                }
                else if(graph[i][j] == 2) {
                    viruslist.add(new Node(i, j, 0));
                }
            }
        }

        if(originEmptySpace == 0) {
            System.out.println(0);
        }
        else {
            selectVirus(-1, 0);
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    public static void selectVirus(int start, int depth) {
        if(depth == M) {
            find_min();
            return;
        }

        for(int i = start+1; i < viruslist.size(); i++) {
            active_virus[depth] = viruslist.get(i);
            selectVirus(i, depth+1);
        }
    }

    public static void find_min() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < M; i++) {
            q.offer(active_virus[i]);
            visited[active_virus[i].x][active_virus[i].y] = true;
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                if(visited[nx][ny] || graph[nx][ny] == 1) {continue;}

                if(graph[nx][ny] == 0) {
                    cnt++;
                }

                if(cnt == originEmptySpace) {
                    min = Math.min(min, node.cnt + 1);
                    return;
                }
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, node.cnt+1));
            }
        }
    }
}
/**
 * 0 = 빈 칸
 * 1 = 벽
 * 2 = 바이러스
 */