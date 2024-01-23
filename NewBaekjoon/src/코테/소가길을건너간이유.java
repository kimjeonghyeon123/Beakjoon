package 코테;

/**
 *
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class 소가길을건너간이유 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
    }
    public static int N, K, R;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        ArrayList<Node>[][] bridges = new ArrayList[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                bridges[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i <R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            bridges[r1][c1].add(new Node(r2, c2));
            bridges[r2][c2].add(new Node(r1, c1));
        }

        ArrayList<Node> cows = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows.add(new Node(x, y));
            graph[x][y] = 1;
        }

        int answer = 0;

        for(int t = 0; t < K; t++) {
            Node cow = cows.get(t);

            int count = 0;

            boolean[][] visited = new boolean[N+1][N+1];
            boolean[][] cowContacted = new boolean[K][K];
            Queue<Node> q = new LinkedList<>();

            q.offer(cow);
            visited[cow.x][cow.y] = true;

            while(!q.isEmpty()) {
                Node node = q.poll();

                if(graph[node.x][node.y] == 1) {
                    for (int j = t+1; j < K; j++) {
                        Node nextCow = cows.get(j);
                        if(node == nextCow) {
                            cowContacted[t][j] = true;
                            break;
                        }
                    }
                }

                for(int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {continue;}
                    if(bridges[node.x][node.y].contains(new Node(nx, ny))) {continue;}
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }

            for(int i = t+1; i < K; i++) {
                if(!cowContacted[t][i]) {
                    answer++;
                }
            }
        }
    }
}
