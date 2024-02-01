package 삼성코테;

import java.io.*;
import java.util.*;

public class 새로운게임2 {
    public static class Node {
        int x, y, dx, dy;
        public Node(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }
    }
    public static int[][] graph;
    public static Stack<Integer>[][] chess;
    public static int N, K;
    public static Node[] horselist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        chess = new Stack[N][N];
        horselist = new Node[K];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                chess[i][j] = new Stack<>();
            }
        }
        horselist = new Node[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int dx = 0, dy = 0;
            if(d == 1) {dy = 1;}
            else if(d == 2) {dy = -1;}
            else if(d == 3) {dx = -1;}
            else {dx = 1;}
            horselist[i] = new Node(x, y, dx, dy);
            chess[x][y].push(i);
        }

        int time = 1;
        boolean finish = false;
        while(time <= 1000) {
            for(int horsenum = 0; horsenum < K; horsenum++) {
                Node node = horselist[horsenum];
                int x = node.x;
                int y = node.y;

                int nx = x + node.dx;
                int ny = y + node.dy;

                // 파란색이거나 벗어났을 때
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 2) {
                    node.dx = -node.dx;
                    node.dy = -node.dy;
                    nx = x + node.dx;
                    ny = y + node.dy;
                }

                // 다시 파란색이거나 벗어났을 때
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 2) {continue;}

                //말 담기
                Deque<Integer> dq = new LinkedList<>();
                while(true) {
                    int temp = chess[x][y].pop();
                    dq.offerFirst(temp);
                    if(temp == horsenum) {break;}
                }

                // 하얀색일 때
                if(graph[nx][ny] == 0) {
                    while(!dq.isEmpty()) {
                        int num = dq.pollFirst();
                        chess[nx][ny].push(num);
                        horselist[num].x = nx;
                        horselist[num].y = ny;
                    }
                    if(chess[nx][ny].size() >= 4) {finish = true;}
                }
                else if(graph[nx][ny] == 1) {
                    while(!dq.isEmpty()) {
                        int num = dq.pollLast();
                        chess[nx][ny].push(num);
                        horselist[num].x = nx;
                        horselist[num].y = ny;
                    }
                    if(chess[nx][ny].size() >= 4) {finish = true;}
                }
            }
            if(finish) {break;}
            time++;
        }

        System.out.println(time <= 1000 ? time : -1);
    }
}
/**
 * N*N
 * 말 K개
 * 말 위에 말 올리기 가능
 * 말 4개 이상이면 끝
 *
 *
 * 흰색
 *      - 위에 쌓기
 * 빨간색
 *      - 위에 거꾸로 쌓기
 * 파란색
 *      - 방향을 반대로 바꾸고 한칸 이동
 *      - 또 만나면 그냥 제자리에 가만히 있기
 *
 */
