package 삼성코테;

/**
 * 사과를 먹으면 뱀 길이가 늘어남
 * 뱀은 벽이나 자기자신과 부딪히면 게임 끝
 * 초기 (1,1) 뱀의 길이 : 1
 *
 * 1) 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킴
 * 2) 벽이나 자기자신과 부딪히면 끝
 * 3) 이동한 칸에 사과가 있다면 사과가 없어지고 꼬리는 움직이지 않음
 * 4) 칸에 사과가 없으면 몸길이 줄이고 꼬리가 위치한 칸을 비움
 *
 * 1) 머리만 일단 이동하고
 * 2) 부딪히면 끝
 * 3) 사과 먹으면 몸길이를 그대로 늘림
 * 4) 사과 아니면 꼬리 칸 비워버려
 *
 */

import java.io.*;
import java.util.*;

public class 뱀 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class Command {
        int cnt;
        char cmd;
        public Command(int cnt, char cmd) {
            this.cnt = cnt;
            this.cmd = cmd;
        }
    }
    public static int N, K, L;
    public static boolean[][] apple;
    public static boolean[][] snake;

    // L, U, R, D
    // L일 경우 i-1  i-1 == -1 i = 4
    // D일 경우 i+1  i+1 == 4  i = 0
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        apple = new boolean[N+1][N+1];

        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apple[x][y] = true;
        }

        L = Integer.parseInt(br.readLine());
        Command[] commands = new Command[L];
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            commands[i] = new Command(cnt, cmd);
        }

        Deque<Node> q = new LinkedList<>();
        snake = new boolean[N+1][N+1];
        snake[1][1] = true;
        q.offerLast(new Node(1, 1));
        int x = 1, y = 1, d = 2;
        int t = 0;
        int time = 1;

        while(true) {
            int nx = q.peekLast().x + dx[d];
            int ny = q.peekLast().y + dy[d];

            // 밖으로 나갔거나 뱀이 있는 경우
            if(nx <= 0 || nx > N || ny <= 0 || ny > N || snake[nx][ny]) {break;}

            // 머리 이동 시킴
            snake[nx][ny] = true;
            q.offerLast(new Node(nx, ny));

            //사과가 있으면 먹어
            if(apple[nx][ny]) {
                apple[nx][ny] = false;
            }
            //사과가 없으면 꼬리 짤라
            else {
                Node end = q.pollFirst();
                snake[end.x][end.y] = false;
            }
            for(int i = t; i < L; i++) {
                if (time == commands[i].cnt) {
                    t++;
                    if(commands[i].cmd == 'L') {
                        d = (d - 1 == -1) ? 3 : d - 1;
                    }
                    else {
                        d = (d + 1 == 4) ? 0 : d + 1;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
