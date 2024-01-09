/**
 * 체스판
 * - 이동하려는 체스판의 색깔
 * - 말 배열 만들어서 말 위치 업데이트하자
 * - 흰색
 *      - 그 칸 위에 올려놓음
 * - 빨강색
 *      - 그 칸 위에 거꾸로 올려놓음
 * - 파란색이거나 벗어났을 경우
 *      - 반대 방향으로 한 칸 이동
 *          - 파란색이거나 벗어났을 경우
 *              - 제자리에서 방향만 반대 방향으로 바꿈
 *  맨 처음 큐에 순서대로 담음
 *  1번 말부터 그 위치에 자기자신이 가장 아래에 있는지 검사하고 아래에 있는 것만 큐에 넣음
 *  데큐로 만들자
 */

import java.io.*;
import java.util.*;

class Horse {
    int index, x, y, dx, dy;
    public Horse(int index, int x, int y, int dx, int dy) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
}
public class test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Deque<Integer>[][] list = new Deque[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                list[i][j] = new LinkedList<>();
            }
        }

        Queue<Horse> q = new LinkedList<>();
        Horse[] horse = new Horse[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int dx = 0, dy = 0;
            switch(d) {
                case 1:
                    dy = 1;
                    break;
                case 2:
                    dy = -1;
                    break;
                case 3:
                    dx = -1;
                    break;
                case 4:
                    dx = 1;
                    break;
            }
            horse[i] = new Horse(i, x, y, dx, dy);
            list[x][y].offerLast(i);
            q.offer(horse[i]);
        }

        int result = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                Horse node = q.poll();

                int nx = node.x + node.dx;
                int ny = node.y + node.dy;

                // 파란색이거나 벗어났을 경우
                if(nx <= 0 || nx > N || ny <= 0 || ny > N || graph[nx][ny] == 2) {
                    horse[node.index].dx = -node.dx;
                    horse[node.index].dy = -node.dy;
                    nx = node.x + horse[node.index].dx;
                    ny = node.y + horse[node.index].dy;
                }

                System.out.println("(x, y) = (" + node.x + ", " + node.y + ")");
                System.out.println("(nx, ny) = (" + nx + ", " + ny + ")");
                // 한번 더 파란색이거나 벗어났을 경우
                if(nx <= 0 || nx > N || ny <= 0 || ny > N || graph[nx][ny] == 2) {
                    continue;
                }
                // 흰색일 경우
                else if(graph[nx][ny] == 0) {
                    while(!list[node.x][node.y].isEmpty()) {
                        int index = list[node.x][node.y].pollFirst();
                        list[nx][ny].offerLast(index);
                        horse[index].x = nx;
                        horse[index].y = ny;
                    }
                }
                else if(graph[nx][ny] == 1) {
                    while(!list[node.x][node.y].isEmpty()) {
                        int index = list[node.x][node.y].pollLast();
                        list[nx][ny].offerLast(index);
                        horse[index].x = nx;
                        horse[index].y = ny;
                    }
                }
            }

            // 말 검사
            for (int i = 0; i < K; i++) {
                if(list[horse[i].x][horse[i].y].size() >= 4) {
                    break;
                }
                if (list[horse[i].x][horse[i].y].peekFirst() == i) {
                    q.offer(horse[i]);
                }
            }
            if(result > 1000) {
                break;
            }
            System.out.println(result);
            result++;
        }

        System.out.println(result);
    }
}