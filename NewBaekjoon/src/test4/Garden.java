package test4;

/**
 * 초록색, 빨간색 배양액을 땅에 뿌림
 * 매 초마다 이전에 도달한 적 없는 땅으로 퍼져간다.
 * 하약색 : 배양액 뿌릴 수 없는 칸
 * 황토색 : 배양액 뿌릴 수 있는 칸
 * 하늘색 : 호수
 *
 * 초록색과 빨간색이 동시에 만나면 합쳐짐
 *
 * i,j를 G+R만큼 뽑아
 * i,j 에 녹색인지 빨강인지 정해
 *
 *
 * 0(0,0)    1   3 4 ... M-1
 * M(1,0)   M+1 ...      2M-1
 * 2M(2,0)
 * ...
 * N*(M-1)(N,0)               N*M
 *
 * for(int i = start+1; i < N*M; i++) {
 *     visited[i][j] = true;
 *     dfs(i, j);
 *     visited[i][j] = false;
 * }
 * if(graph[i][j] == 2) {
 *
 * }
 */

import java.io.*;
import java.util.*;

public class Garden {
    public static class Node {
        int x, y, settime;
        char color;
        boolean isflower;
        public Node(int x, int y, char color, int settime, boolean isflower) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.settime = settime;
            this.isflower = isflower;
        }
    }
    public static int N, M, G, R;
    public static int[][] graph;
    public static Node[] pickNode;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 0 : 호수
        // 1 : 배양액 뿌릴 수 없음
        // 2 : 배양액 뿌릴 수 있음
        graph = new int[N][M];
        pickNode = new Node[G+R];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int depth, int start, int gcnt, int rcnt) {
        if(gcnt > G || rcnt > R) {return;}
        if(gcnt == G && rcnt == R) {
            bfs();
            return;
        }
        for(int i = start+1; i < N * M; i++) {
            if(graph[i / M][i % M] == 2) {
                pickNode[depth] = new Node(i / M, i % M, 'G', 0, false);
                dfs(depth+1, i, gcnt+1, rcnt);
                pickNode[depth] = new Node(i / M, i % M, 'R', 0, false);
                dfs(depth + 1, i, gcnt, rcnt + 1);
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        Node[][] visited = new Node[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], null);
        }
        for(int i = 0; i < G+R; i++) {
            q.offer(pickNode[i]);
            visited[pickNode[i].x][pickNode[i].y] = pickNode[i];
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 0) {continue;}
                if(visited[nx][ny] == null) {
                    q.offer(new Node(nx, ny, node.color, node.settime+1, false));
                    visited[nx][ny] = new Node(nx, ny, node.color, node.settime+1, false);
                }
                else {
                    if(!visited[nx][ny].isflower) {
                        if(visited[nx][ny].color != node.color && visited[nx][ny].settime == node.settime + 1) {
                            visited[nx][ny].isflower = true;
                            cnt++;
                        }
                    }
                }
            }
        }

        max = Math.max(max, cnt);
    }
}
