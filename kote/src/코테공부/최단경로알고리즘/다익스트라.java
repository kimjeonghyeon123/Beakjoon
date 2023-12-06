package 코테공부.최단경로알고리즘;

import java.io.*;
import java.util.*;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return index;}
    public int getDistance() {return distance;}
}

/**
 * 노드의 개수가 5000개 이하일 때만 사용
 */
public class 다익스트라 {

    //무한대
    public static final int INF = (int) 1e9;
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드의 연결 정보
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    // 방문 체크 배열
    public static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중, 최단 거리가 가장 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해 초기화
        d[start] = 0;
        visited[start] = true;

        for(int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n-1개으 노드에 대해 반복
        for(int i = 0; i < n-1; i++) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            //현재 노드와 연결된 다른 노드를 확인
            for(int j = 0; j < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i  < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for(int i = 1; i <= n; i++) {
            System.out.println(d[i]);
        }
    }
}
