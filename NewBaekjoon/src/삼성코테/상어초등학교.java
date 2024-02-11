package 삼성코테;

import java.io.*;
import java.util.*;

public class 상어초등학교 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N;
    public static int[][] graph;
    public static int[] order;
    public static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static Node move_node;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        order = new int[N+1];
        for(int i = 0; i <= N*N; i++) {
            list.add(new HashSet<>());
        }

        for(int i = 1; i <= N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            while(st.hasMoreTokens()) {
                list.get(num).add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int k = 1; k <= N*N; k++) {
            int now_num = order[k];

            dfs(now_num);
        }
    }

    public static void dfs(int now_num) {

        // 내가 좋아하는 학생 담고 있는 세트
        Set<Integer> now_set = list.get(now_num);


        move_node = new Node(0, 0);
        max = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 0) {

                }
            }
        }

    }
}
/**
 * 교실 : N * N
 * 학생 수 : N^2
 *
 * 각 학생이 좋아하는 학생 4명
 * 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 정함
 * 2. 1을 만족하는 칸이 여러개이면 인접한 칸 중 비어있는 칸이 가장 많은 자리로
 * 3. 2를 만족한는 칸이 여러개이면 행의 번호가 작은칸, 열의 번호가 작은칸으로 이동
 *
 */