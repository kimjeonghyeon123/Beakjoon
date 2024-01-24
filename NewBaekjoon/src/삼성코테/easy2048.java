package 삼성코테;

import java.io.*;
import java.util.*;

/**
 * 4*4
 * 전체 블록이 상하좌우 방향으로 이동
 * 같은 값을 가지는 두 블록이 충돌하면 하나로 합쳐짐
 *
 * 벽이 나올 때까지 이동
 * 숫자가 나오면 멈춤 같으면 이미 합쳐진 것인지 확인 후 아니면 합침
 *
 * 1) 왼쪽으로 이동
 *      맨 왼쪽에 있는 것부터 이동?
 */
public class easy2048 {
    public static int n, answer;
    public static int[][] map;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(answer);
    }

    public static void game(int count) {
        if(count == 5) {
            findMax();
        }
        int copy[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        // 4가지 방향으로 이동
        for(int i = 0; i < 4; i++) {
            // 이동
            move(i);
            // 다음 회차
            game(count+1);
            // 다시 원래 배열로 되돌리기
            for(int a = 0; a < n; a++) {
                map[a] = copy[a].clone();
            }
        }
    }

    public static void move(int dir) {
        switch (dir) {
            // 위 방향
            case 0:
                // 열
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    // 행
                    for(int j = 0; j < n; j++) {
                        // i열의 j번째 행이 0이 아니면
                        if(map[j][i] != 0) {
                            // i열의 j번째 행이 block과 같으면
                            // index-1번째 행의 값을 곱함
                            if(block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            // i열의 j번째 행이 block과 다르면
                            // block에 값을 저장함
                            // index의 값을 더함
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    public static void findMax() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}
