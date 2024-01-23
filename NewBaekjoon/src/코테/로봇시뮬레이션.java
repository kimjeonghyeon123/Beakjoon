package 코테;

/**
 *
 */

import java.io.*;
import java.util.*;

public class 로봇시뮬레이션 {
    public static class Node {
        int x, y, dir;
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static class Node2 {
        int robot_num;
        char cmd;
        int iter_num;
        public Node2(int robot_num, char cmd, int iter_num) {
            this.robot_num = robot_num;
            this.cmd = cmd;
            this.iter_num = iter_num;
        }
    }
    public static int A, B, N, M;
    public static int[][] graph;
    public static Node[] robots;
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        graph = new int[B+1][A+1];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        robots = new Node[N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            if(dir == 'N') {
                robots[i] = new Node(y, x, 0);
            }
            else if(dir == 'W') {
                robots[i] = new Node(y, x, 1);
            }
            else if(dir == 'S') {
                robots[i] = new Node(y, x, 2);
            }
            else if(dir == 'E') {
                robots[i] = new Node(y, x, 3);
            }
            graph[y][x] = i;
        }

        Node2[] arr = new Node2[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robot_num = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int iter_num = Integer.parseInt(st.nextToken());
            arr[i] = new Node2(robot_num, cmd, iter_num);
        }

        for(int i = 0; i < M; i++) {
            int robot_num = arr[i].robot_num;
            char cmd = arr[i].cmd;
            int iter_num = arr[i].iter_num;
            if (cmd == 'L') {
                for(int j = 0; j < iter_num; j++) {
                    robots[robot_num].dir++;
                    if(robots[robot_num].dir == 4) {
                        robots[robot_num].dir = 0;
                    }
                }
            }
            else if (cmd == 'R') {
                for(int j = 0; j < iter_num; j++) {
                    robots[robot_num].dir--;
                    if(robots[robot_num].dir == -1) {
                        robots[robot_num].dir = 3;
                    }
                }
            }
            else {
                for(int j = 0; j < iter_num; j++) {
                    Node node = robots[robot_num];
                    int nx = node.x + dx[node.dir];
                    int ny = node.y + dy[node.dir];
                    if(nx <= 0 || nx > B || ny <= 0 || ny > A) {
                        System.out.println("Robot " + robot_num + " crashes into the wall");
                        return;
                    }
                    if(graph[nx][ny] != 0) {
                        System.out.println("Robot " + robot_num + " crashes into robot " + graph[nx][ny]);
                        return;
                    }
                    graph[node.x][node.y] = 0;
                    graph[nx][ny] = robot_num;
                    node.x = nx;
                    node.y = ny;
                }
            }
        }
        System.out.println("OK");
    }
}
