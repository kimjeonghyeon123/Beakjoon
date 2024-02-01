package 삼성코테;

import java.io.*;
import java.util.*;

public class 마법사상어와파이어볼 {
    public static class FireBall {
        int r,c,m,s;
        ArrayList<Integer> direction_list = new ArrayList<>();
        public FireBall(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            direction_list.add(d);
            this.s = s;
        }
    }
    public static int N, M, K;
    public static FireBall[][] graph;
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new FireBall[N][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            graph[r][c] = new FireBall(r,c,m,d,s);
        }

        for(int t = 0; t < K; t++) {
            Queue<FireBall> fireBalls = new LinkedList<>();

            // 파이어볼 담기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(graph[i][j] != null) {
                        for(int d : graph[i][j].direction_list) {
                            fireBalls.offer(new FireBall(i, j, graph[i][j].m, d, graph[i][j].s));
                        }
                    }
                }
            }

            //새로운 판 만들기
            graph = new FireBall[N][N];
            while(!fireBalls.isEmpty()) {
                FireBall fireBall = fireBalls.poll();
                int d = fireBall.direction_list.get(0);
                int nx = fireBall.r + fireBall.s * dx[d];
                int ny = fireBall.c + fireBall.s * dy[d];

                if(nx < 0) {
                    nx = 0;
                }
                else if(nx >= N) {
                    nx = N-1;
                }
                if(ny < 0) {
                    ny = 0;
                }
                else if(ny >= N) {
                    ny = N-1;
                }

                if(graph[nx][ny] == null) {
                    graph[nx][ny] = new FireBall(nx, ny, fireBall.m, d, fireBall.s);
                }
                else {
                    graph[nx][ny].direction_list.add(d);
                    graph[nx][ny].m += fireBall.m;
                    graph[nx][ny].s += fireBall.s;
                }
            }

            // 파이어볼 정리하기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(graph[i][j] == null) {continue;}

                    int size = graph[i][j].direction_list.size();

                    graph[i][j].m /= 5;
                    if(graph[i][j].m == 0) {
                        graph[i][j] = null;
                        continue;
                    }
                    graph[i][j].s /= size;

                    // 첫번째 수를 나누고 남은 수
                    int rest = graph[i][j].direction_list.get(0) % 2;
                    boolean isSame = true;
                    for(int l = 1; l < size; l++) {
                        if(rest != graph[i][j].direction_list.get(l) % 2) {
                            isSame = false;
                            break;
                        }
                    }

                    graph[i][j].direction_list.clear();
                    if(isSame) {
                        for(int l = 0; l <= 6; l += 2) {
                            graph[i][j].direction_list.add(l);
                        }
                    }
                    else {
                        for(int l = 1; l <= 7; l += 2) {
                            graph[i][j].direction_list.add(l);
                        }
                    }
                }
            }
        }

        System.out.println("==================");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == null) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(graph[i][j].m + " ");
                }
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == null) {continue;}
                sum += (graph[i][j].m * 4);
            }
        }
        System.out.println(sum);
    }
}
/**
 * 1) 모든 파이어볼이 자신의 방향으로 si만큼 이동
 * 2) 이동 끝난 후 같은 칸에 있는 파이어볼은 하나로 합쳐짐
 *      - 질량 = 질량의 합 / 5
 *      - 속력 = 속력의 합 / 합쳐진 개수
 *      - 합쳐진 파이어볼의 방향은 몯 홀수이거나 짝수이면 0,2,4,6이 됨, 아니면 1,3,5,7이 됨
 * 4) 질량이 0인 파이어볼은 소멸되어 없어짐
 */