package test2;

/**
 * N X N
 * graph[i][j] = n   (i,j)에 n명 살고 있음
 *
 * 인구이동
 * 1) 국경선은 공유하는 두 나라 인구차이가 L 이상, R 이하면 국경선을 하루동안 연다
 * 2) 국경선을 모두 연 다음 인구 이동 시작
 * 3) 국경선 열린 나라들을 연합이라고 한다.
 * 4) (연합의 인구수) / (연합을 이루는 칸의 개수)로 통일 소수점 버림
 * 5) 연합 해체 국경선 닫기
 * 6) 인구 이동이 며칠 동안 발생하는지 구해라
 *
 * L <= graph[i][j] - graph[i+1][j] <= R
 * 둘 다 열어
 * o o
 * o o
 *
 * 0,0 0,1 1,0 연결
 *
 */

import java.io.*;
import java.util.*;

public class 인구이동 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, L, R;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result = 0;
        while(true) {
            boolean ismove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if(list.size() > 1) {
                            move(bfs(i, j));
                            ismove = true;
                        }
                    }
                }
            }
            if(!ismove) {break;}
            result++;
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = graph[x][y];
        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                if(visited[nx][ny]) {continue;}
                int cha = Math.abs(graph[x][y] - graph[nx][ny]);
                if(L <= cha && cha <= R) {
                    q.offer(new Node(x, y));
                    list.add(new Node(x, y));
                    sum += graph[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }

        return sum;
    }

    public static void move(int sum) {
        int avg = sum / list.size();
        for(Node node : list) {
            graph[node.x][node.y] = avg;
        }
    }
}
