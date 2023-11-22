package 코테공부.구현;

import java.io.*;
import java.util.*;

public class 상하좌우 {

    private static int N;
    private static int[][] graph;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static String[] move = {"L", "R", "U", "D"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = 1, y = 1;
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            for(int i = 0; i < 4; i++) {
                if(move[i].equals(str)) {
                    x += dx[i];
                    y += dy[i];

                    if(x < 1 || x > N || y < 1 || y > N) {
                        x -= dx[i];
                        y -= dy[i];
                    }
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
