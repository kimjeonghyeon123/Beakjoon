package barking.part11;

/**
 * N개의 도시
 * M개의 버스
 * A -> B 버스 비용 최소화
 *
 */

import java.io.*;
import java.util.*;

class NodeZ implements Comparable<NodeZ> {
    int index, distance;
    public NodeZ(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(NodeZ other) {
        if(distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class 최소비용구하기 {

    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<NodeZ>> graph = new ArrayList<>();
    public static int N, M;
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(x).add(new NodeZ(y, dist));
        }

        d = new int[N+1];
        Arrays.fill(d, INF);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<NodeZ> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new NodeZ(start, 0));

        while(!pq.isEmpty()) {
            NodeZ node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if(d[now] < dist) {continue;}

            for(NodeZ next : graph.get(now)) {
                int cost = d[now] + next.distance;
                if(cost < d[next.index]) {
                    d[next.index] = cost;
                    pq.offer(new NodeZ(next.index, cost));
                }
            }
        }

        return d[end];
    }
}
