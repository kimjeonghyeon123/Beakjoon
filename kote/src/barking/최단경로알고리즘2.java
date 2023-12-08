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

class Node1 implements Comparable<Node1> {
    private int index;
    private int distance;
    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return this.index;}
    public int getDistance() {return this.distance;}
    @Override
    public int compareTo(Node1 other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}

public class 최단경로알고리즘2 {

    public static final int INF = (int) 1e9;

    public static int n, m, start;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
    public static int[] d;

    public static void dijkstra(int start) {
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node1(start, 0));

        while(!pq.isEmpty()) {
            Node1 node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
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
            graph.get(a).add(new Node1(b, c));
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        dijkstra(start);
    }
}
