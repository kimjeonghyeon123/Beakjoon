package 삼성코테;

import java.io.*;
import java.util.*;

public class 치킨배달 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static int[][] graph;
    public static ArrayList<Node> chickenList = new ArrayList<>();
    public static ArrayList<Node> chickens = new ArrayList<>();
    public static ArrayList<Node> homeList = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    homeList.add(new Node(i, j));
                }
                else if(graph[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        for(int i = 0; i < chickenList.size(); i++) {
            chickens.add(chickenList.get(i));
            dfs(i, 1);
            chickens.remove(0);
        }
        System.out.println(min);
    }

    //depth : 치킨 집 고른 수
    public static void dfs(int start, int depth) {
        find_chicken_distance();
        if(depth == M) {return;}

        for(int i = start+1; i < chickenList.size(); i++) {
            chickens.add(chickenList.get(i));
            dfs(i, depth+1);
            chickens.remove(depth);
        }
    }

    public static void find_chicken_distance() {
        int result = 0;
        for(Node home : homeList) {
            int tempmin = Integer.MAX_VALUE;
            for(Node chicken : chickens) {
                tempmin = Math.min(tempmin, Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y));
            }
            result += tempmin;
        }
        min = Math.min(min, result);
    }
}
/**
 * N * N 도시
 * 칸 종류 : 빈칸 0 , 집 1, 치킨집 2
 *
 * 치킨 거리
 *      - 집과 가장 가까운 치킨집 사이의 거리
 * for문 집 좌표 돌려
 *          for 문 치킨집 좌표 돌려
 *                 min 구해
 *
 * 최대 m개 고르고 나머지 치킨 집 폐업
 * 도시의 치킨 거리가 가장 작게되는 방법 구해라
 */