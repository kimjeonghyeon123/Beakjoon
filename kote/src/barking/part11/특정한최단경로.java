package barking.part11;

/**
 * 1 -> N 방향으로 최단 거리 이동
 * 임의의 두 정점은 반드시 통과
 */

import java.io.*;
import java.util.*;

class NodeX implements Comparable<NodeX> {
    int index, distance;
    public NodeX(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeX other) {
        if(distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class 특정한최단경로 {

    public static final int INF = (int) 1e8;
    public static ArrayList<ArrayList<NodeX>> graph = new ArrayList<>();
    public static int N, E;
    public static int[] d;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(x).add(new NodeX(y, dist));
            graph.get(y).add(new NodeX(x, dist));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        if(result1 >= INF && result2 >= INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(result1, result2));
        }
    }

    public static int dijkstra(int start, int end) {
        d = new int[N+1];
        Arrays.fill(d, INF);
        d[start] = 0;
        PriorityQueue<NodeX> pq = new PriorityQueue<>();
        pq.offer(new NodeX(start, 0));

        while(!pq.isEmpty()) {
            NodeX node = pq.poll();

            int dist = node.distance;
            int now = node.index;

            if(d[now] < dist) {continue;}

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;

                if(cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new NodeX(graph.get(now).get(i).index, cost));
                }
            }
        }

        return d[end];
    }
}
