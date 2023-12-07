package barking.part10;

import java.io.*;
import java.util.*;
/**
 * 집 N개
 * 집 색칠 : 빨 초 파
 * 1번의 집은 2번의 집과 색이 같지 않아야 함
 * N번의 집은 N-1번의 집과 색이 같지 않아야 함
 * i번의 집은 i-1번 i+1번과 색이 같지 않아야 함
 *
 * 최소 비용
 */
public class RGB거리 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] houses = new int[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] += Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] += Math.min(houses[i-1][0], houses[i-1][1]);
        }

        int min = INF;
        for(int i = 0; i < 3; i++) {
            if(min > houses[N-1][i]) {
                min = houses[N-1][i];
            }
        }

        System.out.println(min);
    }
}