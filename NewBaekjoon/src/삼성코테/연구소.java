package 삼성코테;

import java.io.*;
import java.util.*;

public class 연구소 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static ArrayList<Node> virusnodes = new ArrayList<>();
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    virusnodes.add(new Node(i, j));
                }
            }
        }

        setwall(-1, 0);

        System.out.println(max);
    }

    public static void setwall(int start, int depth) {
        if(depth == 3) {
            max = Math.max(max, find_safe());
            return;
        }

        for(int i = start+1; i < N*M; i++) {
            int x = i/M;
            int y = i%M;
            if(graph[x][y] == 0) {
                graph[x][y] = 1;
                setwall(i, depth+1);
                graph[x][y] = 0;
            }
        }
    }

    public static int find_safe() {
        Queue<Node> q = new LinkedList<>();
        for(Node virusnode : virusnodes) {
            q.offer(virusnode);
        }

        int[][] cpyGraph = new int[N][M];
        for(int i = 0; i < N; i++) {
            cpyGraph[i] = graph[i].clone();
        }

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(cpyGraph[nx][ny] == 0) {
                    cpyGraph[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cpyGraph[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
/**
 * N*M
 * 바이러스 상하좌우로 퍼져나감
 * 벽 3개 세우기
 *
 * 안전 영역의 크기가 가장 큰 경우 구하기
 */