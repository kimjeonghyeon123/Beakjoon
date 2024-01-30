package 삼성코테;

import java.io.*;
import java.util.*;

public class 나무재테크 {
    public static class Node {
        int x, y, age;
        public Node(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static int N, M, K;
    public static int[][] graph;
    public static int[][] A;
    public static Deque<Node> trees = new LinkedList<>();
    public static Stack<Node> deadtree = new Stack<>();
    public static Queue<Node> temp = new LinkedList<>();
    public static int[] dx = {0,0,1,1,1,-1,-1,-1};
    public static int[] dy = {-1,1,-1,0,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        A = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.offer(new Node(x, y, z));
        }

        for(int t = 0; t < K; t++) {
            // 봄
            int size = trees.size();
            for(int i = 0; i < size; i++) {
                Node node = trees.pollFirst();
                int x = node.x;
                int y = node.y;
                int age = node.age;
                if(graph[x][y] >= age) {
                    graph[x][y] -= age;
                    node.age++;
                    trees.offerLast(node);
                }
                else {
                    deadtree.push(node);
                }
            }

            // 여름
            while (!deadtree.isEmpty()) {
                Node node = deadtree.pop();
                graph[node.x][node.y] += (node.age / 2);
            }

            //가을
            size = trees.size();
            for(int i = 0; i < size; i++) {
                Node node = trees.pollFirst();
                if(node.age % 5 == 0) {
                    temp.offer(node);
                }
                trees.offerLast(node);
            }

            while(!temp.isEmpty()) {
                Node node = temp.poll();
                for(int i = 0; i < 8; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        trees.offerFirst(new Node(nx, ny, 1));
                    }
                }
            }

            //겨울
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    graph[i][j] += A[i][j];
                }
            }
        }

        System.out.println(trees.size());
    }
}
/**
 * N * N
 * 모든 칸에 5만큼 들어있음
 *
 * 나무 M개
 *
 * 봄
 * 나무 나이가 1 증가하기 위해 나무 나이만큼 양분을 먹음
 * 하나의 칸에 여러 나무가 있으면 나이가 어린 나무부터 먹음
 * 양분이 부족한 곳은 양분을 먹지 않고 나무가 죽음
 *
 * 여름
 * 봄에 죽은 나무를 양분으로 변화시킴
 * 죽은 나무마다 나이 / 2 만큼 양분 추가
 *
 * 가을
 * 나무 번식 : 나무 나이가 5의 배수여야 됨
 * 인접한 8개의 칸에 나이가 1인 나무가 생김
 *
 * 겨울에는 양분을 추가함
 *
 * K 년 지난 후
 *
 */