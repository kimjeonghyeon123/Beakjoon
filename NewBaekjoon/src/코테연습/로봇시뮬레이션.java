package 코테연습;

import java.io.*;
import java.util.*;

public class 로봇시뮬레이션 {
    public static class Node {
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static int A, B, N, M;
    public static int[][] graph;
    public static Node[] robots;
    //남서북동 L : -1 R : +1
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        graph = new int[A][B];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        robots = new Node[N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int dir = 3;
            if(d == 'E') {
                dir = 0;
            }
            else if(d == 'S') {
                dir = 1;
            }
            else if(d == 'W') {
                dir = 2;
            }
            graph[x][y] = i;
            robots[i] = new Node(x, y, dir);
        }


        boolean crash = false;
        for(int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int iternum = Integer.parseInt(st.nextToken());

            if(crash) {continue;}
            crash = dfs(robotNum, cmd, iternum);
        }
        if(crash) {
            System.out.println(sb.toString());
        }
        else {
            System.out.println("OK");
        }

    }

    public static boolean dfs(int robotNum, char cmd, int iternum) {
        Node robot = robots[robotNum];
        if(cmd == 'L') {
            robot.d = ((robot.d - iternum) % 4 + 4) % 4;
        }
        else if(cmd == 'R') {
            robot.d = (robot.d + iternum) % 4;
        }
        else {
            for(int i = 0; i < iternum; i++) {
                int nx = robot.x + dx[robot.d];
                int ny = robot.y + dy[robot.d];

                if(nx < 0 || nx >= A || ny < 0 || ny >= B) {
                    sb.append("Robot ").append(robotNum).append(" crashes into the wall");
                    return true;
                }
                if(graph[nx][ny] != 0) {
                    sb.append("Robot ").append(robotNum).append(" crashes into robot ").append(graph[nx][ny]);
                    return true;
                }

                graph[robot.x][robot.y] = 0;
                graph[nx][ny] = robotNum;
                robot.x = nx;
                robot.y = ny;
            }
        }
        return false;
    }
}
/**
 * 가로 5, 세로 4
 *
 *
 */