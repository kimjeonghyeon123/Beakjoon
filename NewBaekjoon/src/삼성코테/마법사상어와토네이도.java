package 삼성코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {

    public static int N;
    public static int[][] graph;
    public static int[] percent = {};
    // 서남동북
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        int total_amount = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                total_amount += graph[i][j];
            }
        }

        int x = N / 2;
        int y = N / 2;
        int d = 0;
        int cnt = 1;
        while(true) {
            boolean isfinish = false;
            for(int i = 0; i < cnt; i++) {
                x += dx[d];
                y += dy[d];

                if (x < 0 || x >= N || y < 0 || y >= N) {
                    isfinish = true;
                    break;
                }


            }

            if(isfinish) {
                break;
            }

            d = (d + 1 == 4) ? 0 : d+1;
            if(d == 0 || d == 2) {
                cnt++;
            }
        }
    }

    public static void move_send(int x, int y, int d) {
        int blow_amount = 0;
        if(d == 0) {
            // 1% 인 곳
            blow_amount += (int)(graph[x][y] / 0.01);
            if(x-1 >= 0) {
                graph[x-1][y-1] = (int)(graph[x][y] / 0.01);
            }
            blow_amount += (int)(graph[x][y] / 0.01);
            if(x+1 >= 0) {
                graph[x-1][y+1] = (int)(graph[x][y] / 0.01);
            }
        }
    }
}
/**
 * 격자 한 가운데서부터 토네이도 이동 시작
 */