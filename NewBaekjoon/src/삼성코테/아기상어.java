package 삼성코테;

import java.io.*;
import java.util.*;

public class 아기상어 {
    public static class Node implements Comparable<Node> {
        int x, y, cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node other) {
            if(this.cnt < other.cnt) {
                return -1;
            }
            else if(this.cnt == other.cnt) {
                if(this.x < other.x) {
                    return -1;
                }
                else if(this.x == other.x) {
                    if(this.y < other.y) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    }
    public static class Fish {
        int x, y, eat_cnt, size;
        public Fish(int x, int y, int eat_cnt, int size) {
            this.x = x;
            this.y = y;
            this.eat_cnt = eat_cnt;
            this.size = size;
        }
    }
    public static int N;
    public static int[][] graph;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static Fish babyshark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9) {
                    graph[i][j] = 0;
                    babyshark = new Fish(i, j, 0, 2);
                }
            }
        }

        int t = 0;
        while(true) {
            int cnt = bfs();
            if(cnt == -1) {
                break;
            }
            t += cnt;
        }

        System.out.println(t);
    }

    public static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        visited[babyshark.x][babyshark.y] = true;
        pq.offer(new Node(babyshark.x, babyshark.y, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if(graph[x][y] != 0 && graph[x][y] < babyshark.size) {
                babyshark.x = x;
                babyshark.y = y;
                graph[x][y] = 0;
                babyshark.eat_cnt++;
                if(babyshark.eat_cnt == babyshark.size) {
                    babyshark.eat_cnt = 0;
                    babyshark.size++;
                }
                return cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] > babyshark.size) {
                    continue;
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, cnt+1));
                }
            }
        }

        return -1;
    }
}
/**
 * N*N
 * 물고기 M마리
 * 아기 상어 1마리
 *
 * 아기 상어의 크기 : 2
 * 자기와 크기가 같은 수만큼 물고기 먹으면 1 증가
 * 크기가 큰 칸은 못지나감
 * 크기가 작은 물고기만 먹을 수 있음
 * 먹을 수 있는 물고기가 1마리이면 물고기 먹으러 감
 * 먹을 수 있는 물고기가 1마리보다 많다면 거리가 가장 가까운 물고기
 * 지나야 하는 칸의 개수 최솟값
 * 중복될 경우 가장 위, 가장 왼쪽 순으로 먹음
 *
 */