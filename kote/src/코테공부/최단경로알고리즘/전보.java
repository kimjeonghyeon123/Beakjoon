package 코테공부.최단경로알고리즘;

import java.io.*;
import java.util.*;

// X -> Y 메시지 가능
// X <- Y 없으면 불가능
// C -> 최대한 많은 도시로 보내
// 메시지를 받는 도시의 개수, 모두 메시지를 받는데 걸리는 시간

class Node1 implements Comparable<Node1> {
    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return index;}
    public int getDistance() {return distance;}

    // 거리가 짧은 것이 우선순위가 높게 설정
    @Override
    public int compareTo(Node1 other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}

public class 전보 {

    public static final int INF = 1001;

    public static int N, M, C;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Node1>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1;
            int Z = Integer.parseInt(st.nextToken());

            graph.get(X).add(new Node1(Y, Z));
        }

        d = new int[N];
        Arrays.fill(d, INF);

        dijkstra(C);

        int a = (int) Arrays.stream(d).filter(value -> value != INF).count() - 1;
        int b = Arrays.stream(d).max().getAsInt();
        System.out.println(a + " " + b);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node1> pq = new PriorityQueue<>();

        pq.offer(new Node1(start, 0));
        d[start] = 0;

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
}
