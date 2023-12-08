package barking;

import java.io.*;
import java.util.*;

/**
 * - 다익스트라
 * 특정 노드에서 다른 모든 노드로 가는 최단 경로 계산
 * 음의 간선이 없을 때 사용
 *
 * 1. 출발 노드 설정
 * 2. 최단 거리 테이블 초기화 -> INF로 설정 start노드만 0
 * 3. 방문하지 않은 노드 중 가장 짧은 노드 선택
 * 4. 해당 노드를 거쳐 다른 노드로 가는 비용 계산 테이블 갱신
 * 5. 3,4 번 반복
 */

class Node {
    private int index;
    private int distance;
    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return this.index;}
    public int getDistance() {return this.distance;}
}

public class 최단경로알고리즘 {

    public static final int INF = (int) 1e9;

    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] d;

    public static int getSmallestNode() {
        int min = INF;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(d[i] < min && !visited[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;
        for(int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for(int i = 0; i < n-1; i++) {
            int now = getSmallestNode();

            visited[now] = true;
            for(int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                if(cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        start = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        d = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(d, INF);

        dijkstra(start);
    }
}
