package test2;

/**
 *
 * 빌딩은 총 N 개
 * A와 B의 지붕을 잇는 선분이 다른 빌딩을 지나거나 접하지 않아야 함
 * 가장 많은 고층 빌딩이 보이는 빌딩 구하기
 *
 * (1,1) : 1번째 1층짜리
 *                      둘 사이 선분 : y = (y1-y2)/(x1-x2)(x - x1) + y1
 *                      a = (y1-y2)/(x1-x2)
 *                      b = (y1-y2)/(x1-x2) * (-x1) + y1
 * (2,5) : 2번째 5층짜리
 *                      다음 점이 이거보다 커야됨
 */

import java.io.*;
import java.util.*;

public class 고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cansee = new int[N+1];
        int[] buildings = new int[N+1];
        for(int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                int a = (buildings[i] - buildings[j]) / (i - j);
                int b = buildings[i] - (i * a);

                if(a < 0) {

                }
            }
        }
    }
}
