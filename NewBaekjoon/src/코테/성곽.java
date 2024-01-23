package 코테;

/**
 * 굵은 선 : 벽
 * 점선   : 지나다닐 수 있음
 *
 * 1. 이 성에 있는 방의 개수
 * 2. 가장 넓은 방의 넓이
 * 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
 *
 * 남동북서
 * 0001
 * 0010
 * 0100
 * 1000
 */

import java.io.*;
import java.util.*;

public class 성곽 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int N, M;
    public static int[][] graph;
    public static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        area = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(area[i][j] == 0) {
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        System.out.println(cnt - 1);
        int[] count = new int[cnt+1];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                count[area[i][j]]++;
            }
        }

        System.out.println(Arrays.stream(count).max().getAsInt());

        int max = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) {continue;}
                    if(area[i][j] != area[nx][ny]) {
                        max = Math.max(max, count[area[i][j]] + count[area[nx][ny]]);
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs(int x, int y, int cnt) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        area[x][y] = cnt;
        while(!q.isEmpty()) {
            Node node = q.poll();
            Stack<Integer> stack = find_direction(graph[node.x][node.y]);
            for(int i = 0; i < 4; i++) {
                if(stack.pop() == 1) {continue;}
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {continue;}
                if(area[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    area[nx][ny] = cnt;
                }
            }

        }
    }

    public static Stack<Integer> find_direction(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        int size = stack.size();
        for(int i = 0; i < 4 - size; i++) {
            stack.push(0);
        }
        return stack;
    }
}