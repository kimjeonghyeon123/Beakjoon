package 삼성코테;

import java.io.*;
import java.util.*;

public class 이차원배열과연산 {
    public static class Node implements Comparable<Node> {
        int num, cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o) {
            if(this.cnt < o.cnt || (this.cnt == o.cnt && this.num < o.num)) {
                return -1;
            }
            return 1;
        }
    }
    public static int r, c, k;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) -1;
        c = Integer.parseInt(st.nextToken()) -1;
        k = Integer.parseInt(st.nextToken());

        int R = 3;
        int C = 3;
        graph = new int[R][C];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        for(int time = 0; time < 100; time++) {
            if(r < R && c < C && graph[r][c] == k) {
                result = time;
                break;
            }

            if(R >= C) {
                PriorityQueue<Node>[] arr = new PriorityQueue[R];
                for(int i = 0; i < R; i++) {
                    arr[i] = new PriorityQueue<>();
                }

                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        int num = graph[i][j];
                        int cnt = 1;
                        if(num == 0) {continue;}

                        // 자연수일 경우
                        for(int k = j+1; k < C; k++) {
                            if(num == graph[i][k]) {
                                graph[i][k] = 0;
                                cnt++;
                            }
                        }

                        arr[i].offer(new Node(num, cnt));
                    }
                }

                int max_length = 0;
                for(int i = 0; i < R; i++) {
                    max_length = Math.max(max_length, arr[i].size());
                }

                C = max_length*2;
                if(C > 100) {C = 100;}
                graph = new int[R][C];
                for(int i = 0; i < R; i++) {
                    int j = 0;
                    while(!arr[i].isEmpty()) {
                        Node node = arr[i].poll();
                        graph[i][j] = node.num;
                        graph[i][j+1] = node.cnt;
                        j += 2;
                        if(j == 100) {break;}
                    }
                }
            }
            else {
                PriorityQueue<Node>[] arr = new PriorityQueue[C];
                for(int i = 0; i < C; i++) {
                    arr[i] = new PriorityQueue<>();
                }

                for(int j = 0; j < C; j++) {
                    for(int i = 0; i < R; i++) {
                        int num = graph[i][j];
                        int cnt = 1;
                        if(num == 0) {continue;}

                        for(int k = i+1; k < R; k++) {
                            if(num == graph[k][j]) {
                                graph[k][j] = 0;
                                cnt++;
                            }
                        }
                        arr[j].offer(new Node(num, cnt));
                    }
                }

                int max_length = 0;
                for(int i = 0; i < C; i++) {
                    max_length = Math.max(max_length, arr[i].size());
                }

                R = max_length * 2;
                if(R > 100) {R = 100;}
                graph = new int[R][C];
                for(int j = 0; j < C; j++) {
                    int i = 0;
                    while(!arr[j].isEmpty()) {
                        Node node = arr[j].poll();
                        graph[i][j] = node.num;
                        graph[i+1][j] = node.cnt;
                        i += 2;
                        if(i == 100) {break;}
                    }
                }
            }
        }

        System.out.println(result);
    }
}
/**
 * 크기  3,3
 *
 * R 연산
 *      배열 A의 모든 행에 대해 정렬 수행
 *      행의 개수 >= 열의 개수
 *
 * C 연산
 *      배열 A의 모든 열에 대해 정렬 수행
 *      열의 개수 > 행의 개수
 *
 * 각각의 수가 몇 번 나왔는지 알아야 함?
 * 등장 횟수가 커지는 순으로 정렬
 * 등장 횟수가 같다면 수가 큰 순으로 정렬
 *
 * 수, 등장횟수
 * 3,1,1,2
 * int num, int cnt
 * [3,1,1]
 * 3,1,1,2
 * 3, 1 1,1 2,
 */