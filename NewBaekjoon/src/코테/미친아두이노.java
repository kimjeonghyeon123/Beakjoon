package 코테;

/**
 * 종수가 아두이노를 9개 방향으로 이동
 *      - 미친 아두이노가 있는 칸으로 이동하면 게임 끝 짐
 * 미친 아두이노는 가까워지는 방향으로 이동
 *      - (r1,s1)   (r2,s2)   |r1-r2| + |s1-s2|
 *      - 종수칸으로 이동하면 끝
 *      - 미친 아두이노가 같은 칸에 있으면 모두 폭발
 */

import java.io.*;
import java.util.*;

public class 미친아두이노 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int R, C;
    public static char[][] graph;
    public static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
    public static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
    public static LinkedList<Node> craze_arduino = new LinkedList<>();
    public static Node arduino;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);

                if(graph[i][j] == 'R') craze_arduino.add(new Node(i, j));
                else if(graph[i][j] == 'I') arduino = new Node(i, j);
            }
        }
        String direction = br.readLine();

        int count = 1;
        boolean is_lose = false;
        for(int k = 0; k < direction.length(); k++) {
            graph[arduino.x][arduino.y] = '.';
            arduino.x = arduino.x + dx[direction.charAt(k) - '0'];
            arduino.y = arduino.y + dy[direction.charAt(k) - '0'];

            if(graph[arduino.x][arduino.y] == 'R') {
                is_lose = true;
                break;
            }
            graph[arduino.x][arduino.y] = 'I';

            if(!move_craze_arduino()) {
                is_lose = true;
                break;
            }
            count++;
        }

        if(is_lose) {
            System.out.println("kraj " + count);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    sb.append(graph[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }

    public static boolean move_craze_arduino() {
        int[][] arduino_count = new int[R][C];

        int craze_arduino_size = craze_arduino.size();
        for(int i = 0; i < craze_arduino_size; i++) {
            Node current = craze_arduino.poll();
            graph[current.x][current.y] = '.';

            int dir = find_close_dir(current);
            int nx = current.x + dx[dir];
            int ny = current.y + dy[dir];

            if(graph[nx][ny] == 'I') return false;
            arduino_count[nx][ny]++;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arduino_count[i][j] == 1) {
                    graph[i][j] = 'R';
                    craze_arduino.add(new Node(i, j));
                }
            }
        }
        return true;
    }

    public static int find_close_dir(Node current) {
        int min = Integer.MAX_VALUE;
        int min_dir = -1;
        for(int i = 1; i <= 9; i++) {
            if(i == 5) {continue;}
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) {continue;}

            int distance = Math.abs(nx - arduino.x) + Math.abs(ny - arduino.y);
            if(min > distance) {
                min = distance;
                min_dir = i;
            }
        }
        return min_dir;
    }
}
