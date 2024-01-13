package test; /**
 * N X N 방
 * 0,0 ~ N-1,N-1
 *
 * 0,0에서 출발해서 갈 수 있는 방에 있는 스위치로 다른 방의 불을 킬 수 있다.
 * 불 켜져있고 방문안했고 주변에 방문한 곳 있으면 q에 넣어
 * ArrayList<Node>[][] graph = new ArrayList[N][N];
 * for(int i = 0; i < N; i++) {
 *     for(int j = 0; j < N; j++) {
 *          graph[i][j] = new ArrayList<>();
 *     }
 * }
 * graph[x][y].add(new Node(a, b));
 * 1) i, j방 도착해서 스위치 켬 visited[i][j] = true;
 * for(int k = 0; k < graph[i][j].size(); k++) {
 *     Node node = graph[i][j].get(k);
 *     light[node.x][node.y] = true;
 * }
 *
 *
 */

import java.io.*;
import java.util.*;
public class test11 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static ArrayList<Node>[][] graph;
    public static boolean[][] lighted;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N][N];
        visited = new boolean[N][N];
        lighted = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y].add(new Node(a, b));
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        lighted[0][0] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < graph[x][y].size(); i++) {
                Node new_node = graph[x][y].get(i);
                lighted[new_node.x][new_node.y] = true;
            }

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && lighted[i][j]) {
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {continue;}
                            if(visited[nx][ny]) {
                                q.offer(new Node(i, j));
                                visited[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(lighted[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
